package SpaceX05.Command;

import SpaceX05.Alien;

public class RightDownCommand implements IAlienMove{
    private final Alien alien;

    public RightDownCommand(Alien al){
        alien = al;
    }

    @Override
    public void execute() {
        alien.PosX = alien.PosX+1;
        alien.PosY = alien.PosY+1;
    }

    @Override
    public void undo() {
        alien.PosX = alien.PosX-1;
        alien.PosY = alien.PosY-1;
    }

}
