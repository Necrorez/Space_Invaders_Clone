package SpaceX05.Command;

import SpaceX05.Alien;

public class LeftCommand implements IAlienMove{
    private final Alien alien;

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for LeftCommand object
     * @param al
     * @return
     */
    @SuppressWarnings("SSDoc")
    public LeftCommand(Alien al){
        this.alien = al;
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
