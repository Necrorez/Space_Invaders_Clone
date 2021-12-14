package SpaceX05.Memento;

import SpaceX05.Player;

public class ExtraLife implements IWideMemento{

    String player;
    int width;
    int left;
    int right;
    int shoot;
    public int healthpoints= 30;
    public String type="Player1";


    public ExtraLife(String Player,int Width,int Left,int Right,int Shoot,int Healthpoints,String Type){
        player = Player;
        width=Width;
        left = Left;
        right =Right;
        shoot = Shoot;
        healthpoints = Healthpoints;
        type = Type;
    }

    @Override
    public String getPlayer() {
        return player;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getShoot() {
        return shoot;
    }

    @Override
    public int getLeft() {
        return left;
    }

    @Override
    public int getRight() {
        return right;
    }

    @Override
    public int getHealthpoints() {
        return healthpoints;
    }

    @Override
    public void setLeft(int Left) {
        left = Left;
    }

    @Override
    public void setRight(int Right) {
        right =Right;
    }

    @Override
    public void setShoot(int Shoot) {
        shoot = Shoot;
    }

    @Override
    public void setWidth(int Width) {
        width = Width;
    }

    @Override
    public void setHealthpoints(int Healthpoints) {
        healthpoints = Healthpoints;
    }

    @Override
    public void setPlayer(String Player) {
        player = Player;
    }

    @Override
    public void setType(String Type) {
        type = Type;
    }
}
