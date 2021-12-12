package SpaceX05.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LevelButton extends JButton implements Component {
    private Mediator mediator;

    public LevelButton() {
        super("Select Level");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.selectLevel();
    }

    @Override
    public String getName() {
        return "LevelButton";
    }
}