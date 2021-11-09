package SpaceX05;


public abstract class Alien extends Sprite implements  Cloneable {

    public int id ;
    public int damagePoints;
    public int healthPoints ;
    public int PosX ;
    public int PosY;


    public Alien copyShallow( )
    {
        try {
            return (Alien)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
