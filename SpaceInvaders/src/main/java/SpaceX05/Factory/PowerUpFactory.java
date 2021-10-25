package SpaceX05.Factory;

import SpaceX05.PowerUps.AttackSpeed;
import SpaceX05.PowerUps.ExtraLife;
import SpaceX05.PowerUps.MovementSpeed;
import SpaceX05.PowerUps.PowerUp;

public class PowerUpFactory extends Factory {
    private int powerUpId = 0;
    private String attackSpeedImg ="/SpaceX05/Images/PowerUps/AttackSpeed.png";
    private String extraLifeImg ="/SpaceX05/Images/PowerUps/ExtraLife.png";
    private String movementSpeedImg ="/SpaceX05/Images/PowerUps/MovementSpeed.png";

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
                System.out.print("x");
                return null;
        }
    }
    @Override
    public PowerUp getPowerUp(String param){
        return new PowerUp() {
        };
    }

}
