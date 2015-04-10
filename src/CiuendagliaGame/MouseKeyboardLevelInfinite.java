package CiuendagliaGame;

import CiuendagliaGame.Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MouseKeyboardLevelInfinite extends JPanel implements Runnable {

    public static String NameNavePath = "persona.png";
    public static String NameBGPath = "BG1.png";
    public static int SizeofEnemies = 1000;
    private int x;
    private int posizione = 0;
    private int y;
    private int xVelocity;
    private int yVelocity;
    private JProgressBar exp;
    private boolean lanciato = true;
    public static ArrayList<Enemy> enemies;
    private int macchineInsieme = 0;
    private int macchinePassate = 0;
    private int PlayerLife;  //if this variable =0 then it is dead, we will increment it when we get a item of life
    private GUI frame;  // this helps to know the widht  and height of the screen
    private boolean NameWritten;  // since we get a jdialog in meoth run we need to check if it already asked for the username
    public static boolean running = true;
    private double countS;  // we count the milli seconds and make them seconds with this variable and the variable "secondi"
    private int seconds = 10;
    private long keyPressedMillis;
    private boolean alreadyPassed = false;  // to check if the key "c" was pressed to make the special bullet
    private JLabel lblInfo;     // information about the player
    private int ItemLife;  // it gives 1 to the variable life so we know it will give a life when player intersect it
    private int count = 0;
    private int xMeteorite = (int) (Math.random() * 900);  // since the meteorite's X should be randomly we call Math.random
    public static int secondi = 10;
    private int nRocketDis;  // it shows that it stars with 2 special rockets
    private Item life;  // it gives 1 to the variable life so we know it will give a life when player intersect it
    private Item rocket; // it makes a item that will increment the number of rockets
    private Item SpecialBullet;  // it makes a item that will allow user to  shoot 3 bullets
    private boolean TripleBullet;
    int meteorite1 = -200;   // there will be max 4 meteorites it helps to move the rectangle met everytime
    int meteorite2 = -200;
    int meteorite3 = -200;
    int meteorite4 = -200;
    boolean itemLifeStarted; // if the item has been released
    Rectangle met;  // we dont have a class metoerite but we can use a rectangle to move and intersect it
    private boolean flag = false, flag2 = false;
    private boolean pausa = true;
    UserName insNickName;
    public static int gameCompleted = 0;  // if it is 0 then it isnt completed, now if it is 4 it will be completed
    int hitsMet; // counts how many hits you did to meteorite, you must do 5+ to break it
    int livello = 1;
    int esperienzaLivello = 100;
    int esperienza = 0;
    boolean flag1 = true;
    private String password = new String(Login.ps);
    private String ID = new String(Login.id);

    public void run() {
        lblInfo.setFont(new java.awt.Font("Tahoma", 0, 25));
        while (true) {
            lblInfo.setText("Livello: " + livello + " Score: " + macchinePassate + " Time: " + Main.UserIn.getSeconds() + "     EXP:");
            lblInfo.setLocation(5, 0);
            exp.setMaximum(esperienzaLivello);
            exp.setLocation(430, 0);
            exp.setSize(930, 25);
            exp.setValue(esperienza);
            if (esperienza >= esperienzaLivello) {
                esperienza = 0;
                livello++;
                esperienzaLivello = esperienzaLivello + ((int) (esperienzaLivello / 100 * 30));
            }
            lblInfo.setForeground(Color.BLACK);
            if (Main.UserIn.getSeconds() == 16 || Main.UserIn.getSeconds() == 28 || Main.UserIn.getSeconds() == 40) {
                flag2 = false;
                hitsMet = 5;
            }
            if (flag) {
                if (NameWritten == false) {
                    new UserName(frame, true,this).setVisible(true);
                    NameWritten = true;
                }
                flag = false;
            }
            secondi = 10;
            if (MouseKeyboardLevelInfinite.running == true && secondi >= 0) {
                move();

                for (int i = 0; i < enemies.size(); i++) {
                    MouseKeyboardLevelInfinite.enemies.get(i).move();
                    Rectangle enemyHitbox = enemies.get(i).getHitbox();
                    Rectangle playerHitbox = getPlayerHitbox();
                    if (enemyHitbox.intersects(playerHitbox)) {
                        PlayerLife--;
                        enemies.remove(i);
                        if (PlayerLife <= 0) {
                            if (NameWritten == false) {
                                MouseKeyboardLevelInfinite.running = false;
                                insNickName = new UserName(frame, true,this);
                                insNickName.setVisible(true);
                                NameWritten = true;
                            }
                        }
                    }
                }
                for (int i = 0; i < enemies.size(); i++) {
                    Rectangle enemyHitbox = enemies.get(i).getHitbox();
                }
                if (this.PlayerLife > 0) {
                    this.countS = this.countS + 0.005;
                    if (this.countS > 1.0) {
                        seconds++;

                        this.countS = 0.0;
                        Main.UserIn.setSeconds(seconds);
                    }
                }
                if (PlayerLife > 0) {
                    if (met.intersects(getPlayerHitbox())) {
                        PlayerLife = 0;
                        if (NameWritten == false) {
                            new UserName(frame, true,this).setVisible(true);
                            NameWritten = true;
                        }

                    }
                }
                life.move();
                if (life.gethitItem().intersects(this.getPlayerHitbox())) {
                    this.PlayerLife++;
                    life.delItem();
                }
                rocket.move();
                if (rocket.gethitItem().intersects(this.getPlayerHitbox())) {
                    this.nRocketDis++;
                    rocket.delItem();
                }
                SpecialBullet.move();
                if (SpecialBullet.gethitItem().intersects(this.getPlayerHitbox())) {
                    TripleBullet = true;
                    SpecialBullet.delItem();
                }

                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    System.err.println("Error: Thread Interrupted.");
                }
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    System.err.println("Error: Thread Interrupted.");
                }
            }
        }
    }

    public void startLifeItem() {
        life.start();

    }

    public void startRocketItem() {
        rocket.start();
    }

    public void startSpecialBullet() {
        SpecialBullet.start();
    }

    public boolean hasSpecialBullet() {
        return TripleBullet;
    }

    private void move() {
        x += xVelocity;
        y += yVelocity;
        if (x < -50) {
            x = -50;
        }
        if (y < 20) {
            y = this.frame.getHeight() - 100;
        }
        if (x > this.frame.getWidth() - 90) {
            x = this.frame.getWidth() - 90;
        }
        if (y > this.frame.getHeight() - 100) {
            y = this.frame.getHeight() - 100;
        }
        y = 470;
    }

    MouseKeyboardLevelInfinite(GUI frame, JLabel l, int time) throws IOException {
        macchinePassate = 0;
        macchineInsieme = 0;
        itemLifeStarted = false;
        this.frame = frame;
        hitsMet = 5;
        nRocketDis = 2;
        rocket = new Item(-50, -50, 3, this.frame.getWidth(), this.frame.getHeight());
        SpecialBullet = new Item(-50, -50, 2, this.frame.getWidth(), this.frame.getHeight());
        TripleBullet = false;
        met = new Rectangle(-1, -1, 0, 0);
        setSize(this.frame.getWidth() - 10, this.frame.getHeight() - 10);
        setVisible(true);
        x = this.frame.getWidth() / 2;
        y = this.frame.getHeight() / 2;
        xVelocity = 0;
        secondi = 10;
        yVelocity = 0;
        this.ItemLife = 1;
        addKeyListener(new KeyListener());
        enemies = new ArrayList<Enemy>();
        PlayerLife = 1;
        NameWritten = false;
        life = new Item(-50, -50, ItemLife, this.frame.getWidth(), this.frame.getHeight());
        MouseKeyboardLevelInfinite.running = true;
        this.countS = 0.0;
        this.seconds = 0;
        lblInfo = l;
        exp = new JProgressBar();
        this.add(exp);
        //apriPG_admin();
        apriPG();
    }

    public void newGame() {
        flag1 = true;
        macchinePassate = 0;
        macchineInsieme = 0;
        GUI.vel = 0;
        flag2 = false;
        secondi = 10;
        itemLifeStarted = false;
        ItemLife = 1;
        life = new Item(-50, -50, ItemLife, this.frame.getWidth(), this.frame.getHeight());
        rocket = new Item(-50, -50, 3, this.frame.getWidth(), this.frame.getHeight()); // the number 3 is because it is Rocket Item, X and Y are -20 because it will start out from the jpanel
        SpecialBullet = new Item(-50, -50, 2, this.frame.getWidth(), this.frame.getHeight()); // the number 2 is because it is the second item, in other words it should allow 3 shoots with the key "X"
        TripleBullet = false;
        xMeteorite = (int) (Math.random() * 900);
        meteorite1 = -200;
        meteorite2 = -200;
        meteorite3 = -200;
        meteorite4 = -200;
        met = new Rectangle(-1, -1, 0, 0);
        hitsMet = 5;
        nRocketDis = 2;
        Main.UserIn = new Player(null, 0, Main.Users.size() + 1, 0);
        x = this.frame.getWidth() / 2;
        y = this.frame.getHeight() / 2;
        xVelocity = 0;
        yVelocity = 0;
        enemies = new ArrayList<Enemy>();
        PlayerLife = 1;
        NameWritten = false;
        MouseKeyboardLevelInfinite.running = true;
        this.countS = 0.0;
        this.seconds = 0;
        ;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        try {
            draw(g);
        } catch (IOException ex) {
            Logger.getLogger(MouseKeyboardLevelInfinite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void draw(Graphics g) throws IOException {
        
        g.drawImage(loadImage(MouseKeyboardLevelInfinite.NameBGPath), 0, 0, this.frame.getWidth() - 10, this.frame.getHeight() - 10, this);
        //    moon.draw(g);
        if (macchinePassate == 1000) {
             g.drawImage(loadImage("images/youwon.png"), 400, 50, 500, 500, null);
        }

        if (esperienza <= 10 && livello < 9 && livello != 1) {
            g.drawImage(loadImage("lv up.png"), 110, -110, 1000, 500, null);
        }

        if (secondi <= 0) {
            pausa = false;
            MouseKeyboardLevelInfinite.running = false;
        }

        if (PlayerLife > 0) {
            Image spaceShip = loadImage(MouseKeyboardLevelInfinite.NameNavePath);
            g.drawImage(spaceShip, x, y + 100, 100, 150, this);
        } else {
            g.drawImage(loadImage("images/GameOver.png"), (this.frame.getWidth() / 3), this.frame.getHeight() / 5, null);
            //salvaPg_admin();
            salva();
        }

        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            e.draw(g);
        }

        if (!rocket.isOffScreen()) {
            rocket.draw(g);
        }
        if (!SpecialBullet.isOffScreen()) {
            SpecialBullet.draw(g);
        }
        if (!life.isOffScreen() && Main.UserIn.getSeconds() >= 5) {
            life.draw(g);
        }

        if (this.PlayerLife > 0) {

            for (int i = 0; i < PlayerLife; i++) // i draw every life image 
            {
            }
        }

        if (running == false) {

            if (pausa) {
                if (PlayerLife > 0) {
                    g.drawImage(loadImage("gamepaused.png"), (this.frame.getWidth() / 3) - 150, this.frame.getHeight() / 3, null);
                }
            } else {

                g.drawImage(loadImage("images/youwon.png"), 400, 50, 500, 500, null);
                pausa = true;
                flag = true;
            }

        }
        repaint();
    }

    public static Image loadImage(String fileName) {
        ImageIcon icon = new ImageIcon(fileName);
        return icon.getImage();
    }

    public void spawnEnemy() {
        int posX = 0;
        int posY = 0;
        macchinePassate++;
        esperienza++;
        Main.UserIn.setPoints(macchinePassate);
        int aa = posizione;
        while (aa == posizione) {
            posizione = (int) (Math.random() * 4) + 1;
        }
        Enemy e = new Enemy(this.frame.getWidth(), this.frame.getHeight(), 0, posizione, posY, livello);
        enemies.add(e);
        int macchina = (int) (Math.random() * 2) + 1;
        macchineInsieme++;
        if (macchina == 2 && 1 == macchineInsieme) {
            spawnEnemy();
        }
        macchineInsieme = 0;
    }

    public Rectangle getPlayerHitbox() {
        return new Rectangle(x + 40, 650, 20, 20);
    }

    private void salva() throws IOException {
        BufferedWriter bfw = new BufferedWriter(new FileWriter(ID + "_exp.txt"));
        Integer app = new Integer(livello);
        Integer app2 = new Integer(esperienza);
        Integer app3 = new Integer(esperienzaLivello);
        bfw.write(app.toString());
        bfw.newLine();
        bfw.write(app2.toString());
        bfw.newLine();
        bfw.write(app3.toString());
        bfw.close();
    }

    private void apriPG() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(ID + "_exp.txt"));
            int k = 0;
            String line = reader.readLine();
            while (line != null) {
                k++;
                if (k == 1) {
                    livello = Integer.parseInt(line);
                } else if (k == 2) {
                    esperienza = Integer.parseInt(line);
                } else {
                    esperienzaLivello = Integer.parseInt(line);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MouseKeyboardLevelInfinite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class KeyListener extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    yVelocity = -3;
                    break;
                case KeyEvent.VK_DOWN:
                    yVelocity = 3;
                    break;
                case KeyEvent.VK_LEFT:
                    xVelocity = -3;
                    break;

                case KeyEvent.VK_RIGHT:
                    xVelocity = 3;
                    break;

                case KeyEvent.VK_F3:
                    PlayerLife++;
                    break;

                case KeyEvent.VK_C:
                    if (alreadyPassed == false) {
                        keyPressedMillis = System.currentTimeMillis();

                        alreadyPassed = true;
                    }
                    break;
                default:
                    break;
            }
        }

        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                    yVelocity = 0;
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                    xVelocity = 0;
                    break;
                case KeyEvent.VK_C:
                    long keyPressLength = System.currentTimeMillis();
                    keyPressLength = keyPressLength - keyPressedMillis;
                    alreadyPassed = false;
                    break;
                default:
                    break;
            }
        }
    }
}
