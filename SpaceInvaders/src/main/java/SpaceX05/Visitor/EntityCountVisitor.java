package SpaceX05.Visitor;

import SpaceX05.Alien;
import SpaceX05.Aliens.Squid;
import SpaceX05.Player;
import SpaceX05.WallBuilder.Wall;

public class EntityCountVisitor implements Visitor {

    int count = 0;
    int playerCount = 0;

    int alienCount = 0;
    int wallsCount = 0;
    public void visit(Player player)
    {
        playerCount++;
        count++;
    }

    public void visit(Alien alien)
    {
        alienCount++;
        count++;
    }


    public String report()
    {
        String report = "Total entities: " + String.valueOf(count)+ "\n" + "Players: " + String.valueOf(playerCount) + "\n" + "Aliens: " + String.valueOf(alienCount)+ "\n";
        count = 0;
        alienCount = 0;
        playerCount = 0;
        return report;
    }

}
