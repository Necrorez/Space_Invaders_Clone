package SpaceX05.Factory;

import SpaceX05.Alien;

public  abstract  class AbstractFactory {

//    public abstract Alien factoryMethod(String param, int PosX, int PosY);
    public abstract Alien spawnCrab(String param, int alienId, int PosX, int PosY);
    public abstract Alien spawnSquid(String param, int alienId, int PosX, int PosY);
    public abstract Alien spawnUfo(String param, int alienId, int PosX, int PosY);

    public abstract Alien getAlienShip(String param);

}
