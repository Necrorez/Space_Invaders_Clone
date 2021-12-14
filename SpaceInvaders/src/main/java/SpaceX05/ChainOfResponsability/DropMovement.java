package SpaceX05.ChainOfResponsability;

import SpaceX05.Alien;
import SpaceX05.Command.*;

import java.util.Objects;

public class DropMovement extends Movement{

    public DropMovement(AlienMover alienMover, String movement) {
        super(alienMover, movement);
    }

    @Override
    public void UpdateDirection(String movementType) {
        if(Objects.equals(movementType, typeOfMovement)){
        }
        else{
            next.UpdateDirection(movementType);
        }

    }

    @Override
    public void Move(Alien alien, String movementType) {
        if(Objects.equals(movementType, typeOfMovement)) {
            alienMoves.run(new DownCommand(alien));
        }
        else{
            next.Move(alien,movementType);
        }

    }
}
