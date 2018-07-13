/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgraficametodos;

import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Héctor
 */
public class Metodos {

    public static int Factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * Factorial(n - 1);
    }

    public double[][] gaussJordan(int m, double mat[][]) {

        for (int cont = 0; cont < (m); cont++)//renglon pivote
        {

            if (mat[cont][cont] != 1) {
                double aux = mat[cont][cont];
                for (int j = 0; j < (m + 1); j++)//hacer 1 el renglon 
                {
                    mat[cont][j] = mat[cont][j] / aux;
                }
            }
            for (int i = 0; i < m; i++)//renglon a eliminar
            {
                if (i != cont) {
                    double n = mat[i][cont];
                    for (int j = 0; j < (m + 1); j++)//elemento a eliminar
                    {
                        mat[i][j] = mat[i][j] - (n * mat[cont][j]);
                    }
                }
            }
        }

        return mat;
    }

    public double[] Result(int m, double[][] mat) {
        double[] x = new double[m];
        for (int i = (m - 1); i >= 0; i--) {
            double sumatoria = 0;
            for (int j = (m - 1); j > i; j--) {
                sumatoria = sumatoria + mat[i][j] * x[j];
            }
            x[i] = (mat[i][m] - sumatoria) / mat[i][i];

        }
        return x;
    }

    public void aproximaciones(JTextField jTextField1, JTextField jTextField2, JTextField jTextField4, JTextField jTextField5, JTable tablaNewton, JTextField jTextField6, JPanel panelFuncion) {

        Ecuacion ecu = new Ecuacion();
        try {
            double s;
            String fx = jTextField1.getText();
            String gx = jTextField1.getText() + "+x";
            double xi = Double.parseDouble(jTextField2.getText());
            double e = Double.parseDouble(jTextField4.getText());
            int rep = Integer.parseInt(jTextField5.getText());

            double error;
            int i = 1;
            double xi1;
            // System.out.println(PonBlancos("i") + "" + PonBlancos("x(i)") + "" + PonBlancos("g(xi)") + "" + PonBlancos("e") + "" + PonBlancos("f(xi)"));

            DefaultTableModel modelo = new DefaultTableModel();
            Vector valoresI = new Vector();
            Vector valoresXI = new Vector();
            Vector valoresGXI = new Vector();
            Vector valoresE = new Vector();
            Vector valoresFXI = new Vector();
            do {
                xi1 = ecu.ecuacion(gx, xi);
                error = Math.abs(xi1 - xi);

                valoresI.add(i);
                valoresXI.add(xi);
                valoresGXI.add(ecu.ecuacion(gx, xi));
                valoresE.add(error);
                valoresFXI.add(ecu.ecuacion(fx, xi));
                xi = xi1;
                i++;
            } while (error > e && i <= rep);
            modelo.addColumn("i", valoresI);
            modelo.addColumn("Xi", valoresXI);
            modelo.addColumn("g(Xi)", valoresGXI);
            modelo.addColumn("e", valoresE);
            modelo.addColumn("f(Xi)", valoresFXI);

            tablaNewton.setModel(modelo);

            tablaNewton.updateUI();
            jTextField6.setText(" " + xi1);

            int minX = -5;
            int maxX = 5;

            JFreeChart chart;

            // Crea un  XY chart
            XYSeries series = new XYSeries(gx + "=0");
            XYSeries seriesx = new XYSeries("Eje x");
            XYSeries seriesy = new XYSeries("Eje y");

            for (int j = minX; j <= maxX; j++) {
                series.add(j, ecu.ecuacion(gx, j));
                seriesx.add(j, 0);
            }
            for (int k = 0; k <= ecu.ecuacion(gx, maxX); k++) {
                seriesy.add(0, k);
            }

            // Agrega las series
            XYSeriesCollection dataset = new XYSeriesCollection();

            dataset.addSeries(series);
            dataset.addSeries(seriesx);
            dataset.addSeries(seriesy);

            // Genera el grafico
            chart = ChartFactory.createXYLineChart(
                    "Función: " + fx, // Titulo
                    "Eje X", // etiqueta en el eje x
                    "Eje Y", // etiqueta en el eje y
                    dataset, // configuracion de las funciones
                    PlotOrientation.VERTICAL, // Orientacion de la grafica
                    true, // muestra las leyendas
                    true, // usar tooltips
                    false // generar urls
            );

            ChartPanel panel = new ChartPanel(chart);
            panel.setSize(364, 222);
            panel.removeAll();
            panelFuncion.add(panel);
            panel.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir valores validos");
        }
    }

    public void newton2(JTextField jTextField1, JTextField jTextField2, JTextField jTextField4, JTextField jTextField5, JTable tablaNewton, JTextField jTextField6, JPanel panelFuncion) {

        Ecuacion ecu = new Ecuacion();
        try {
            Derivada deri = new Derivada();

            String ec;
            ec = jTextField1.getText();
            double p1;
            p1 = Double.parseDouble(jTextField2.getText());

            double err;
            err = Double.parseDouble(jTextField4.getText());
            int iter;
            iter = Integer.parseInt(jTextField5.getText());

            String der = deri.derivada(ec);
            String der2 = deri.derivada(der);
            double xi = p1;
            int i = 1;
            int r = 0;
            double error = Double.NaN;
            double xi1;
            System.out.println();
            // System.out.println(PonBlancos("i") + "" + PonBlancos("xi") + "" + PonBlancos("f(xi)") + "" + PonBlancos("f'(xi)") + "" + PonBlancos("xi+1") + "" + PonBlancos("e"));
            DefaultTableModel modelo = new DefaultTableModel();

            Vector valoresI = new Vector();
            Vector valoresXI = new Vector();
            Vector valoresFXI = new Vector();
            Vector valoresFFXI = new Vector();
            Vector valoresFFFXI = new Vector();
            Vector valoresXI1 = new Vector();
            Vector valoresFXI1 = new Vector();
            Vector valoresE = new Vector();
            do {

                xi1 = xi - (ecu.ecuacion(ec, xi) / (ecu.ecuacion(der, xi) - ((ecu.ecuacion(ec, xi) * ecu.ecuacion(der2, xi)) / (2 * ecu.ecuacion(der, xi)))));
                error = Math.abs(xi1 - xi);

                valoresI.add(i);
                valoresXI.add(xi);
                valoresFXI.add(ecu.ecuacion(ec, xi));
                valoresFFXI.add(ecu.ecuacion(der, xi));
                valoresFFFXI.add(ecu.ecuacion(der2, xi1));
                valoresXI1.add(xi1);
                valoresFXI1.add(ecu.ecuacion(ec, xi1));
                valoresE.add(error);

                xi = xi1;

                i++;
                r++;
            } while (error > err && r < iter);
            modelo.addColumn("i", valoresI);
            modelo.addColumn("X1", valoresXI);
            modelo.addColumn("f(Xi)", valoresFXI);
            modelo.addColumn("f'(Xi)", valoresFFXI);
            modelo.addColumn("f''(Xi)", valoresFFFXI);
            modelo.addColumn("Xi+1", valoresXI1);
            modelo.addColumn("f(Xi+1)", valoresFXI1);
            modelo.addColumn("e", valoresE);
            jTextField6.setText("" + xi1);

            tablaNewton.setModel(modelo);
            tablaNewton.updateUI();

            int minX = -5;
            int maxX = 5;

            JFreeChart chart;

            // Crea un  XY chart
            XYSeries series = new XYSeries(ec + "=0");
            XYSeries seriesx = new XYSeries("Eje x");
            XYSeries seriesy = new XYSeries("Eje y");

            for (int j = minX; j <= maxX; j++) {
                series.add(j, ecu.ecuacion(ec, j));
                seriesx.add(j, 0);
            }
            for (int k = 0; k <= ecu.ecuacion(ec, maxX); k++) {
                seriesy.add(0, k);
            }

            // Agrega las series
            XYSeriesCollection dataset = new XYSeriesCollection();

            dataset.addSeries(series);
            dataset.addSeries(seriesx);
            dataset.addSeries(seriesy);

            // Genera el grafico
            chart = ChartFactory.createXYLineChart(
                    "Función: " + ec, // Titulo
                    "Eje X", // etiqueta en el eje x
                    "Eje Y", // etiqueta en el eje y
                    dataset, // configuracion de las funciones
                    PlotOrientation.VERTICAL, // Orientacion de la grafica
                    true, // muestra las leyendas
                    true, // usar tooltips
                    false // generar urls
            );

            ChartPanel panel = new ChartPanel(chart);
            panel.setSize(364, 222);
            panel.removeAll();
            panelFuncion.add(panel);
            panel.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir valores validos");
        }

    }

    public void newton1(JTextField jTextField1, JTextField jTextField2, JTextField jTextField4, JTextField jTextField5, JTable tablaNewton, JTextField jTextField6, JPanel panelFuncion) {

        Ecuacion ecu = new Ecuacion();
        try {
            Derivada deri = new Derivada();

            String ec = jTextField1.getText();
            double xi = Double.parseDouble(jTextField2.getText());
            double err = Double.parseDouble(jTextField4.getText());
            int iter = Integer.parseInt(jTextField5.getText());
            String der = deri.derivada(ec);

            int i = 1;
            int r = 0;
            double error = Double.NaN;
            double xi1 = Double.NaN;
            //System.out.println();
            //System.out.println(PonBlancos("i") + "" + PonBlancos("xi") + "" + PonBlancos("f(xi)") + "" + PonBlancos("f'(xi)") + "" + PonBlancos("xi+1") + "" + PonBlancos("e"));
            DefaultTableModel modelo = new DefaultTableModel();

            Vector valoresI = new Vector();
            Vector valoresXI = new Vector();
            Vector valoresFXI = new Vector();
            Vector valoresDXI = new Vector();
            Vector valoresXI1 = new Vector();
            Vector valoresE = new Vector();
            do {
                //System.out.println(PonBlancos(i + "") + "" + PonBlancos(xi + "") + "" + PonBlancos(ecu.ecuacion(ec, xi) + "") + "" + PonBlancos(ecu.ecuacion(der, xi) + "") + "" + PonBlancos(xi1 + "") + "" + PonBlancos(error + ""));
                xi1 = xi - (ecu.ecuacion(ec, xi) / ecu.ecuacion(der, xi));
                error = Math.abs(xi1 - xi);
                valoresI.add(i);
                valoresXI.add(xi);
                valoresFXI.add(ecu.ecuacion(ec, xi));
                valoresDXI.add(ecu.ecuacion(der, xi));
                valoresXI1.add(xi1);
                valoresE.add(error);

                xi = xi1;
                i++;
                r++;
            } while (error > err && r < iter);

            modelo.addColumn("i", valoresI);
            modelo.addColumn("Xi", valoresXI);
            modelo.addColumn("f(Xi)", valoresFXI);
            modelo.addColumn("f'(Xi)", valoresDXI);
            modelo.addColumn("xi+1", valoresXI1);
            modelo.addColumn("e", valoresE);

            jTextField6.setText("" + xi1);

            tablaNewton.setModel(modelo);
            tablaNewton.updateUI();

            int minX = -5;
            int maxX = 5;

            JFreeChart chart;

            // Crea un  XY chart
            XYSeries series = new XYSeries(ec + "=0");
            XYSeries seriesx = new XYSeries("Eje x");
            XYSeries seriesy = new XYSeries("Eje y");

            for (int j = minX; j <= maxX; j++) {
                series.add(j, ecu.ecuacion(ec, j));
                seriesx.add(j, 0);
            }
            for (int k = 0; k <= ecu.ecuacion(ec, maxX); k++) {
                seriesy.add(0, k);
            }

            // Agrega las series
            XYSeriesCollection dataset = new XYSeriesCollection();

            dataset.addSeries(series);
            dataset.addSeries(seriesx);
            dataset.addSeries(seriesy);

            // Genera el grafico
            chart = ChartFactory.createXYLineChart(
                    "Función: " + ec, // Titulo
                    "Eje X", // etiqueta en el eje x
                    "Eje Y", // etiqueta en el eje y
                    dataset, // configuracion de las funciones
                    PlotOrientation.VERTICAL, // Orientacion de la grafica
                    true, // muestra las leyendas
                    true, // usar tooltips
                    false // generar urls
            );

            ChartPanel panel = new ChartPanel(chart);
            panel.setSize(364, 222);
            panel.removeAll();
            panelFuncion.add(panel);
            panel.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir valores validos");
        }

    }

    public void secante(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5, JTable tablaBiseccion, JTextField jTextField6, JPanel panelFuncion) {
        Ecuacion ecu = new Ecuacion();
        try {
            double s;

            String ec = jTextField1.getText();
            double xi = Double.parseDouble(jTextField2.getText());
            double xi1 = Double.parseDouble(jTextField3.getText());
            double err = Double.parseDouble(jTextField4.getText());
            int iter = Integer.parseInt(jTextField5.getText());

            double error = 0.0;
            double xi2;
            DefaultTableModel modelo = new DefaultTableModel();

            Vector valoresI = new Vector();
            Vector valoresXI = new Vector();
            Vector valoresXI1 = new Vector();
            Vector valoresFXI = new Vector();
            Vector valoresFXI1 = new Vector();
            Vector valoresXI2 = new Vector();
            Vector valoresE = new Vector();
            Vector valoresFXI2 = new Vector();
            int i = 1;
            int r = 0;
            do {
                xi2 = xi1 - ((ecu.ecuacion(ec, xi1) * (xi1 - xi)) / (ecu.ecuacion(ec, xi1) - (ecu.ecuacion(ec, xi))));
                error = Math.abs(xi2 - xi1);
                valoresI.add(i);
                valoresXI.add(xi);
                valoresXI1.add(xi1);
                valoresFXI.add(ecu.ecuacion(ec, xi));
                valoresFXI1.add(ecu.ecuacion(ec, xi1));
                valoresXI2.add(xi2);
                valoresE.add(error);
                valoresFXI2.add(ecu.ecuacion(ec, xi2));
                xi = xi1;
                xi1 = xi2;

                i++;
                r++;
            } while (error > err && r < iter);
            modelo.addColumn("i", valoresI);
            modelo.addColumn("X1", valoresXI);
            modelo.addColumn("Xi+1", valoresXI1);
            modelo.addColumn("f(Xi)", valoresFXI);
            modelo.addColumn("f(Xi+1)", valoresFXI1);
            modelo.addColumn("Xi+2", valoresXI2);
            modelo.addColumn("e", valoresE);
            modelo.addColumn("f(Xi+2)", valoresFXI2);

            tablaBiseccion.setModel(modelo);
            tablaBiseccion.updateUI();
            jTextField6.setText("" + xi2);

            int minX = -5;
            int maxX = 5;

            JFreeChart chart;

            // Crea un  XY chart
            XYSeries series = new XYSeries(ec + "=0");
            XYSeries seriesx = new XYSeries("Eje x");
            XYSeries seriesy = new XYSeries("Eje y");

            for (int j = minX; j <= maxX; j++) {
                series.add(j, ecu.ecuacion(ec, j));
                seriesx.add(j, 0);
            }
            for (int k = 0; k <= ecu.ecuacion(ec, maxX); k++) {
                seriesy.add(0, k);
            }

            // Agrega las series
            XYSeriesCollection dataset = new XYSeriesCollection();

            dataset.addSeries(series);
            dataset.addSeries(seriesx);
            dataset.addSeries(seriesy);

            // Genera el grafico
            chart = ChartFactory.createXYLineChart(
                    "Función: " + ec, // Titulo
                    "Eje X", // etiqueta en el eje x
                    "Eje Y", // etiqueta en el eje y
                    dataset, // configuracion de las funciones
                    PlotOrientation.VERTICAL, // Orientacion de la grafica
                    true, // muestra las leyendas
                    true, // usar tooltips
                    false // generar urls
            );

            ChartPanel panel = new ChartPanel(chart);
            panel.setSize(364, 222);
            panel.removeAll();
            panelFuncion.add(panel);
            panel.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir valores validos");
        }
    }

    public void falsaPosicion(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5, JTable tablaBiseccion, JTextField jTextField6, JPanel panelFuncion) {
        Ecuacion ecu = new Ecuacion();
        try {
            String ec = jTextField1.getText();
            double x1 = Double.parseDouble(jTextField2.getText());
            double x2 = Double.parseDouble(jTextField3.getText());
            double err = Double.parseDouble(jTextField4.getText());
            int iter = Integer.parseInt(jTextField5.getText());
            if (ecu.ecuacion(ec, x1) * ecu.ecuacion(ec, x2) > 0) {
                JOptionPane.showMessageDialog(null, "Error de rangos, vuelva a introducirlos.");
            } else {

                int r = 0;
                double error = 0;
                double xi1 = 0;

                DefaultTableModel modelo = new DefaultTableModel();
                Vector valoresI = new Vector();
                Vector valoresXI = new Vector();
                Vector valoresFXI = new Vector();
                Vector valoresXIX1 = new Vector();
                Vector valoresFXIX1 = new Vector();
                Vector valoresXI1 = new Vector();
                Vector valoresE = new Vector();
                Vector valoresFXI1 = new Vector();

                valoresI.add(r + 1);
                valoresXI.add(x1);
                valoresFXI.add(ecu.ecuacion(ec, x1));
                valoresXIX1.add(x1 - x1);
                valoresFXIX1.add((ecu.ecuacion(ec, x1) - ecu.ecuacion(ec, x1)));
                valoresXI1.add("");
                valoresE.add("");
                valoresFXI1.add("");
                do {
                    xi1 = x2 - ((ecu.ecuacion(ec, x2) * (x2 - x1)) / (ecu.ecuacion(ec, x2) - ecu.ecuacion(ec, x1)));
                    error = Math.abs(xi1 - x2);
                    valoresI.add(r + 2);
                    valoresXI.add(x2);
                    valoresFXI.add(ecu.ecuacion(ec, x2));
                    valoresXIX1.add(x2 - x1);
                    valoresFXIX1.add((ecu.ecuacion(ec, x2) - ecu.ecuacion(ec, x1)));
                    valoresXI1.add(xi1);
                    valoresE.add(error);
                    valoresFXI1.add(ecu.ecuacion(ec, xi1));

                    x2 = xi1;
                    r++;
                } while (Math.abs(error) > err && r < iter);

                modelo.addColumn("i", valoresI);
                modelo.addColumn("Xi", valoresXI);
                modelo.addColumn("f(Xi)", valoresFXI);
                modelo.addColumn("Xi-X1", valoresXIX1);
                modelo.addColumn("f(Xi-X1)", valoresFXIX1);
                modelo.addColumn("Xi+1", valoresXI1);
                modelo.addColumn("e", valoresE);
                modelo.addColumn("f(Xi+1)", valoresFXI1);

                tablaBiseccion.setModel(modelo);
                tablaBiseccion.updateUI();

                jTextField6.setText("" + xi1);

                int minX = -5;
                int maxX = 5;

                JFreeChart chart;

                // Crea un  XY chart
                XYSeries series = new XYSeries(ec + "=0");
                XYSeries seriesx = new XYSeries("Eje x");
                XYSeries seriesy = new XYSeries("Eje y");

                for (int j = minX; j <= maxX; j++) {
                    series.add(j, ecu.ecuacion(ec, j));
                    seriesx.add(j, 0);
                }
                for (int k = 0; k <= ecu.ecuacion(ec, maxX); k++) {
                    seriesy.add(0, k);
                }

                // Agrega las series
                XYSeriesCollection dataset = new XYSeriesCollection();

                dataset.addSeries(series);
                dataset.addSeries(seriesx);
                dataset.addSeries(seriesy);

                // Genera el grafico
                chart = ChartFactory.createXYLineChart(
                        "Función: " + ec, // Titulo
                        "Eje X", // etiqueta en el eje x
                        "Eje Y", // etiqueta en el eje y
                        dataset, // configuracion de las funciones
                        PlotOrientation.VERTICAL, // Orientacion de la grafica
                        true, // muestra las leyendas
                        true, // usar tooltips
                        false // generar urls
                );

                ChartPanel panel = new ChartPanel(chart);
                panel.setSize(364, 222);
                panel.removeAll();
                panelFuncion.add(panel);
                panel.updateUI();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir valores validos");
        }

    }

    public void biseccion(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5, JTable tablaBiseccion, JTextField jTextField6, JPanel panelFuncion) {
        Ecuacion ecu = new Ecuacion();
        try {
            double s;
            String ec = jTextField1.getText();
            double a = Double.parseDouble(jTextField2.getText());
            double b = Double.parseDouble(jTextField3.getText());

            if (ecu.ecuacion(ec, a) * ecu.ecuacion(ec, b) > 0) {
                JOptionPane.showMessageDialog(null, "Error de rangos, vuelva a introducirlos.");
            } else {

                double e = Double.parseDouble(jTextField4.getText());
                int rep = Integer.parseInt(jTextField5.getText());

                int i = 1, r = 0;
                DefaultTableModel modelo = new DefaultTableModel();

                Vector valoresI = new Vector();
                Vector valoresA = new Vector();
                Vector valoresB = new Vector();
                Vector valoresBA = new Vector();
                Vector valoresS = new Vector();
                Vector valoresFuncionA = new Vector();
                Vector valoresFuncionS = new Vector();
                do {
                    s = (a + b) / 2;
                    valoresI.add(i);
                    valoresA.add(a);
                    valoresB.add(b);
                    valoresBA.add(b - a);
                    valoresS.add(s);
                    valoresFuncionA.add(ecu.ecuacion(ec, a));
                    valoresFuncionS.add(ecu.ecuacion(ec, s));
                    if (ecu.ecuacion(ec, s) == 0) {
                        System.out.println(s);
                    } else if (ecu.ecuacion(ec, a) * ecu.ecuacion(ec, s) < 0) {
                        b = s;
                    } else {
                        a = s;
                    }
                    i++;
                    r++;
                } while (Math.abs(b - a) > e && r < rep);
                modelo.addColumn("i", valoresI);
                modelo.addColumn("X1", valoresA);
                modelo.addColumn("X2", valoresB);
                modelo.addColumn("X2-X1", valoresBA);
                modelo.addColumn("Xm", valoresS);
                modelo.addColumn("f(X1)", valoresFuncionA);
                modelo.addColumn("f(Xm)", valoresFuncionS);

                jTextField6.setText("" + s);
                tablaBiseccion.setModel(modelo);

                tablaBiseccion.updateUI();

                int minX = -5;
                int maxX = 5;

                JFreeChart chart;

                // Crea un  XY chart
                XYSeries series = new XYSeries(ec + "=0");
                XYSeries seriesx = new XYSeries("Eje x");
                XYSeries seriesy = new XYSeries("Eje y");

                for (int j = minX; j <= maxX; j++) {
                    series.add(j, ecu.ecuacion(ec, j));
                    seriesx.add(j, 0);
                }
                for (int k = 0; k <= ecu.ecuacion(ec, maxX); k++) {
                    seriesy.add(0, k);
                }

                // Agrega las series
                XYSeriesCollection dataset = new XYSeriesCollection();

                dataset.addSeries(series);
                dataset.addSeries(seriesx);
                dataset.addSeries(seriesy);

                // Genera el grafico
                chart = ChartFactory.createXYLineChart(
                        "Función: " + ec, // Titulo
                        "Eje X", // etiqueta en el eje x
                        "Eje Y", // etiqueta en el eje y
                        dataset, // configuracion de las funciones
                        PlotOrientation.VERTICAL, // Orientacion de la grafica
                        true, // muestra las leyendas
                        true, // usar tooltips
                        false // generar urls
                );

                ChartPanel panel = new ChartPanel(chart);
                panel.setSize(364, 222);
                panel.removeAll();
                panelFuncion.add(panel);
                panel.updateUI();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir valores validos");
        }

    }

    public void Gauss(int inco, JTable tablaGauss, JTable tablaAumentada, JTextField incognitas, JTextArea jTextArea1, DefaultTableModel modelo2) {

        try {
            inco = Integer.parseInt(incognitas.getText());
            modelo2 = new DefaultTableModel();
            modelo2.setRowCount(inco);
            modelo2.setColumnCount(inco + 1);

            double m[][] = new double[inco][inco + 1];

            for (int i = 0; i < inco; i++) {
                for (int j = 0; j < inco + 1; j++) {
                    m[i][j] = Double.parseDouble(String.valueOf(tablaGauss.getValueAt(i, j)));
                }

            }
            Determinante d = new Determinante();
            if (d.determinante(m) == 0) {
                JOptionPane.showMessageDialog(null, "El sistema tiene infinitas soluciones o no tiene solucion");
            } else {

                if (m.length == 0) {
                    JOptionPane.showMessageDialog(null, "Favor de rellenar la matriz propuesta");
                }

                double[][] matriztriangularsuperior = m;
                double fm;
                for (int k = 0; k < inco - 1; k++) {
                    for (int i = k + 1; i < inco; i++) {
                        fm = matriztriangularsuperior[i][k] / matriztriangularsuperior[k][k];
                        for (int j = k; j < inco + 1; j++) {
                            matriztriangularsuperior[i][j] = matriztriangularsuperior[i][j] - (fm * matriztriangularsuperior[k][j]);
                        }
                    }
                }

                Object[][] triangularsuperior = new Object[inco][inco + 1];
                for (int i = 0; i < inco; i++) {
                    for (int j = 0; j < inco + 1; j++) {
                        triangularsuperior[i][j] = matriztriangularsuperior[i][j];
                        modelo2.setValueAt(triangularsuperior[i][j], i, j);
                    }
                }
                tablaAumentada.setModel(modelo2);
                tablaAumentada.updateUI();

                double[] soluciones = new double[inco];
                double suma = 0;
                soluciones[inco - 1] = matriztriangularsuperior[inco - 1][inco] / matriztriangularsuperior[inco - 1][inco - 1];
                for (int i = inco - 2; i >= 0; i--) {
                    suma = 0;
                    for (int j = i + 1; j < inco; j++) {
                        suma = suma + matriztriangularsuperior[i][j] * soluciones[j];
                    }
                    soluciones[i] = (matriztriangularsuperior[i][inco] - suma) / matriztriangularsuperior[i][i];
                }
                String resultados = "";
                for (int i = 0; i < inco; i++) {
                    resultados += "X" + (i + 1) + " = " + soluciones[i] + "\n";
                }

                jTextArea1.setText(resultados);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir todos los valores de forma correcta en la tabla");
        }
    }

    public void gaussJordan(int inco, JTable tablaGauss, JTable tablaAumentada, JTextField incognitas, JTextArea jTextArea1, DefaultTableModel modelo2) {
        try {
            inco = Integer.parseInt(incognitas.getText());
            modelo2 = new DefaultTableModel();
            modelo2.setRowCount(inco);
            modelo2.setColumnCount(inco + 1);

            double matriz[][] = new double[inco][inco + 1];

            for (int i = 0; i < inco; i++) {
                for (int j = 0; j < inco + 1; j++) {
                    matriz[i][j] = Double.parseDouble(String.valueOf(tablaGauss.getValueAt(i, j)));
                }

            }
            Determinante d = new Determinante();
            if (d.determinante(matriz) == 0) {
                JOptionPane.showMessageDialog(null, "El sistema tiene infinitas soluciones o no tiene solucion");
            } else {

                if (matriz.length == 0) {
                    JOptionPane.showMessageDialog(null, "Favor de rellenar la matriz propuesta");
                }

                double[][] A = matriz;
                int m = inco;
                int n = m + 1;
                double pivote = 0;
                double cero = 0;
                for (int i = 0; i < m; i++) {
                    pivote = A[i][i];
                    for (int j = 0; j < n; j++) {
                        A[i][j] = A[i][j] / pivote;
                    }
                    for (int k = 0; k < m; k++) {
                        if (k != i) {
                            cero = A[k][i];
                            for (int j = 0; j < n; j++) {
                                A[k][j] = A[k][j] - (cero * A[i][j]);
                            }
                        }
                    }
                }

                Object[][] triangularsuperior = new Object[inco][inco + 1];
                for (int i = 0; i < inco; i++) {
                    for (int j = 0; j < inco + 1; j++) {
                        triangularsuperior[i][j] = A[i][j];
                        modelo2.setValueAt(triangularsuperior[i][j], i, j);
                    }
                }
                tablaAumentada.setModel(modelo2);
                tablaAumentada.updateUI();

                String resultados = "";
                int ma = inco;
                int na = inco + 1;
                for (int i = 0; i < ma; i++) {
                    resultados += "X" + (i + 1) + " = " + A[i][ma] + "\n";
                }

                jTextArea1.setText(resultados);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir todos los valores de forma correcta en la tabla");
        }
    }

    public void montante(int inco, JTable tablaGauss, JTable tablaAumentada, JTextField incognitas, JTextArea jTextArea1, DefaultTableModel modelo2) {

        try {
            inco = Integer.parseInt(incognitas.getText());
            modelo2 = new DefaultTableModel();
            modelo2.setRowCount(inco);
            modelo2.setColumnCount(inco + 1);

            double ma[][] = new double[inco][inco + 1];

            for (int i = 0; i < inco; i++) {
                for (int j = 0; j < inco + 1; j++) {
                    ma[i][j] = Double.parseDouble(String.valueOf(tablaGauss.getValueAt(i, j)));
                }

            }
            Determinante d = new Determinante();
            if (d.determinante(ma) == 0) {
                JOptionPane.showMessageDialog(null, "El sistema tiene infinitas soluciones o no tiene solucion");
            } else {

                if (ma.length == 0) {
                    JOptionPane.showMessageDialog(null, "Favor de rellenar la matriz propuesta");
                }
                double[][] A = ma;
                int m = inco;
                double pivoteant = 1;
                for (int k = 0; k < m; k++) {
                    for (int i = 0; i < m; i++) {
                        if (i != k) {
                            for (int j = m; j >= 0; j--) {
                                A[i][j] = (A[k][k] * A[i][j] - A[i][k] * A[k][j]) / pivoteant;
                            }
                        }
                    }
                    pivoteant = A[k][k];
                }

                Object[][] triangularsuperior = new Object[inco][inco + 1];
                for (int i = 0; i < inco; i++) {
                    for (int j = 0; j < inco + 1; j++) {
                        triangularsuperior[i][j] = A[i][j];
                        modelo2.setValueAt(triangularsuperior[i][j], i, j);
                    }
                }
                tablaAumentada.setModel(modelo2);
                tablaAumentada.updateUI();

                int me = inco;
                double[] soluciones = new double[me];
                double deter = A[0][0];
                for (int i = 0; i < me; i++) {
                    soluciones[i] = A[i][me] / deter;
                }
                String resultados = "";
                for (int i = 0; i < inco; i++) {
                    resultados += "X" + (i + 1) + " = " + soluciones[i] + "\n";
                }

                jTextArea1.setText(resultados);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir todos los valores de forma correcta en la tabla");
        }
    }

    public void cramer(int inco, JTable tablaGauss, JTextField incognitas, JTextArea jTextArea1, DefaultTableModel modelo2, JTextArea jTextArea2) {

        try {
            inco = Integer.parseInt(incognitas.getText());

            double m[][] = new double[inco][inco + 1];

            for (int i = 0; i < inco; i++) {
                for (int j = 0; j < inco + 1; j++) {
                    m[i][j] = Double.parseDouble(String.valueOf(tablaGauss.getValueAt(i, j)));
                }

            }
            double[] b = new double[inco];
            for (int i = 0; i < inco; i++) {
                b[i] = m[i][inco];
            }

            Determinante d = new Determinante();
            CopiaArreglo c = new CopiaArreglo();
            double[][] copia = c.duplicaMatriz(m);
            double deter = d.determinante(m);

            if (d.determinante(m) == 0) {
                JOptionPane.showMessageDialog(null, "El sistema tiene infinitas soluciones o no tiene solucion");
            } else if (m.length == 0) {
                JOptionPane.showMessageDialog(null, "Favor de rellenar la matriz propuesta");
            } else {

                m = c.duplicaMatriz(copia);
                double[] detx = new double[inco];
                double[] x = new double[inco];
                for (int j = 0; j < inco; j++) {
                    for (int i = 0; i < inco; i++) {
                        copia[i][j] = b[i];
                    }
                    detx[j] = d.determinante(copia);
                    copia = c.duplicaMatriz(m);
                    x[j] = detx[j] / deter;

                }

                String resultados = "";
                for (int i = 0; i < inco; i++) {
                    resultados += "X" + (i + 1) + " = " + x[i] + "\n";
                }
                String determinantes = "";
                determinantes += "Determinante del sistema = " + deter + "\n";
                for (int i = 0; i < detx.length; i++) {
                    determinantes += "Determinante de X" + (i + 1) + " = " + detx[i] + "\n";
                }
                jTextArea2.setText(determinantes);
                jTextArea1.setText(resultados);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir todos valores de forma correcta en la tabla");
        }
    }

    public void jacobi(int inco, JTable tablaJacobi, JTextField incognitas, JTextField textError, JTextField textfield1, JTextArea jTextArea1, JTable jta) {
        try {
            inco = Integer.parseInt(incognitas.getText());
            double error;
            error = Double.parseDouble(textError.getText());
            int iter = Integer.parseInt(textfield1.getText());
            double ma[][] = new double[inco][inco + 1];

            for (int i = 0; i < inco; i++) {
                for (int j = 0; j < inco + 1; j++) {
                    ma[i][j] = Double.parseDouble(String.valueOf(tablaJacobi.getValueAt(i, j)));
                }

            }
            Determinante d = new Determinante();
            Metodos m = new Metodos();
            if (d.determinante(ma) == 0) {
                JOptionPane.showMessageDialog(null, "El sistema tiene infinitas soluciones o no tiene solucion");
            } else if (!m.DiagonalDominante(ma, inco)) {
                JOptionPane.showMessageDialog(null, "El sistema no converge, diagonal dominate invalida");
            } else {

                double[][] A = ma;
                double[] X = new double[inco];
                double[] Y = new double[inco];
                for (int i = 0; i < X.length; i++) {
                    X[i] = 0;
                }
                boolean fin;
                int n = 0;
                DefaultTableModel modelo = new DefaultTableModel();
                Vector valoresI = new Vector();
                if (inco == 3) {
                    Vector valoresX1 = new Vector();
                    Vector valoresX2 = new Vector();
                    Vector valoresX3 = new Vector();
                    Vector valoresXE1 = new Vector();
                    Vector valoresXE2 = new Vector();
                    Vector valoresXE3 = new Vector();

                    do {
                        n++;
                        fin = true;
                        valoresI.add(n);
                        valoresX1.add(X[0]);
                        valoresX2.add(X[1]);
                        valoresX3.add(X[2]);
                        for (int i = 0; i < inco; i++) {
                            Y[i] = A[i][inco];

                            for (int j = 0; j < inco; j++) {
                                if (i != j) {
                                    Y[i] = Y[i] - A[i][j] * X[j];
                                }
                            }

                            Y[i] = Y[i] / A[i][i];

                            double delta = Math.abs(Y[i] - X[i]);
                            if (delta > error) {
                                fin = false;
                            }

                        }
                        valoresXE1.add(Y[0]);
                        valoresXE2.add(Y[1]);
                        valoresXE3.add(Y[2]);
                        for (int i = 0; i < inco; i++) {

                            X[i] = Y[i];
                        }

                    } while (!fin && n < iter);

                    modelo.addColumn("i", valoresI);
                    modelo.addColumn("X1", valoresX1);
                    modelo.addColumn("X2", valoresX2);
                    modelo.addColumn("X3", valoresX3);
                    modelo.addColumn("X1", valoresXE1);
                    modelo.addColumn("X2", valoresXE2);
                    modelo.addColumn("X3", valoresXE3);

                    jta.setModel(modelo);
                    jta.updateUI();

                    String resultados = "";
                    for (int i = 0; i < inco; i++) {
                        resultados += "X" + (i + 1) + " = " + X[i] + "\n";
                    }
                    if (resultados == "") {

                        JOptionPane.showMessageDialog(null, "El sistema no se puede resolver");
                    }

                    jTextArea1.setText(resultados);

                } else if (inco == 2) {
                    Vector valoresX1 = new Vector();
                    Vector valoresX2 = new Vector();
                    Vector valoresXE1 = new Vector();
                    Vector valoresXE2 = new Vector();

                    do {
                        n++;
                        fin = true;
                        valoresI.add(n);
                        valoresX1.add(X[0]);
                        valoresX2.add(X[1]);
                        for (int i = 0; i < inco; i++) {
                            Y[i] = A[i][inco];

                            for (int j = 0; j < inco; j++) {
                                if (i != j) {
                                    Y[i] = Y[i] - A[i][j] * X[j];
                                }
                            }

                            Y[i] = Y[i] / A[i][i];

                            double delta = Math.abs(Y[i] - X[i]);
                            if (delta > error) {
                                fin = false;
                            }

                        }
                        valoresXE1.add(Y[0]);
                        valoresXE2.add(Y[1]);
                        for (int i = 0; i < inco; i++) {

                            X[i] = Y[i];
                        }

                    } while (!fin && n < iter);

                    modelo.addColumn("i", valoresI);
                    modelo.addColumn("X1", valoresX1);
                    modelo.addColumn("X2", valoresX2);
                    modelo.addColumn("X1", valoresXE1);
                    modelo.addColumn("X2", valoresXE2);

                    jta.setModel(modelo);
                    jta.updateUI();

                    String resultados = "";
                    for (int i = 0; i < inco; i++) {
                        resultados += "X" + (i + 1) + " = " + X[i] + "\n";
                    }
                    if (resultados == "") {

                        JOptionPane.showMessageDialog(null, "El sistema no se puede resolver");
                    }

                    jTextArea1.setText(resultados);

                } else if (inco == 4) {
                    Vector valoresX1 = new Vector();
                    Vector valoresX2 = new Vector();
                    Vector valoresX3 = new Vector();
                    Vector valoresX4 = new Vector();
                    Vector valoresXE1 = new Vector();
                    Vector valoresXE2 = new Vector();
                    Vector valoresXE3 = new Vector();
                    Vector valoresXE4 = new Vector();

                    do {
                        n++;
                        fin = true;
                        valoresI.add(n);
                        valoresX1.add(X[0]);
                        valoresX2.add(X[1]);
                        valoresX3.add(X[2]);
                        valoresX4.add(X[3]);
                        for (int i = 0; i < inco; i++) {
                            Y[i] = A[i][inco];

                            for (int j = 0; j < inco; j++) {
                                if (i != j) {
                                    Y[i] = Y[i] - A[i][j] * X[j];
                                }
                            }

                            Y[i] = Y[i] / A[i][i];

                            double delta = Math.abs(Y[i] - X[i]);
                            if (delta > error) {
                                fin = false;
                            }

                        }
                        valoresXE1.add(Y[0]);
                        valoresXE2.add(Y[1]);
                        valoresXE3.add(Y[2]);
                        valoresXE4.add(Y[3]);
                        for (int i = 0; i < inco; i++) {

                            X[i] = Y[i];
                        }

                    } while (!fin && n < iter);

                    modelo.addColumn("i", valoresI);
                    modelo.addColumn("X1", valoresX1);
                    modelo.addColumn("X2", valoresX2);
                    modelo.addColumn("X3", valoresX3);
                    modelo.addColumn("X4", valoresX4);
                    modelo.addColumn("X1", valoresXE1);
                    modelo.addColumn("X2", valoresXE2);
                    modelo.addColumn("X3", valoresXE3);
                    modelo.addColumn("X4", valoresXE4);

                    jta.setModel(modelo);
                    jta.updateUI();

                    String resultados = "";
                    for (int i = 0; i < inco; i++) {
                        resultados += "X" + (i + 1) + " = " + X[i] + "\n";
                    }
                    if (resultados == "") {

                        JOptionPane.showMessageDialog(null, "El sistema no se puede resolver");
                    }

                    jTextArea1.setText(resultados);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir todos los valores de forma correcta en la tabla");
        }
    }

    public void seidel(int inco, JTable tablaJacobi, JTextField incognitas, JTextField textError, JTextField it, JTextArea jTextArea1, JTable jta) {
        try {
            inco = Integer.parseInt(incognitas.getText());
            double error = Double.parseDouble(textError.getText());
            int iter = Integer.parseInt(it.getText());
            double ma[][] = new double[inco][inco + 1];

            for (int i = 0; i < inco; i++) {
                for (int j = 0; j < inco + 1; j++) {
                    ma[i][j] = Double.parseDouble(String.valueOf(tablaJacobi.getValueAt(i, j)));
                }

            }
            Metodos me = new Metodos();
            Determinante d = new Determinante();
            if (d.determinante(ma) == 0) {
                JOptionPane.showMessageDialog(null, "El sistema tiene infinitas soluciones o no tiene solucion");
            } else if (!me.DiagonalDominante(ma, inco)) {
                JOptionPane.showMessageDialog(null, "El sistema no converge, diagonal dominante inválida");
            } else {

                double[][] A = ma;
                double[] X = new double[inco];
                double y[] = new double[inco];

                for (int i = 0; i < X.length; i++) {
                    X[i] = 0;
                }
                int n = 0;
                boolean fin;
                DefaultTableModel modelo = new DefaultTableModel();
                Vector valoresI = new Vector();
                if (inco == 3) {
                    Vector valoresX1 = new Vector();
                    Vector valoresX2 = new Vector();
                    Vector valoresX3 = new Vector();
                    Vector valoresXE1 = new Vector();
                    Vector valoresXE2 = new Vector();
                    Vector valoresXE3 = new Vector();
                    do {
                        n++;
                        fin = true;
                        valoresI.add(n);
                        valoresX1.add(X[0]);
                        valoresX2.add(X[1]);
                        valoresX3.add(X[2]);
                        for (int i = 0; i < inco; i++) {
                            y[i] = A[i][inco];
                            for (int j = 0; j < inco; j++) {
                                if (i != j) {
                                    y[i] = y[i] - A[i][j] * X[j];
                                }
                            }
                            y[i] = y[i] / A[i][i];
                            double delta = Math.abs(X[i] - y[i]);
                            if (delta > error) {
                                fin = false;
                            }
                            X[i] = y[i];
                        }
                        valoresXE1.add(y[0]);
                        valoresXE2.add(y[1]);
                        valoresXE3.add(y[2]);
                    } while (!fin && n < iter);
                    modelo.addColumn("i", valoresI);
                    modelo.addColumn("X1", valoresX1);
                    modelo.addColumn("X2", valoresX2);
                    modelo.addColumn("X3", valoresX3);
                    modelo.addColumn("X1", valoresXE1);
                    modelo.addColumn("X2", valoresXE2);
                    modelo.addColumn("X3", valoresXE3);

                    jta.setModel(modelo);
                    jta.updateUI();

                    String resultados = "";
                    for (int i = 0; i < inco; i++) {
                        resultados += "X" + (i + 1) + " = " + X[i] + "\n";
                    }
                    if (resultados == "") {

                        JOptionPane.showMessageDialog(null, "El sistema no se puede resolver");
                    }
                    jTextArea1.setText(resultados);
                } else if (inco == 2) {
                    Vector valoresX1 = new Vector();
                    Vector valoresX2 = new Vector();
                    Vector valoresXE1 = new Vector();
                    Vector valoresXE2 = new Vector();
                    do {
                        n++;
                        fin = true;
                        valoresI.add(n);
                        valoresX1.add(X[0]);
                        valoresX2.add(X[1]);
                        for (int i = 0; i < inco; i++) {
                            y[i] = A[i][inco];
                            for (int j = 0; j < inco; j++) {
                                if (i != j) {
                                    y[i] = y[i] - A[i][j] * X[j];
                                }
                            }
                            y[i] = y[i] / A[i][i];
                            double delta = Math.abs(X[i] - y[i]);
                            if (delta > error) {
                                fin = false;
                            }
                            X[i] = y[i];
                        }
                        valoresXE1.add(y[0]);
                        valoresXE2.add(y[1]);
                    } while (!fin && n < iter);
                    modelo.addColumn("i", valoresI);
                    modelo.addColumn("X1", valoresX1);
                    modelo.addColumn("X2", valoresX2);
                    modelo.addColumn("X1", valoresXE1);
                    modelo.addColumn("X2", valoresXE2);

                    jta.setModel(modelo);
                    jta.updateUI();

                    String resultados = "";
                    for (int i = 0; i < inco; i++) {
                        resultados += "X" + (i + 1) + " = " + X[i] + "\n";
                    }
                    if (resultados == "") {

                        JOptionPane.showMessageDialog(null, "El sistema no se puede resolver");
                    }
                    jTextArea1.setText(resultados);
                } else if (inco == 4) {
                    Vector valoresX1 = new Vector();
                    Vector valoresX2 = new Vector();
                    Vector valoresX3 = new Vector();
                    Vector valoresX4 = new Vector();
                    Vector valoresXE1 = new Vector();
                    Vector valoresXE2 = new Vector();
                    Vector valoresXE3 = new Vector();
                    Vector valoresXE4 = new Vector();
                    do {
                        n++;
                        fin = true;
                        valoresI.add(n);
                        valoresX1.add(X[0]);
                        valoresX2.add(X[1]);
                        valoresX3.add(X[2]);
                        valoresX4.add(X[3]);
                        for (int i = 0; i < inco; i++) {
                            y[i] = A[i][inco];
                            for (int j = 0; j < inco; j++) {
                                if (i != j) {
                                    y[i] = y[i] - A[i][j] * X[j];
                                }
                            }
                            y[i] = y[i] / A[i][i];
                            double delta = Math.abs(X[i] - y[i]);
                            if (delta > error) {
                                fin = false;
                            }
                            X[i] = y[i];
                        }
                        valoresXE1.add(y[0]);
                        valoresXE2.add(y[1]);
                        valoresXE3.add(y[2]);
                        valoresXE3.add(y[3]);
                    } while (!fin && n < iter);
                    modelo.addColumn("i", valoresI);
                    modelo.addColumn("X1", valoresX1);
                    modelo.addColumn("X2", valoresX2);
                    modelo.addColumn("X3", valoresX3);
                    modelo.addColumn("X4", valoresX4);
                    modelo.addColumn("X1", valoresXE1);
                    modelo.addColumn("X2", valoresXE2);
                    modelo.addColumn("X3", valoresXE3);
                    modelo.addColumn("X4", valoresXE4);

                    jta.setModel(modelo);
                    jta.updateUI();

                    String resultados = "";
                    for (int i = 0; i < inco; i++) {
                        resultados += "X" + (i + 1) + " = " + X[i] + "\n";
                    }
                    if (resultados == "") {

                        JOptionPane.showMessageDialog(null, "El sistema no se puede resolver");
                    }
                    jTextArea1.setText(resultados);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir todos los valores de forma correcta en la tabla");
        }
    }

    public double[] cramer(int m, double mat[][]) {
        Determinante d = new Determinante();
        double detA;
        double aux[][] = new double[m][m + 1];
        for (int i = 0; i < m; i++)//meter datos a auxiliar
        {
            System.arraycopy(mat[i], 0, aux[i], 0, m);
        }
        double result[] = new double[m];

        detA = d.determinante(mat);

        for (int j = 0; j < m; j++)//escoger columnas
        {
            for (int i = 0; i < m; i++)//sustituir columna
            {
                aux[i][j] = mat[i][m];
            }

            result[j] = d.determinante(aux) / detA;

            for (int i = 0; i < m; i++)//restaurar valores a auxiliar
            {
                aux[i][j] = mat[i][j];
            }
        }

        return result;
    }

    public boolean DiagonalDominante(double[][] A, int m) {
        double Suma = 0;
        boolean Band = true;
        for (int i = 0; i < m; i++) {
            Suma = 0;
            for (int j = 0; j < m; j++) {
                if (i != j) {
                    Suma = Suma + A[i][j];
                }
            }
            if (Math.abs(A[i][i]) <= Suma) {
                Band = false;
                break;
            }
        }
        return Band;
    }

}
