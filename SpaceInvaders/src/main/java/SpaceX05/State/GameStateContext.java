package SpaceX05.State;

public class GameStateContext {

    private  GameState currentState;

    public  GameStateContext(){

        GameState BeginningGameState = new BeginningGameState();
        GameState DuringGameState = new DuringGameState();
        GameState EndingGameState = new EndingGameState();

        BeginningGameState.setNextState(DuringGameState);

        DuringGameState.setNextState(EndingGameState);

        EndingGameState.setNextState(BeginningGameState);

        currentState = BeginningGameState;
        System.out.println(currentState.getStateString());

    }

    public  GameState operate(){
        currentState.getNextState(this);

        currentState.stateOperation();
        return currentState;
    }

    public void setState(GameState nextState) {
        this.currentState = nextState;
    }

    public String getState() {
        currentState.stateOperation();
        return currentState.getStateString();
    }





}
