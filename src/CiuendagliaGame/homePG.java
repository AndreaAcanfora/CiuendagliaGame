package CiuendagliaGame;

import static CiuendagliaGame.MouseKeyboardLevelInfinite.enemies;
import static CiuendagliaGame.MouseKeyboardLevelInfinite.loadImage;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class homePG extends javax.swing.JDialog {
   
    GUI frame;
    public static String ps = new String();
    public static String id = new String();

    public homePG(java.awt.Frame parent, boolean modal, GUI frame) {
        super(parent, modal);
        initComponents();
        this.frame = frame; 
        this.setSize(1367, 730);       
        jButton1.setLocation(40, (630));
     
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 630, 200, 40);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 170, 230, 250);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel2.setText("Personalizza giocatore");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 270, 30);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setLayout(null);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(90, -20, 440, 350);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(600, 20, 600, 580);
        jPanel2.add(jLabel5);
        jLabel5.setBounds(60, 310, 490, 420);
        jPanel2.add(jLabel6);
        jLabel6.setBounds(570, 330, 490, 480);

        ComboBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Scout", "Abito", "Universitario", "Passeggio" }));
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(ComboBox);
        ComboBox.setBounds(20, 20, 190, 60);

        jTabbedPane1.addTab("Cappelli", jPanel2);

        jPanel1.setLayout(null);

        jLabel7.setMaximumSize(new java.awt.Dimension(170, 140));
        jLabel7.setMinimumSize(new java.awt.Dimension(170, 140));
        jLabel7.setOpaque(true);
        jLabel7.setPreferredSize(new java.awt.Dimension(170, 140));
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 40, 170, 143);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(230, 30, 230, 0);

        jLabel9.setText("jLabel6");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(270, 40, 460, 370);

        jLabel10.setText("jLabel4");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(790, 30, 230, 200);

        jLabel11.setText("jLabel7");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(-10, 350, 290, 440);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText("  LV 1                                      LV 2                                    LV 3                                      LV 4  ");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(70, 200, 960, 20);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(260, 360, 340, 270);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setText("  LV 1                                      LV 2                                    LV 3                                      LV 4  ");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(70, 200, 960, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel15.setText("  LV 1                                      LV 2                                    LV 3                                      LV 4  ");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(70, 200, 960, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setText("  LV 1                                      LV 2                                    LV 3                                      LV 4  ");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(70, 200, 960, 20);
        jPanel1.add(jLabel17);
        jLabel17.setBounds(530, 350, 200, 280);
        jPanel1.add(jLabel18);
        jLabel18.setBounds(780, 360, 270, 820);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel19.setText("LV 5                                    LV 6                                    LV 7                                      LV 8  ");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(100, 510, 890, 14);

        jTabbedPane1.addTab("Macchine", jPanel1);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(270, 20, 1070, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();                          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        
    }//GEN-LAST:event_ComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
