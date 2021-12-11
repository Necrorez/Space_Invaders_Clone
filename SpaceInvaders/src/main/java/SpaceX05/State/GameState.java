package SpaceX05.State;

public abstract class GameState {

    private  GameState nextState;


    public void setNextState(GameState nextState) {
        this.nextState = nextState;
    }

    public void getNextState(GameStateContext context )
    {
        context.setState(nextState);
    }

    public abstract void stateOperation( );

    public abstract String getStateString();
}
