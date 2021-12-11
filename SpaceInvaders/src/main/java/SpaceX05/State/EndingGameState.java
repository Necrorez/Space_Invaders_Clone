package SpaceX05.State;

public class EndingGameState  extends GameState {

    public String state = "ending";
    @Override
    public void stateOperation() {
        System.out.println("Game over");
    }

    @Override
    public String getStateString() {
        return state;
    }


}
