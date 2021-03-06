package SpaceX05.Strategy;

import SpaceX05.Alien;
import SpaceX05.Commons;
import SpaceX05.Player;
import SpaceX05.Iterator.AlienAndWallIterator;
import SpaceX05.Shot;
import SpaceX05.Template.Collision;
import SpaceX05.Template.ShotCollision;
import SpaceX05.Visitor.EntityCountVisitor;
import SpaceX05.Visitor.EntityNameVisitor;
import SpaceX05.Visitor.EntityWinConditionVIsitor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BasicShot  extends Shot implements ShootingStrategy, Commons {
    private final String shot = "/Images/BasicShot.png";
    private final int H_SPACE = 6;
    private final int V_SPACE = 1;
    EntityCountVisitor countCalc = new EntityCountVisitor();
    EntityNameVisitor nameCalc = new EntityNameVisitor();
    EntityWinConditionVIsitor winDmgCalc = new EntityWinConditionVIsitor();

    public BasicShot(){
    }
    public BasicShot(int x, int y){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(shot));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
        setX(x + H_SPACE - 5);
        setY(y - V_SPACE);
    }
    public BasicShot(String img){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(img));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());

    }
    public void setCoords(int x, int y)
    {
        setX(x + H_SPACE - 5);
        setY(y - V_SPACE);
    }
    @Override
    public int shoot(ArrayList<Alien> aliens,ArrayList<Player> players) {
        int kills = 0;
        AlienAndWallIterator it = new AlienAndWallIterator(aliens);
        int X = getX();
        int Y = getY();
        while (it.hasNext()){

            Alien alien = (Alien) it.getNext();
            int alienX = alien.PosX;
            int alienY = alien.PosY;
            if (alien.isVisible() && isVisible()){
                if(X >= alienX && X <= (alienX + ALIEN_WIDTH)&& Y >= (alienY) && Y <= (alienY + ALIEN_HEIGHT)){

                    alien.die();
                    this.die();
                    kills++;
                    calc(aliens,players);
                }
            }

        }
        int y = getY();
        y -=4;
        if (y<0){
            this.die();
        }else{
            setY(y);
        }
        return kills;
    }
    public void calc(ArrayList<Alien> aliens,ArrayList<Player> players ){

        Iterator<Alien> it= aliens.iterator();
        while(it.hasNext()){
            Alien next =it.next();
            next.accept(countCalc);
            next.accept(nameCalc);
            next.accept(winDmgCalc);
        }

        Iterator<Player> iterPlayers = players.iterator();

        while(iterPlayers.hasNext()){
            Player next =iterPlayers.next();
            next.accept(countCalc);
            next.accept(nameCalc);
            next.accept(winDmgCalc);
        }


        System.out.println("EntityCounterReport");
        System.out.println(countCalc.report());

        System.out.println("EntityNameReport");
        System.out.println(nameCalc.report());

        System.out.println("EntityWinConditionReport");
        System.out.println(winDmgCalc.report());
    }

    @Override
    public int type() {
        return 1;
    }

    @Override
    public Shot returnShot(){
        return this;
    }

}
