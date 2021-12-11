package SpaceX05.State;

public class DuringGameState extends  GameState{

    public String state = "during";
    @Override
    public void stateOperation() {
        System.out.println("Game is in progress");
    }

    public  GameState getNextState(){
        return  new EndingGameState();
    }


    @Override
    public String getStateString() {
        return state;
    }
}
