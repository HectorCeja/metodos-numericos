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
public class PanelNoIterativo extends javax.swing.JPanel {

    /**
     * Creates new form PanelNoIterativo
     */
    Metodos metodo = new Metodos();
    public PanelNoIterativo() {
        initComponents();
        jTextArea2.setVisible(false);
        jLabel6.setVisible(false);
        jRadioButton1.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        incognitas = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGauss = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAumentada = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 560));
        setLayout(null);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Resultados");
        add(jLabel3);
        jLabel3.setBounds(583, 387, 67, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Matriz propuesta");
        add(jLabel4);
        jLabel4.setBounds(510, 130, 104, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Matriz resultante");
        add(jLabel5);
        jLabel5.setBounds(80, 350, 107, 17);

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(80, 230, 90, 48);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane4.setViewportView(jTextArea1);

        add(jScrollPane4);
        jScrollPane4.setBounds(530, 415, 183, 114);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Ingrese el número de incógnitas:");
        add(jLabel2);
        jLabel2.setBounds(90, 130, 210, 23);

        incognitas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        incognitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incognitasActionPerformed(evt);
            }
        });
        add(incognitas);
        incognitas.setBounds(120, 180, 132, 23);

        jButton3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jButton3.setText("Vaciar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(180, 230, 106, 48);

        tablaGauss.setBackground(new java.awt.Color(204, 255, 204));
        tablaGauss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "Result"
            }
        ));
        tablaGauss.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tablaGauss);

        add(jScrollPane1);
        jScrollPane1.setBounds(450, 160, 230, 140);

        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(520, 320, 90, 40);

        tablaAumentada.setBackground(new java.awt.Color(153, 255, 153));
        tablaAumentada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "Result"
            }
        ));
        jScrollPane2.setViewportView(tablaAumentada);

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 370, 230, 170);

        jRadioButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jRadioButton1.setText("Gauss");
        jRadioButton1.setOpaque(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        add(jRadioButton1);
        jRadioButton1.setBounds(40, 80, 100, 27);

        jRadioButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jRadioButton2.setText("Gauss-Jordan");
        jRadioButton2.setOpaque(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        add(jRadioButton2);
        jRadioButton2.setBounds(200, 80, 140, 27);

        jRadioButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jRadioButton3.setText("Montante");
        jRadioButton3.setOpaque(false);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        add(jRadioButton3);
        jRadioButton3.setBounds(410, 80, 110, 27);

        jRadioButton4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jRadioButton4.setText("Cramer");
        jRadioButton4.setOpaque(false);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        add(jRadioButton4);
        jRadioButton4.setBounds(610, 80, 120, 27);

        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 24)); // NOI18N
        jLabel1.setText("Métodos no iterativos");
        add(jLabel1);
        jLabel1.setBounds(160, 20, 480, 50);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(jTextArea2);

        add(jScrollPane3);
        jScrollPane3.setBounds(290, 410, 180, 110);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("Determinantes");
        add(jLabel6);
        jLabel6.setBounds(330, 390, 100, 18);
    }// </editor-fold>//GEN-END:initComponents
    int inco;
    DefaultTableModel modelo;
    DefaultTableModel modelo2;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            inco = Integer.parseInt(incognitas.getText());
            modelo = new DefaultTableModel();
            modelo.setRowCount(inco);
            modelo.setColumnCount(inco + 1);
            tablaGauss.setModel(modelo);
            tablaGauss.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Favor de introducir valores validos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void incognitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incognitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_incognitasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            incognitas.setText("");
            jTextArea1.setText("");
            jTextArea2.setText("");

            for (int i = 0; i < tablaGauss.getRowCount(); i++) {
                tablaGauss.setValueAt(null, i, 0);
                for (int j = 1; j < tablaGauss.getColumnCount(); j++) {
                    tablaGauss.setValueAt(null, i, j);
                }
            }
            for (int i = 0; i < tablaAumentada.getRowCount(); i++) {
                tablaAumentada.setValueAt(null, i, 0);
                for (int j = 1; j < tablaAumentada.getColumnCount(); j++) {
                    tablaAumentada.setValueAt(null, i, j);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Los elementos están vacíos");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jRadioButton1.isSelected()) {
            metodo.Gauss(inco, tablaGauss, tablaAumentada, incognitas, jTextArea1, modelo2);
        } else if (jRadioButton2.isSelected()) {
            metodo.gaussJordan(inco, tablaGauss, tablaAumentada, incognitas, jTextArea1, modelo2);
        } else if (jRadioButton3.isSelected()) {
            metodo.montante(inco, tablaGauss, tablaAumentada, incognitas, jTextArea1, modelo2);
        } else if (jRadioButton4.isSelected()) {
            metodo.cramer(inco, tablaGauss, incognitas, jTextArea1, modelo2,jTextArea2);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setSelected(true);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        tablaAumentada.setVisible(true);
        jTextArea2.setVisible(false);
        jTextArea2.setText(null);
        jLabel6.setVisible(false);
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(true);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        tablaAumentada.setVisible(true);
        jTextArea2.setVisible(false);
        jTextArea2.setText(null);
        jLabel6.setVisible(false);
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(true);
        jRadioButton4.setSelected(false);
        tablaAumentada.setVisible(true);
        jTextArea2.setVisible(false);
        jTextArea2.setText(null);
        jLabel6.setVisible(false);
       
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(true);
        tablaAumentada.setVisible(false);
        jTextArea2.setVisible(true);
        jTextArea2.setText(null);
        jLabel6.setVisible(true);
        
    }//GEN-LAST:event_jRadioButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField incognitas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTable tablaAumentada;
    private javax.swing.JTable tablaGauss;
    // End of variables declaration//GEN-END:variables
}
