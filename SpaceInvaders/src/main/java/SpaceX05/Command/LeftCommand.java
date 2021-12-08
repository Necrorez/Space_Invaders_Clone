package SpaceX05.Command;

import SpaceX05.Alien;

public class LeftCommand implements IAlienMove{
    private final Alien alien;

    public LeftCommand(Alien al){
        alien = al;
    }

    @Override
    public void execute() {
        alien.PosX = alien.PosX-1;
    }

    @Override
    public void undo() {
        alien.PosX = alien.PosX+1;
    }
}
