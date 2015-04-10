package CiuendagliaGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Login extends javax.swing.JDialog {

   
    int level;
    int tempo;
    GUI frame;
    public static String ps = new String();
    public static String id = new String();

    public Login(java.awt.Frame parent, boolean modal, GUI frame) {
        super(parent, modal);
        initComponents();
        level = 1;
        tempo = 10;
        this.frame = frame;
        this.setLocationRelativeTo(null);
        this.setSize(236, 220);
    }

    public int getLevel() {
        return level;
    }

    public int getTime() {
        return tempo;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtPss = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 130, 202, 40);
        getContentPane().add(txtID);
        txtID.setBounds(90, 10, 120, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 26, 19);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 43, 70, 19);

        jButton2.setText("Registrata nuovo utente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 80, 200, 40);
        getContentPane().add(txtPss);
        txtPss.setBounds(90, 40, 120, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String pass = new String(txtPss.getPassword());
        if (txtID.getText().equals("") || pass.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Completa tutti i campi.");
        } else {
            if (txtID.getText().equals("admin") || pass.equals("admin")) {
                dispose();
            } else {

                String ID = new String();
                String password = new String();
                String textPass = new String(txtPss.getPassword());
                BufferedReader reader = null;
                boolean flag = false;
                try {
                    reader = new BufferedReader(new FileReader("ID.txt"));
                    int k = 0;
                    String line = reader.readLine();
                    while (line != null) {
                        k++;
                        if (k == 1) {
                            ID = line;
                        }
                        if (k == 2) {
                            password = line;
                            k = 0;
                            System.out.println(ID + " " + password);
                            System.out.println(txtID.getText() + " " + txtPss.getPassword());
                            if (ID.equals(txtID.getText()) && password.equals(textPass)) {
                                ps = textPass;
                                id = txtID.getText();
                                homePG aa;
                                aa = new homePG(frame, true,frame);
                                aa.setVisible(true);
                                dispose();
                                flag = true;
                            }
                        }
                        line = reader.readLine();
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MouseKeyboardLevelInfinite.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (flag == false) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Password errata.");
                }
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Register r = new Register(frame, true);
        r.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtID;
    private javax.swing.JPasswordField txtPss;
    // End of variables declaration//GEN-END:variables
}
