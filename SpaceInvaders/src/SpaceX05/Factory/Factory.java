package SpaceX05.Factory;

import SpaceX05.Alien;

public  abstract  class Factory {

    public abstract Alien factoryMethod(String param, int PosX, int PosY);
    public abstract Alien getAlienShip(String param);

}
