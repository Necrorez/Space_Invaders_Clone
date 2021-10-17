package SpaceX05.Factory;

import SpaceX05.PowerUps.PowerUp;

public  abstract  class Factory {

    public abstract PowerUp factoryMethod(String param, int PosX, int PosY);
    public abstract PowerUp getPowerUp(String param);

}