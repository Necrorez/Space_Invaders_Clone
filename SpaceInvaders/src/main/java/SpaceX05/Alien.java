package SpaceX05;



public abstract class Alien extends Sprite implements  Cloneable {

    public int id ;
    public int damagePoints;
    public int healthPoints ;
    public int PosX ;
    public int PosY;


    /**
     * TODO | DOING | DONE
     * DONE
     * Deep copy for the allien model
     * @return player
     */
    @SuppressWarnings("SSDoc")
    public Alien copyShallow()
    {
        try {
            return (Alien)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }


}
