package SpaceX05;


public class Settings {

    private static Settings single_instance = null;

    public int Board_Width;
    public int Board_Height;

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for the Singleton
     */
    @SuppressWarnings("SSDoc")
    private Settings() {
        Board_Width = 358;//358
        Board_Height = 500;//350
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Sends back the singleton settings
     * @return single_instance
     */
    @SuppressWarnings("SSDoc")
    public static Settings getInstance() {
        if (single_instance == null)
            single_instance = new Settings();

        return single_instance;
    }
}