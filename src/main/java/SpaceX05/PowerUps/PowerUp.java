package SpaceX05.PowerUps;

import SpaceX05.Sprite;

public abstract class PowerUp extends Sprite {

    public int id ;
    public int PosX ;
    public int PosY;

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PowerUp)) {
            return false;
        }

        PowerUp that = (PowerUp) other;

        // Custom equality check here.
        return this.id==that.id && this.PosX==that.PosX &&this.PosY==that.PosY;

    }

}

