package SpaceX05.Facade;

import SpaceX05.Factory.PowerUpFactory;
import SpaceX05.Player;
import SpaceX05.PowerUps.AttackSpeed;
import SpaceX05.PowerUps.ExtraLife;
import SpaceX05.PowerUps.MovementSpeed;
import SpaceX05.PowerUps.PowerUp;
import SpaceX05.WallBuilder.Wall;

public class Facade {


 public  Facade(){

 }

public Player PrototypeDemo(Player player){
 Player player2 = null;
 // player2 = player1.copyShallow();
 player2 = player.copyDeep();
 player2.changeImg("/Images/player2.png");
 player2.controlled = true;
 player2.setLoc(150,280);

 return  player2;
}
public Wall WallBuilderDemo(String color,int[][] placement,int y, int x){
 Wall wall = new Wall.WallBuilder()
         .color(color)
         .placement(placement)
         .y(y)
         .x(x)
         .build();

 return wall;

}

public PowerUp FactoryDemo (String type ,int x ,int y){
 PowerUpFactory factory = new PowerUpFactory();
 PowerUp powerUp;
 switch (type){
  case "AttackSpeed":
   powerUp = factory.factoryMethod("AttackSpeed",x,y) ;
   return powerUp;
  case "ExtraLife":
   powerUp = factory.factoryMethod("ExtraLife",x,y) ;
   return powerUp;
  case "MovementSpeed":
   powerUp = factory.factoryMethod("MovementSpeed",x,y) ;
   return powerUp;
  default:
   System.out.print("Incorrect PowerUp");
   return null;
 }

}

}
