package SpaceX05.ChainOfResponsability;

import SpaceX05.Alien;
import SpaceX05.Command.AlienMover;
import SpaceX05.Command.DownCommand;
import SpaceX05.Command.LeftCommand;
import SpaceX05.Command.RightCommand;

import java.util.Objects;

public class LineMovement extends Movement{

    public LineMovement(AlienMover alienMover,String movement) {
        super(alienMover, movement);
    }

    @Override
    public void UpdateDirection(String movementType) {
        if (sideMove){
            if (direction){
                if (rightMostAlien >= 320){
                    direction = false;
                    sideMove = false;
                    alienDownMove = 10;
                }
            }
            else {
                if (leftMostAlien <= 0){
                    direction = true;
                    sideMove = false;
                    alienDownMove = 10;
                }
            }
        }
        else {
            if (alienDownMove <= 0){
                sideMove = true;
                leftMostAlien =400;
                rightMostAlien = 0;
            }
        }
    }

    @Override
    public void Move(Alien alien, String movementType){
        if (sideMove) {
            if (direction) {
                alienMoves.run(new RightCommand(alien));
                if (alien.PosX > rightMostAlien) {
                    rightMostAlien = alien.PosX;
                }

            } else {
                alienMoves.run(new LeftCommand(alien));
                if (alien.PosX < leftMostAlien) {
                    leftMostAlien = alien.PosX;
                }
            }
        }
        else {
            alienMoves.run(new DownCommand(alien));
            alienDownMove--;
        }

    }
}
