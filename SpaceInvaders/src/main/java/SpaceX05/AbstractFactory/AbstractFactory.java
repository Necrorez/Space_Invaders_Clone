package SpaceX05.AbstractFactory;


import SpaceX05.Alien;

public  abstract  class AbstractFactory {
    
    public abstract Alien spawnCrab(String param,int PosX, int PosY);
    public abstract Alien spawnSquid(String param, int PosX, int PosY);
    public abstract Alien spawnUfo(String param, int PosX, int PosY);

}
