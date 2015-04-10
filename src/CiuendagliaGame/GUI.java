package CiuendagliaGame;

import CiuendagliaGame.Main;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame implements Runnable {
    MouseKeyboardLevelInfinite PanelloLvInfinito;
   
    Thread t;
    Thread t2;
    Thread t3;
    String PathSelected = null;
    ButtonGroup btngroup;
    ButtonGroup btnMode;
    int timeSleeping;
    long keyPressedMillis;
    int countSleep;
    private int time;
    JLabel la;
    int whenAddItemLife;
    public static int level;
    int whenAddItemRocket;
    int whenAddItemSBullet;
    int whenAddBossP;
    int whenAddShootB;
    int whenAddSecondEnemy;
    public static int vel = 0;
    public GUI() throws IOException {
        Login sl = new Login(this, true,this);
        sl.setVisible(true);
        level = sl.getLevel();
        time = sl.getTime();
        this.setIconImage(new ImageIcon(MouseKeyboardLevelInfinite.NameNavePath).getImage());
        this.setFocusable(false);
        this.setVisible(true);
        btngroup = new ButtonGroup();
        btnMode = new ButtonGroup();
        initComponents();
        Main.sortArray();
        la = new JLabel();
        whenAddItemLife = 0;
        whenAddBossP = 0;
        whenAddSecondEnemy=0;
        whenAddShootB = 0;
        whenAddItemRocket = 0;
        whenAddItemSBullet = 0;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        
       
            PanelloLvInfinito = new MouseKeyboardLevelInfinite(this, la, time);
            t = new Thread(PanelloLvInfinito);
            this.add(PanelloLvInfinito);
            la.setText("score: " + Main.UserIn.getPoints());
            PanelloLvInfinito.add(la);
            la.setLocation(0, 0);
            PanelloLvInfinito.setLocation(0, 0);
            PanelloLvInfinito.requestFocusInWindow();

            timeSleeping = 1200;
            countSleep = 0;
            t.start();
       
    }

    public void apriFile(String filepath) {
        final JFileChooser fc_open = new JFileChooser();

        fc_open.setFileFilter(new ImgFilter());

        int returnVal = fc_open.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File f_open = fc_open.getSelectedFile();

            filepath = f_open.getAbsolutePath();

        } else {
            System.out.println("Errore");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuNew = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MenuFullScreen = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        MenuScores = new javax.swing.JMenuItem();
        MenuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Space Game !! (Easy Mode)");
        setMinimumSize(new java.awt.Dimension(640, 501));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.setFocusable(false);

        MenuNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        MenuNew.setText("New Game");
        MenuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuNewActionPerformed(evt);
            }
        });
        jMenu1.add(MenuNew);

        jMenu3.setText("Screen Size");

        MenuFullScreen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        MenuFullScreen.setSelected(true);
        MenuFullScreen.setText("Full Screen");
        btngroup.add(MenuFullScreen);
        MenuFullScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFullScreenActionPerformed(evt);
            }
        });
        jMenu3.add(MenuFullScreen);

        jRadioButtonMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, 0));
        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("Medium Screen");
        jRadioButtonMenuItem2.setEnabled(false);
        btngroup.add(jRadioButtonMenuItem2);
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem2);

        jMenu1.add(jMenu3);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        jMenuItem6.setText("Pause");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        MenuScores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        MenuScores.setText("Scores");
        MenuScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuScoresActionPerformed(evt);
            }
        });
        jMenu1.add(MenuScores);

        MenuExit.setText("Exit");
        jMenu1.add(MenuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setFocusable(false);

        jMenu4.setText("Mode");
        jMenu2.add(jMenu4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuScoresActionPerformed

        // TODO add your handling code here:
       
            if (MouseKeyboardLevelInfinite.running == true) {
                MouseKeyboardLevelInfinite.running = false;
            }
        
        new GUIScores(this, true).setVisible(true);
    }//GEN-LAST:event_MenuScoresActionPerformed

    private void MenuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuNewActionPerformed
        whenAddSecondEnemy=0;
        whenAddItemLife = 0;
        whenAddItemRocket = 0;
        whenAddItemSBullet = 0;
        whenAddBossP = 0;
        whenAddShootB = 0;

            timeSleeping = 1200;
            PanelloLvInfinito.newGame();
        

    }//GEN-LAST:event_MenuNewActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Object[] options = {"Si", "No"};
        int selected = JOptionPane.showOptionDialog(null, "Sei sicuro di voler uscire? ", "Esci",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (selected == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        pausa();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void pausa() {
      
            if (MouseKeyboardLevelInfinite.running == true) {
                MouseKeyboardLevelInfinite.running = false;
            } else {
                MouseKeyboardLevelInfinite.running = true;
            }
        
    }
    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.setSize(640, 501);



    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void MenuFullScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFullScreenActionPerformed
        // TODO add your handling code here:

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


    }//GEN-LAST:event_MenuFullScreenActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JRadioButtonMenuItem MenuFullScreen;
    private javax.swing.JMenuItem MenuNew;
    private javax.swing.JMenuItem MenuScores;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {

           

                if (MouseKeyboardLevelInfinite.running == true) {
                    if (PanelloLvInfinito.enemies.size() < MouseKeyboardLevelInfinite.SizeofEnemies) {
                        PanelloLvInfinito.spawnEnemy();

                    }
                    if (PanelloLvInfinito.enemies.size() < MouseKeyboardLevelInfinite.SizeofEnemies) {
                            if (whenAddShootB == 1) {
                                whenAddShootB = 0;

                            }
                            whenAddShootB++;
                        

                    }
                    
                    whenAddItemLife++;
                    whenAddItemRocket++;
                    whenAddItemSBullet++;

                   
                    if (whenAddItemLife == 15) {   // after 30 or 31 seconds it adds the item of life and reset the counter
                        PanelloLvInfinito.startLifeItem();
                        whenAddItemLife = 0;
                    }
                    if (whenAddItemRocket == 7) {
                        PanelloLvInfinito.startRocketItem();
                        whenAddItemRocket = 0;
                    }
                    if (whenAddItemSBullet == 10 && PanelloLvInfinito.hasSpecialBullet() == false) {
                        PanelloLvInfinito.startSpecialBullet();
                        whenAddItemSBullet = 0;
                    }
                    try {
                        
                        if (countSleep == 2) {
                            countSleep = 0;
                            if (timeSleeping <= 1200 && timeSleeping > 300) {
                                timeSleeping = timeSleeping-10;
                                System.out.println(timeSleeping);
                                if(timeSleeping % 80 == 0)
                                    vel++;
                            }
                        }
                        Thread.sleep(timeSleeping);
                        countSleep++;
                    } catch (InterruptedException ex) {
                        System.err.println("Error: Thread Interrupted.");
                    }

                }
            

        }
    }
}
