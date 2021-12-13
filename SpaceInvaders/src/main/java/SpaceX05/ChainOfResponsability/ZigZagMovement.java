package SpaceX05.ChainOfResponsability;

import SpaceX05.Alien;
import SpaceX05.Command.*;

import java.util.Objects;

public class ZigZagMovement extends Movement{

    private boolean zigUp;
    private int zigCount;

    public ZigZagMovement(AlienMover alienMover,String movement) {
        super(alienMover, movement);
        zigUp = true;
        zigCount = 7;
    }

    @Override
    public void UpdateDirection(String movementType) {
        if(Objects.equals(movementType, typeOfMovement)){
            if (sideMove){
            zigCount--;
            if (zigCount==0){
                zigCount=7;
                zigUp = !zigUp;
            }
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
        else{
            next.UpdateDirection(movementType);
        }
    }

    @Override
    public void Move(Alien alien, String movementType){
        if(Objects.equals(movementType, typeOfMovement)) {

            if (sideMove){
            if (direction){
                if (zigUp){
                    alienMoves.run(new RightUpCommand(alien));
                }
                else {
                    alienMoves.run(new RightDownCommand(alien));
                }
                if(alien.PosX>rightMostAlien){
                    rightMostAlien = alien.PosX;
                }

            }
            else {
                if (zigUp){
                    alienMoves.run(new LeftUpCommand(alien));
                }
                else {
                    alienMoves.run(new LeftDownCommand(alien));
                }
                if(alien.PosX<leftMostAlien){
                    leftMostAlien = alien.PosX;
                }
            }
        }
        else {
            alienMoves.run(new DownCommand(alien));
            alienDownMove--;
        }
        }
        else{
            next.Move(alien,movementType);
        }
    }
}
