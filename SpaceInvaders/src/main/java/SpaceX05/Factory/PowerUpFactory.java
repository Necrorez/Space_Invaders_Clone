package SpaceX05.Factory;

import SpaceX05.PowerUps.AttackSpeed;
import SpaceX05.PowerUps.ExtraLife;
import SpaceX05.PowerUps.MovementSpeed;
import SpaceX05.PowerUps.PowerUp;

public class PowerUpFactory extends Factory {
    private int powerUpId = 0;
    private final String attackSpeedImg = "/Images/PowerUps/AttackSpeed.png";
    private final String extraLifeImg = "/Images/PowerUps/ExtraLife.png";
    private final String movementSpeedImg = "/Images/PowerUps/MovementSpeed.png";

    @Override
    public PowerUp factoryMethod(String param, int PosX, int PosY){
        switch (param){
            case "AttackSpeed":
                powerUpId++;
                return new AttackSpeed(attackSpeedImg,powerUpId,PosX,PosY);
            case "ExtraLife":
                powerUpId++;
                return new ExtraLife(extraLifeImg,powerUpId,PosX,PosY);
            case "MovementSpeed":
                powerUpId++;
                return new MovementSpeed(movementSpeedImg,powerUpId,PosX,PosY);
            default:
                throw new RuntimeException("Invalid entry");
        }
    }
    @Override
    public PowerUp getPowerUp(String param){
        return new PowerUp() {
        };
    }

}
