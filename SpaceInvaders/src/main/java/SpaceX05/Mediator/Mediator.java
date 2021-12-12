package SpaceX05.Mediator;

import javax.swing.*;

public interface Mediator {
    void startNewGame();
    void exitGame();
    void saveChanges();
    void createMainGui();
    void hideElements(boolean flag);
    void selectLevel();
    void registerComponent(Component component);
}
