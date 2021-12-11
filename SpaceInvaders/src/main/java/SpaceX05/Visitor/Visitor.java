package SpaceX05.Visitor;

import SpaceX05.Alien;
import SpaceX05.Aliens.Squid;
import SpaceX05.Player;
import SpaceX05.WallBuilder.Wall;

public interface Visitor {

    void visit(Player player);
    void visit(Alien alien)  ;
    String report();
}
