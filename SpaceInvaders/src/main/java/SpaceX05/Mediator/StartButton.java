package SpaceX05.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartButton extends JButton implements Component {
    private Mediator mediator;


    public StartButton(){
        super("Start");
    }

    @Override
    public void fireActionPerformed(ActionEvent e) {
        mediator.startNewGame();
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName(){
        return "StartButton";
    }
}
