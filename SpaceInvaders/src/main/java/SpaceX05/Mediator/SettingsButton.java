package SpaceX05.Mediator;


import SpaceX05.Settings;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SettingsButton extends JButton implements Component {
    private Mediator mediator;

    public SettingsButton() {
        super("Settings");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.saveChanges();
    }

    @Override
    public String getName() {
        return "SettingsButton";
    }
}
