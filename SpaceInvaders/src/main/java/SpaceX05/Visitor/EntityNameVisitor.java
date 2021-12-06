package SpaceX05.Visitor;

import SpaceX05.Alien;
import SpaceX05.Player;
import SpaceX05.WallBuilder.Wall;

public class EntityNameVisitor implements Visitor {
    String report = "";
    public void visit(Player player)
    {
        report += player.type +" healthpoints: "+player.healthpoints+ " damagepoints: "+player.damagepoints+  "\n";
    }

    public void visit(Alien alien)
    {
        report += alien.type + " healthpoints: "+alien.healthPoints+ " damagepoints: "+alien.damagePoints+ "\n";
    }


    public String report()
    {
        String report2 = report;
        report = "";
        return report2;
    }

}
