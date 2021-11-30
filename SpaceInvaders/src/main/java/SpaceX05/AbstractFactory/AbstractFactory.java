package SpaceX05.AbstractFactory;


import SpaceX05.Alien;

public  abstract  class AbstractFactory {
    
    /**
     * TODO | DOING | DONE
     * DONE
     * Abstract method to spawn crab aliens
     * @param param, alienId, PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public abstract Alien spawnCrab(String param, int alienId, int PosX, int PosY);
    /**
     * TODO | DOING | DONE
     * DONE
     * Abstract method to spawn Squid aliens
     * @param param, alienId, PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public abstract Alien spawnSquid(String param, int alienId, int PosX, int PosY);
    /**
     * TODO | DOING | DONE
     * DONE
     * Abstract method to spawn Ufo aliens
     * @param param, alienId, PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public abstract Alien spawnUfo(String param, int alienId, int PosX, int PosY);

}
