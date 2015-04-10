/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CiuendagliaGame;

import java.io.Serializable;

/**
 *
 * @author Nelly
 */
public class Player implements Serializable,Cloneable{
    String NickName;
    int points;
    int id;
    int seconds;
    public Player(){
    NickName= null;
    points = 0;
     id=0;
     seconds=0;
    }

    public Player(String NickName, int points, int id,int seconds) {
        this.NickName = NickName;
        this.points = points;
        this.id = id;
        this.seconds=seconds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    
    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
    }

    @Override
    public String toString() {
        return "Player{" + "NickName=" + NickName + ", points=" + points + ", id=" + id + '}';
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public void setID(int id){
    this.id=id;
    }
    public int getID(){
    return id;
    }
    
}
