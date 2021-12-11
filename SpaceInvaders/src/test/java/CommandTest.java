import SpaceX05.AbstractFactory.BalancedAliensFactory;
import SpaceX05.Alien;
import SpaceX05.Command.*;

import SpaceX05.Location;
import SpaceX05.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CommandTest {

    private AlienMover alienMover;
    private Alien alien;

    @BeforeEach
    void innit(){
        alienMover = new AlienMover();
        BalancedAliensFactory balanced = new BalancedAliensFactory();
        alien = balanced.spawnSquid("Squid", 0,120,100);
    }

    @Test
    void run() {
        int startX = alien.PosX;
        int startY = alien.PosY;
        alienMover.run(new RightCommand(alien));
        int xAfterRightBeforeLeft =alien.PosX;
        int yAfterRightBeforeLeft =alien.PosY;
        alienMover.run(new LeftCommand(alien));
        int xAfterLeftBeforeDown =alien.PosX;
        int yAfterLeftBeforeDown =alien.PosY;
        alienMover.run(new DownCommand(alien));


        //after right
        assertEquals(startX+1,xAfterRightBeforeLeft);
        assertEquals(startY,yAfterRightBeforeLeft);
        //after left
        assertEquals(xAfterRightBeforeLeft-1,xAfterLeftBeforeDown);
        assertEquals(yAfterRightBeforeLeft,yAfterLeftBeforeDown);
        //after down
        assertEquals(xAfterLeftBeforeDown,alien.PosX);
        assertEquals(yAfterLeftBeforeDown+1,alien.PosY);

    }

    @Test
    void undo() {
        int startX = alien.PosX;
        int startY = alien.PosY;
        alienMover.run(new RightCommand(alien));
        alienMover.run(new LeftCommand(alien));
        alienMover.run(new DownCommand(alien));
        alienMover.undo();
        alienMover.undo();
        alienMover.undo();
        alienMover.run(new DownCommand(alien));
        alienMover.undo();

        assertEquals(startX,alien.PosX);
        assertEquals(startY,alien.PosY);
    }
}