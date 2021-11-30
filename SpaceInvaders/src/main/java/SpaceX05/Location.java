package SpaceX05;

public class Location implements  Cloneable {
    public int START_Y = 280;
    public int START_X = 50;
    /**
     * TODO | DOING | DONE
     * DONE Constructor for Location
     */
    @SuppressWarnings("SSDoc")
    public Location() {
        super();
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Implementation of the copyShallow method
     */
    @SuppressWarnings("SSDoc")
    public Location copyShallow()
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
