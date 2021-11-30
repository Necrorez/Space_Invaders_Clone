package SpaceX05.Factory;

import SpaceX05.PowerUps.PowerUp;

public  abstract  class Factory {

    /**
     * TODO | DOING | DONE
     * DONE
     * abstract method for Factory pattern
     * @param param, PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public abstract PowerUp factoryMethod(String param, int PosX, int PosY);
    /**
     * TODO | DOING | DONE
     * DONE
     * abstract method for Factory pattern
     * @param param
     */
    @SuppressWarnings("SSDoc")
    public abstract PowerUp getPowerUp(String param);

}