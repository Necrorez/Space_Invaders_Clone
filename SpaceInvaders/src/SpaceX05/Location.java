package SpaceX05;

public class Location implements  Cloneable {
    public int START_Y = 280;
    public int START_X = 50;
    public Location() {
        super();
    }

    public Location copyShallow( )
    {
        try {
            return (Location) this.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
