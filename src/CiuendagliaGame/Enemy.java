/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiuendagliaGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

public class Enemy {

    private int x;
    private int y;
    private int count = 0;
    private int larghezza = 20;
    private int altezza = 15;
    private int cordx = 660;
    private int cordy = 405;
    private int xVelocity;
    private int yVelocity;
    public static int normalVelocity = 1;
    private int width, height;
    private Image img;
    int macchineInsieme;
    boolean exist;
    private int tipoMacchina = (int) (Math.random() * 8) + 1;
    private int posizione = 4;
    int velocitaX = (int) (Math.random() * GUI.vel) + 1;
    int velocitaY = (int) (Math.random() * GUI.vel) + 1;
    int direction; // decide for direction
    int randomLV0 = (int) (Math.random() * 30) + 25;
    int random = (int) (Math.random() * 3);  // thi is the Dimension of the enemy, it will be random 25x25,35x35 and 45x45

    Enemy(int width, int height, int macchineInsieme, int posizioneMacchina, int posY,int livello) {

        this.macchineInsieme = macchineInsieme;
        this.posizione = posizioneMacchina;
        // if it doesnt came from boss 
        tipoMacchina = (int) (Math.random() * livello) + 1;
            
            if (tipoMacchina == 1) {
                img = new ImageIcon("fiat.png").getImage();
            }
            if (tipoMacchina == 2) {
                img = new ImageIcon("mazda.png").getImage();
            }
            if (tipoMacchina == 3) {
                img = new ImageIcon("mazda2.png").getImage();
            }
            if (tipoMacchina == 4) {
                img = new ImageIcon("audi.png").getImage();
            }
            if (tipoMacchina == 5) {
                img = new ImageIcon("camaro.png").getImage();
            }
            if (tipoMacchina == 6) {
                img = new ImageIcon("maserati.png").getImage();
            }
            if (tipoMacchina == 7) {
                img = new ImageIcon("GreyBugattiVeyron.png").getImage();
            }
            if (tipoMacchina == 8) {
                img = new ImageIcon("lamborgini.png").getImage();
            }
    }

    public int getFromDrago() {
        return macchineInsieme;
    }

    public boolean Exist() {
        return exist;
    }

    public void move() {
        if (macchineInsieme == 0 && GUI.level != 3) {
            if (GUI.level == 0) {
                if (xVelocity < 0) {
                    xVelocity = -1 * velocitaX;
                } else {
                    xVelocity = velocitaX;
                }
                yVelocity = velocitaY;

            }
            x += xVelocity;
            y += yVelocity;

            if (x < 0) {

                xVelocity = -1 * xVelocity;
            }
            if (x > this.width - 50) {
                xVelocity = -1 * xVelocity;
            }
            if (y < 0) {
                yVelocity = 1;
            }
            if (y > this.height) {
                y = 20;
            }
        } else if (macchineInsieme == 0) {
            x = x - 3;

            if (direction == 1) {
                y--;
            }
            if (direction == 2) {
                y++;
            }
        }
        if (macchineInsieme == 1) {
            y = y + 3; // if it is from the boss then it moves vertically
        }

    }

    void draw(Graphics g) {
        int aa = (int) (Math.random() * 10) -5;
        if (posizione == 1) {
            if (count % 2 == 0) {
                cordx--;
            }
            if (count > 50+aa) {
                cordx--;
            }
            if (count > 100+aa) {
                cordx = cordx - 2;
            }
            if (count > 150+aa) {
                cordx = cordx - 3;
            }
            if (count > 200+aa) {
                cordx = cordx - 3;
            }
            if (count > 250+aa) {
                cordx = cordx - 4;
            }
            if (count > 300+aa) {
                cordx = cordx - 4;
            }
        }
        if (posizione == 2) {
            if (count % 4 == 0) {
                cordx--;
            }
            if (count > 50+aa && count % 2 == 0) {
                cordx--;
            }
            if (count > 100+aa) {
                cordx = cordx--;
            }
            if (count > 150+aa) {
                cordx = cordx - 2;
            }
            if (count > 200+aa) {
                cordx = cordx - 2;
            }
            if (count > 250+aa) {
                cordx = cordx - 2;
            }
        }
        if (posizione == 3) {
            if (count % 2 == 0 && count > 30+aa) {
                cordx++;
            }
            if (count > 50+aa && count % 2 == 0) {
                cordx++;
            }
            if (count > 100+aa) {
                cordx = cordx + 2;
            }
            if (count > 150+aa) {
                cordx = cordx + 2;
            }
            if (count > 200+aa) {
                cordx = cordx + 3;
            }
            if (count > 250+aa) {
                cordx = cordx + 3;
            }
        }

        if (posizione == 4) {
            if (count % 3 == 0 && count > 30+aa) {
                cordx++;
            }

            if (count > 100+aa) {
                cordx = cordx++;
            }

            if (count > 200+aa) {
                cordx = cordx++;
            }

        }
        
        if (tipoMacchina == 8) {
            g.drawImage(img, cordx + 15, cordy + 5, larghezza, (((int) altezza / 3) * 2), null);
        } else if (tipoMacchina == 5) {
            g.drawImage(img, cordx + 15, cordy + 5, larghezza, (((int) altezza / 4) * 3), null);
        } else if (tipoMacchina == 9) {
            g.drawImage(img, cordx + 15, cordy + 5, larghezza, altezza, null);

        } else {
            g.drawImage(img, cordx + 15, cordy + 5, larghezza, altezza, null);
        }

        count++;
        if (count % 15 == 0 && count < 100) {
            larghezza = larghezza + 4;
            altezza = altezza + 3;
        }
        if (count % 2 == 0 && count >= 100) {
            larghezza = larghezza + 4;
            altezza = altezza + 3;
        }
        if (count > 50+aa && count % 2 == 0 && count < 100) {
            cordy++;
        }
        if (count > 100+aa) {
            cordy++;
        }
        if (count > 150+aa) {
            cordy++;
        }
        if (count > 200+aa) {
            cordy++;
        }
        if (count > 250+aa) {
            cordy++;
        }
        if (count > 300+aa) {
            cordy++;
        }

    }

    Rectangle getHitbox() {
        if (tipoMacchina == 8) {
            return new Rectangle(cordx + 15, cordy + 5, larghezza, (((int) altezza / 3) * 2));
        } else if (tipoMacchina == 5) {
            return new Rectangle(cordx + 15, cordy + 5, larghezza, (((int) altezza / 4) * 3));
        } else if (tipoMacchina == 9) {
            return new Rectangle(cordx + 15, cordy + 5, larghezza, altezza);
        } else {
            return new Rectangle(cordx + 15, cordy + 5, larghezza, altezza);
        }

    }

}
