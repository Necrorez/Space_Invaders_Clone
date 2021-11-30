package SpaceX05.Command;

import SpaceX05.Alien;

public class RightCommand implements IAlienMove{
    private final Alien alien;

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for RightCommand object
     * @param al
     * @return
     */
    @SuppressWarnings("SSDoc")
    public RightCommand(Alien al){
        this.alien = al;
    }

    @Override
    public void execute() {
        alien.PosX = alien.PosX+1;
    }

    @Override
    public void undo() {
        alien.PosX = alien.PosX-1;
    }
}
