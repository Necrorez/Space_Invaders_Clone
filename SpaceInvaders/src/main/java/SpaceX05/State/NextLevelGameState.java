package SpaceX05.State;

public class NextLevelGameState  extends  GameState{

    public String state = "nextlevel";
    @Override
    public void stateOperation() {
        System.out.println("Loading next level");
    }

    public  GameState getNextState(){
        return  new DuringGameState();
    }


    @Override
    public String getStateString() {
        return state;
    }
}
