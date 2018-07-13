/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgraficametodos;

/**
 *
 * @author Héctor
 */
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Funcion extends JFrame {

    // define X rango
    public int minX = -5;
    public int maxX = 5;

    JFreeChart chart;

    public Funcion(String titulo,String titulo2) {
        super(titulo2);
        // Crea un  XY chart
        XYSeries series = new XYSeries(titulo + "=0");
        XYSeries seriesx = new XYSeries("Eje x");
        XYSeries seriesy = new XYSeries("Eje y");
        
        Ecuacion ecu = new Ecuacion();
        for (int i = minX; i <= maxX; i++) {
            series.add(i, ecu.ecuacion(titulo, i));
            seriesx.add(i, 0);
        }
        for(int i = 0; i<=ecu.ecuacion(titulo, maxX);i++){
            seriesy.add(0, i);
        }

        // Agrega las series
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(seriesx);
        dataset.addSeries(seriesy);

        // Genera el grafico
        chart = ChartFactory.createXYLineChart(
                "Función: " + titulo, // Titulo
                "Eje X", // etiqueta en el eje x
                "Eje Y", // etiqueta en el eje y
                dataset, // configuracion de las funciones
                PlotOrientation.VERTICAL, // Orientacion de la grafica
                true, // muestra las leyendas
                true, // usar tooltips
                false // generar urls
        );

        ChartPanel panel = new ChartPanel(chart);
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

   

}
