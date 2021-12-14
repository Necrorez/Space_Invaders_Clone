package SpaceX05;


import SpaceX05.Visitor.Visitable;
import SpaceX05.Visitor.Visitor;

import javax.swing.*;
import java.awt.*;


public class Player extends Sprite implements Commons,Cloneable,IPrototype, Visitable {
   // private final int START_Y = 280;
  //  private final int START_X = 50;
    public Location location;
    private String player;
    private int width;
    private String socketmessage = "";
    private int left;
    private int right;
    private int shoot;
    public  boolean controlled;
    public int damagepoints= 10;
    public int healthpoints= 30;
    public String type="Player1";

    public Player(String p, boolean controlled,Location loc) {
        player = p;
        location= loc;
        this.controlled = controlled;
        ImageIcon ii = new ImageIcon(this.getClass().getResource(player));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(PLAYER_HEIGHT, PLAYER_WIDTH, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        width = ii.getImage().getWidth(null);

        setImage(ii.getImage());
        setX(location.START_X);
        setY(location.START_Y);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);

    }
   public void setLoc(int x, int y){
        setX(x);
        setY(y);
    }

    public void changeImg (String p){
        player = p;
        ImageIcon ii = new ImageIcon(this.getClass().getResource(player));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(PLAYER_HEIGHT, PLAYER_WIDTH, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        width = ii.getImage().getWidth(null);

        setImage(ii.getImage());
    }

    public void update() {
        if (!controlled) {
            if (left > 0) {
                dx = -2;
            } else if (right > 0) {
                dx = 2;
            } else {
                dx = 0;
            }
            socketmessage = "MOVE " + dx + " " + shoot;
        }
        x += dx;
        if (x <= 2) {
            x = 2;
        }
        if (x >= BOARD_WIDTH - 2 * width) {
            x = BOARD_WIDTH - 2 * width;
        }

    }

    public Player copyShallow( )
    {
        try {
            return (Player)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public Player copyDeep( )
    {
        try {
            Player copy = (Player)this.clone();
            copy.setLocation(this.location.copyShallow());
            return copy;
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }


    public String getSocketmessage() {
        return socketmessage;
    }

    public void setLeft(int left) {
        this.left = left;
    }
    public void setRight(int right) {
        this.right = right;
    }
    public void setDirection(int direction) {
        this.dx = direction;
    }
    public int getShoot() {
        return shoot;
    }

    public void setShoot(int shoot) {
        this.shoot = shoot;
    }
    public String getPlayer(){
        return player;
    }
    public int getWidth(){
        return width;
    }

    public int getLeft() {
        return left;
    }
    public int getRight(){
        return right;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
