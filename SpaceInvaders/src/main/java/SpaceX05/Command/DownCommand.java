package SpaceX05.Command;

import SpaceX05.Alien;

public class DownCommand implements IAlienMove{
    private Alien alien;

    public DownCommand(Alien al){
        alien = al;
    }

    @Override
    public void execute() {
        alien.PosY = alien.PosY+1;
    }

    @Override
    public void undo() {
        alien.PosY = alien.PosY-1;
    }
}
