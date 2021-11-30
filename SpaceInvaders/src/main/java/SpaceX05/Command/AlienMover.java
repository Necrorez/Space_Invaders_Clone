package SpaceX05.Command;

import java.util.ArrayList;
import java.util.List;

public class AlienMover {

    List<IAlienMove> moves;


    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for AlienMover class
     * @param
     * @return
     */
    @SuppressWarnings("SSDoc")
    public AlienMover(){
        moves = new ArrayList<>();
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * method to add an aliens to the Aliens mover List and execute a command
     * @param move
     */
    @SuppressWarnings("SSDoc")
    public void run(IAlienMove move) {
        moves.add(move);
        move.execute();
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * method to remove an aliens from Aliens mover List
     */
    @SuppressWarnings("SSDoc")
    public void undo(){
        moves.get(moves.size()-1).undo();
        moves.remove(moves.size()-1);
    }
}
