package SpaceX05.Memento;

import SpaceX05.Location;
import SpaceX05.Player;

public interface IWideMemento extends INarrowMemento {

    public String getPlayer();
    public String getType();
    public int getWidth();
    public int getShoot();
    public int getLeft();
    public int getRight();
    public int getHealthpoints();

    public void setLeft(int left);
    public void setRight(int right);
    public void setShoot(int shoot);
    public void setWidth(int width);
    public void setHealthpoints(int healthpoints);
    public void setPlayer(String player);
    public void setType(String type);
}
