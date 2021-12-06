package SpaceX05.State;

import javax.swing.plaf.nimbus.State;

public class BeginningGameState extends GameState{

    public String state = "begin";
    @Override
    public void stateOperation() {
        System.out.println("Game will begin soon...");
    }

    public  GameState getNextState(){
        return  new DuringGameState();
    }

    @Override
    public String getStateString() {
        return state;
    }



}
