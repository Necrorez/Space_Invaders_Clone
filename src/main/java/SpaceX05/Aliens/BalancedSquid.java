package SpaceX05.Aliens;

import javax.swing.*;
import java.awt.*;

public class BalancedSquid extends Squid {


  public BalancedSquid(String src, int id, int PosX, int PosY){
      this.id = id;
      this.damagePoints = 10;
      this.healthPoints=10;
      this.PosX = PosX;
      this.PosY = PosY;

      ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
      Image image = ii.getImage();
      Image newimg = image.getScaledInstance(17, 17, Image.SCALE_SMOOTH);
      ii = new ImageIcon(newimg);
      setImage(ii.getImage());
  }
    public int getDamage(){return this.damagePoints;}
    public int getHealth() {return this.healthPoints;}

}