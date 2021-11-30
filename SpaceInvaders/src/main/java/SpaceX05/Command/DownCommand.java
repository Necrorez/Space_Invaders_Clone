package SpaceX05.Command;

import SpaceX05.Alien;

public class DownCommand implements IAlienMove{
    private final Alien alien;

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for DownCommand object
     * @param al
     * @return
     */
    @SuppressWarnings("SSDoc")
    public DownCommand(Alien al){
        this.alien = al;
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
