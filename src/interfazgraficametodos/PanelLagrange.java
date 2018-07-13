/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgraficametodos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Héctor
 */
public class PanelLagrange extends javax.swing.JPanel {

    /**
     * Creates new form PanelLagrange
     */
    int f, c;
    double x[];
    double y[];
    DefaultTableModel modelo2 = new DefaultTableModel();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();
    Boolean ban = false;
    double x1;
    public PanelLagrange() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xevaluar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablanewton = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        result = new javax.swing.JTextField();
        incognitas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 153));
        setPreferredSize(new java.awt.Dimension(809, 560));

        xevaluar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jButton3.setText("Vaciar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jButton1.setText("Cargar tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Tabla");

        tablanewton.setBackground(new java.awt.Color(204, 255, 204));
        tablanewton.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "X", "Y"
            }
        ));
        tablanewton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tablanewton);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Ingrese el número de puntos:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("El valor  de interpolación de x  es:");

        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jButton2.setText("Cargar puntos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        result.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        incognitas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        incognitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incognitasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("X a evaluar:");

        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 24)); // NOI18N
        jLabel1.setText("Método de Lagrange");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(incognitas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(14, 14, 14)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(xevaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incognitas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(xevaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            incognitas.setText("");
            xevaluar.setText("");
            result.setText("");
            for (int i = 0; i < tablanewton.getRowCount(); i++) {
                tablanewton.setValueAt(null, i, 0);
                for (int j = 1; j < tablanewton.getColumnCount(); j++) {
                    tablanewton.setValueAt(null, i, j);
                }
            }

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Los elementos están vacíos");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            f = Integer.parseInt(incognitas.getText());
            c = f + 2;

            //
            Object col[] = new Object[c];//  al erreglo mostrara en el titulo del JTabel las las incognitas y su solucion de la ecuaciom
            // ejemplo si el sistema tiene 2 incognitas aparecera en la pantalla una matriz de 2x3
            // se motrara en el titulo del JTable  x1  x2   d
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    col[j] = "X";
                } else {
                    col[j] = "Y";
                }
            }
            for (int j = 2; j < c; j++) {
                col[j] = "△" + (j - 1) + "Y";
            }
            x = new double[f];
            y = new double[f];

           // x1 = Double.parseDouble(xevaluar.getText());
            modelo1 = new DefaultTableModel(col, f);
            modelo = new DefaultTableModel(col, f);// se muestra el titulo y el Jtablet toma la dimension de la matriz aumentada
            tablanewton.setModel(modelo);// el Jtablet toma la dimension de la matriz aumentada
            for (int i = c - 1; i > 1; i--) {
                tablanewton.removeColumn(tablanewton.getColumnModel().getColumn(i));
            }

            modelo1 = new DefaultTableModel(col, f);

            Object col1[] = new Object[c];
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    col1[j] = "X";
                } else {
                    col1[j] = "Y";
                }
            }
            for (int j = 2; j < c; j++) {
                col1[j] = "△" + (j - 1) + "Y";
            }

            modelo2 = new DefaultTableModel(col1, f);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir valores validos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            x1 = Double.parseDouble(xevaluar.getText());
            for (int i = 0; i < f; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
                for (int j = 0; j < 1; j++) {//
                    x[i] = Double.parseDouble(String.valueOf(tablanewton.getValueAt(i, j)));

                }

            }
            for (int i = 0; i < f; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
                for (int j = 1; j ==1; j++) {//
                    y[i] = Double.parseDouble(String.valueOf(tablanewton.getValueAt(i, j)));

                }

            }
            
            
            double v[][]=new double[f][f];
            double t[][]=new double[f][f];
            //try{

                int n = x.length;
                for (int j=0;j<f;j++){
                    v[j][0]=y[j];
                }
                double vk[][]=new double[n][n];
                //ciclo para recorrer la matriz y almacenar los valores en un auxiliar
                for(int i=0;i<n;i++)
                {

                    for(int j=0;j<n;j++){
                        vk[i][j]=v[i][j];
                    }
                }
                //utilizo el auxiliar para recorrer la matriz e imprimir en la tabla
                
                //se obtiene la diferencia dividida (f1 -f0)/(x1-x0) de las diferencias
                for (int k=0; k<n-1;k++){
                    int p=0;

                    for(int i=k+1;i<n;i++){
                        v[i][k+1]=(v[i][k]-v[i-1][k])/(x[i]-x[p]);
                        p++;
                    }
                }
                double p=0;
                double aux;
                //hace que se aplique la formula para generar la aproximacion
                //(x- xi2) · (x-xi1)....(x-xik) es la formula para obtener y evaluada en x
                for(int s=0;s<n;s++){
                    aux=1;
                    for(int c=0;c<s;c++){
                        aux=aux*(x1-x[c]);
                    }
                    p=p+v[s][s]*aux;
                }
                result.setText(""+p);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Favor de introducir valores en la tabla");
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void incognitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incognitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_incognitasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField incognitas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField result;
    private javax.swing.JTable tablanewton;
    private javax.swing.JTextField xevaluar;
    // End of variables declaration//GEN-END:variables
}