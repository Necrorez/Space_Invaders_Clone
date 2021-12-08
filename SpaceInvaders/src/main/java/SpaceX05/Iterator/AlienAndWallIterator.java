package SpaceX05.Iterator;

import SpaceX05.Adapter.BasicWall;
import SpaceX05.Alien;

import java.util.ArrayList;
import java.util.List;

public class AlienAndWallIterator implements SpriteIterator {
    private List<Alien> alienList;
    private ArrayList<BasicWall> wallList;
    private int currentPositionWall = 0;
    private int currentPositionAlien = 0;
    private String type;

    public AlienAndWallIterator(List<Alien> alienList)
    {
        this.alienList = alienList;
        this.type = "alien";
    }

    public AlienAndWallIterator(ArrayList<BasicWall> wallList)
    {
        this.wallList = wallList;
        this.type = "wall";
    }


    public boolean hasNext() {
        switch (type) {
            case "alien":
                return currentPositionAlien < alienList.size();
            case "wall":
                return currentPositionWall < wallList.size();
            default:
                return false;
        }
    }

    public Alien getNextAlien() {
        if (!hasNext()) {
            return null;
        }
        Alien al = alienList.get(currentPositionAlien);
        currentPositionAlien++;
        return al;
    }

    public BasicWall getNextWall() {
        if (!hasNext()) {
            return null;
        }
        BasicWall al = wallList.get(currentPositionWall);
        currentPositionWall++;
        return al;
    }

    public void reset() {
        switch(type){
            case "alien":
                currentPositionAlien = 0;
            case "wall":
                currentPositionWall = 0;
        }
    }

}
