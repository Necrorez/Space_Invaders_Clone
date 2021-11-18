import SpaceX05.Settings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingsTest {

    @DisplayName("Testing Singleton( Settings) class")
    @Test
    void getInstance() {
        var set1 = Settings.getInstance();
        var set2 = Settings.getInstance();

        assertEquals(set1,set2);
    }
}