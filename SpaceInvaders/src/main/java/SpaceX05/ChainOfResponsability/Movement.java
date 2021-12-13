package SpaceX05.ChainOfResponsability;

import SpaceX05.Alien;
import SpaceX05.Command.AlienMover;

public abstract class Movement {
    protected Movement next;
    protected String typeOfMovement;
    protected boolean direction;    //in which direction is sideways movement true - right, false - left
    protected boolean sideMove;     //Wheather moving sideways or down
    protected int rightMostAlien;
    protected int leftMostAlien;
    protected int alienDownMove;
    protected AlienMover alienMoves;

    public Movement(AlienMover alienMover){
        alienMoves = alienMover;
    }

    public abstract void UpdateDirection(String movementType);
    public abstract void Move(Alien alien, String movementType);
    public void setNextChain(Movement next){
        this.next = next;
    }

}
