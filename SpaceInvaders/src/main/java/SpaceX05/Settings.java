package SpaceX05;

import javax.swing.*;
import java.awt.*;

class Settings {

    private static Settings single_instance = null;

    public int Board_Width;
    public int Board_Height;

    private Settings() {
        Board_Width = 358;//358
        Board_Height = 500;//350
    }

    public static Settings getInstance() {
        if (single_instance == null)
            single_instance = new Settings();

        return single_instance;
    }
}