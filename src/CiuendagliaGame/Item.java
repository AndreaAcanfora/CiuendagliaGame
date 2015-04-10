/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CiuendagliaGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Item {

   
    int x;
    int y;
    int xVel;
    int yVel;
    int nItem;  // if nItem== 1 it is a item for life , if nItem == 2 it is a item for a rocket , if nItem == 3 it is triple hits .
    Image img;
    int width;
    int height;
    boolean OffScreen;
    public Item(int x,int y,int nItem,int width,int height) {
        this.nItem=nItem;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        OffScreen=false;
        this.xVel = 0;
        this.yVel = 0;
        if(nItem == 1){
        img= new ImageIcon("LifeItem.gif").getImage();  // if it is the item for life then take that image
                     }
        else if ( nItem == 2){   // it is the item for  do 3 hits in a shot
        
        img= new ImageIcon("ItemSBullet.png").getImage();
        }
        else if(nItem ==3){  // if it is 3 then it is takes the image of the special bullet ( "Rocket.png")
             if(GUI.level==2)
            img= new ImageIcon("Rocket.png").getImage();
             else
                             img= new ImageIcon("images/Rocket1.png").getImage();
        
        }
        
    }
    public void start(){
    
    x= (int) (Math.random()*(width-20));  // i add the start in a random X in a determinted second
        y=20;
                OffScreen=false;
       if(((int)Math.random()*21)>=10){      
       this.xVel = 3;
       }
       else{
       xVel= -3;
       }
        this.yVel = 2;

    }
    
    public void move(){
     x+=xVel;
        y += yVel;
    if(x>(width-20)){
     xVel=-1*(xVel);
    }
    if(x<0){
         xVel=-1*(xVel);
         
    }
    if(y>(height+20)){
    OffScreen=true;  // if it is offscreen it will be "removed"
    x=-20;
    y=-20;
    xVel=0;
    yVel=0;
    }
    
    
    
    }

    public boolean isOffScreen() {
        return OffScreen;
    }
    public void delItem(){
      xVel=0;
      yVel=0;
      x=-30;
      y=-30;
    }
    public void draw(Graphics g){
        
    g.drawImage(img, 0, 0,0,0, null);
    
    }
    public  Rectangle gethitItem(){
        
    return new Rectangle(0, 0,0, 0);
    }
    
}
