package SpaceX05.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExitButton extends JButton implements Component{
    private Mediator mediator;


    public ExitButton(){
        super("Exit");
    }

    @Override
    public void fireActionPerformed(ActionEvent e) {
        mediator.exitGame();
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName(){
        return "ExitButton";
    }
}
