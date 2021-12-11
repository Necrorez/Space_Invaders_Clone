package SpaceX05.Visitor;

import SpaceX05.Alien;
import SpaceX05.Player;

public class EntityWinConditionVIsitor implements Visitor {

    int count = 0;
    int playerHealthCount = 0;
    int alienHealthCount=0;
    public void visit(Player player)
    {
        playerHealthCount+= player.healthpoints;
    }

    public void visit(Alien alien)
    {
        alienHealthCount+=alien.healthPoints;
    }


    public String report()
    {

        String report = "Players need to deal " + String.valueOf(alienHealthCount)+"  damage to win " +"\n" + "Aliens need to deal: " + String.valueOf(playerHealthCount) +" damage to win or reach bottom of the arena"+ "\n" ;
        return report;
    }
}
