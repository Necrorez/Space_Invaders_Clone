package SpaceX05.Command;

import SpaceX05.Alien;

import java.util.ArrayList;
import java.util.List;

public class AlienMover {

    List<IAlienMove> moves;


    public AlienMover(){
        moves = new ArrayList<IAlienMove>();
    }

    public void run(IAlienMove move){
        moves.add(move);
        move.execute();
    }

    public void undo(){
        moves.get(moves.size()-1).undo();
        moves.remove(moves.size()-1);
    }
}
