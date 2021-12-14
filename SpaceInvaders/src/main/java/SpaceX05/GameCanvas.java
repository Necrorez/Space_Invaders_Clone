package SpaceX05;


import SpaceX05.AbstractFactory.BalancedAliensFactory;
import SpaceX05.AbstractFactory.DefensiveAliensFactory;
import SpaceX05.AbstractFactory.OffensiveAliensFactory;
import SpaceX05.Aliens.*;
import SpaceX05.ChainOfResponsability.LineMovement;
import SpaceX05.ChainOfResponsability.Movement;
import SpaceX05.ChainOfResponsability.ZigZagMovement;
import SpaceX05.Composite.GroupedAlien;
import SpaceX05.Composite.Swarm;
import SpaceX05.Decorator.CrabDamagePointsDecorator;
import SpaceX05.Command.AlienMover;
import SpaceX05.Adapter.BasicWall;
import SpaceX05.Adapter.SquareWall;
import SpaceX05.Adapter.TriangleWall;
import SpaceX05.Adapter.WallAdapter;
import SpaceX05.Memento.ExtraLife;
import SpaceX05.Memento.LifeTracker;
import SpaceX05.State.GameStateContext;
import SpaceX05.Flyweight.ShotFactory;
import SpaceX05.Iterator.AlienAndWallIterator;
import SpaceX05.Proxy.BalancedCrabProxy;
import SpaceX05.Proxy.DefensiveCrabProxy;
import SpaceX05.Proxy.OffensiveCrabProxy;
import SpaceX05.Strategy.BasicShot;
import SpaceX05.Strategy.PowerShot;
import SpaceX05.Strategy.ShootingContext;
import SpaceX05.Template.Collision;
import SpaceX05.Template.WallCollision;
import SpaceX05.Visitor.EntityCountVisitor;
import SpaceX05.Visitor.EntityNameVisitor;
import SpaceX05.Visitor.EntityWinConditionVIsitor;
import SpaceX05.WallBuilder.Wall;
import SpaceX05.WallBuilder.WallBlockSquare;


import SpaceX05.PowerUps.PowerUp;

import SpaceX05.Factory.PowerUpFactory;
import SpaceX05.WallBuilder.WallBlockTriangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;


public class GameCanvas extends JPanel implements Runnable,Commons {
    GameStateContext gameState  = new GameStateContext();
    EntityCountVisitor countCalc = new EntityCountVisitor();
    EntityNameVisitor  nameCalc = new EntityNameVisitor();
    EntityWinConditionVIsitor winDmgCalc = new EntityWinConditionVIsitor();


    private Dimension d;
    private Player player1, player2;
    private PowerUp powerUp1;
    private final BalancedSquid squid = new BalancedSquid();
    private final OffensiveSquid squid2 = new OffensiveSquid();
    private final DefensiveSquid squid3 = new DefensiveSquid();
    private PowerUp pw;
    private ArrayList<Alien> aliens;
    private ArrayList<Player> players;
    private AlienMover alienMoves;
    private int lowestAlien = 0;

    private Swarm ufoSwarm;
    private Swarm crabSwarm;
    private Swarm squidSwarm;

    private Movement alienMove;

    private LifeTracker tracker;

    private Alien alien0;
    private Alien shallowcopy;
    private final int nplayers;
    private final int deaths = 0;
    private final int direction = -1;
    private boolean ingame1 = true, ingame2 = false; //player1 e player2
    private final String message = "Game Over";

    private Shot shot1;
    private Shot shot2;
    private ShootingContext context1;
    private ShootingContext context2;

    private  ArrayList<BasicWall> walls;

    private final String HOST = "1ocalhost";
    private final int PORT = 4000;
    private boolean worked;

    private Thread animator;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private BalancedCrab cr;

    public GameCanvas(int n, int level) {
        nplayers = n;
        setFocusable(true);
        addKeyListener(new TAdapter());

        d = new Dimension(BOARD_WIDTH, BOARD_HEIGTH);
        setBackground(Color.black);
        worked = gameStart(level);
        setDoubleBuffered(true);
    }

//    public GameCanvas(int n, int level) {
//        nplayers = n;
//        setFocusable(true);
//        addKeyListener(new TAdapter());
//
//        d = new Dimension(BOARD_WIDTH, BOARD_HEIGTH);
//        setBackground(Color.black);
//        worked = gameStart(level);
//        setDoubleBuffered(true);
//    }

    public void firstLevel()
    {
        walls = new ArrayList();
        Wall wall = new Wall.WallBuilder()
                .square(new WallBlockSquare("Blue"))
                .placement(new int[][]{
                        {0,0,1,0},
                        {0,1,1,0},
                        {1,1,1,1}})
                .y(50)
                .x(230)
                .build();
        WallAdapter target = new SquareWall(wall.getWallSquare());
        walls.addAll(target.getWall());

        wall = new Wall.WallBuilder()
                .triangle(new WallBlockTriangle("Purple"))
                .placement(new int[][]{
                        {1,0,1,1},
                        {1,0,1,1},
                        {1,1,1,1}})
                .y(250)
                .x(230)
                .build();
        target = new TriangleWall(wall.getWallTriangle());
        walls.addAll(target.getWall());

        BalancedAliensFactory balanced = new BalancedAliensFactory();
        DefensiveAliensFactory defensive = new DefensiveAliensFactory();
        OffensiveAliensFactory offensive = new OffensiveAliensFactory();
        aliens = new ArrayList<Alien>();
        int i;
        int id = 0;
        for (i = 0; i<3; i++){
            Alien alien = balanced.spawnSquid("Squid",100 + 20 * i,100);
            Alien alien1 = balanced.spawnCrab("Crab",  100 + 20 * i,120);
            Alien alien2 = balanced.spawnUfo("Ufo", 100 + 20 * i,140);
            Alien alien3 = defensive.spawnSquid("Squid", 40 + 20 * i,100);
            Alien alien4 = defensive.spawnCrab("Crab",  40 + 20 * i,120);
            Alien alien5 = defensive.spawnUfo("Ufo", 40 + 20 * i,140);
            Alien alien6 = offensive.spawnSquid("Squid", 160 + 20 * i,100);
            Alien alien7 = offensive.spawnCrab("Crab",  160 + 20 * i,120);
            Alien alien8 = offensive.spawnUfo("Ufo", 160 + 20 * i,140);

            aliens.add(alien);
            aliens.add(alien1);
            aliens.add(alien2);
            aliens.add(alien3);
            aliens.add(alien4);
            aliens.add(alien5);
            aliens.add(alien6);
            aliens.add(alien7);
            aliens.add(alien8);

            squidSwarm.add(alien);
            crabSwarm.add(alien1);
            ufoSwarm.add(alien2);
            squidSwarm.add(alien3);
            crabSwarm.add(alien4);
            ufoSwarm.add(alien5);
            squidSwarm.add(alien6);
            crabSwarm.add(alien7);
            ufoSwarm.add(alien8);

        }
    }

    public void secondLevel()
    {
        walls = new ArrayList();
        Wall wall = new Wall.WallBuilder()
                .square(new WallBlockSquare("Purple"))
                .placement(new int[][]{
                        {1,0,1,1},
                        {0,1,1,0},
                        {0,1,1,0}})
                .y(50)
                .x(230)
                .build();
        WallAdapter target = new SquareWall(wall.getWallSquare());
        walls.addAll(target.getWall());

        wall = new Wall.WallBuilder()
                .triangle(new WallBlockTriangle("Blue"))
                .placement(new int[][]{
                        {1,0,0,0},
                        {1,1,1,0},
                        {1,0,1,1}})
                .y(250)
                .x(230)
                .build();
        target = new TriangleWall(wall.getWallTriangle());
        walls.addAll(target.getWall());

        wall = new Wall.WallBuilder()
                .triangle(new WallBlockTriangle("Purple"))
                .placement(new int[][]{
                        {0,1,0,1},
                        {1,1,1,1},
                        {1,0,1,0}})
                .y(150)
                .x(230)
                .build();
        target = new TriangleWall(wall.getWallTriangle());
        walls.addAll(target.getWall());

        BalancedAliensFactory balanced = new BalancedAliensFactory();
        DefensiveAliensFactory defensive = new DefensiveAliensFactory();
        OffensiveAliensFactory offensive = new OffensiveAliensFactory();
        aliens = new ArrayList<Alien>();
        int i;
        for (i = 0; i<4; i++){

            Alien alien = balanced.spawnSquid("Squid",20 + 20 * i,100);
            Alien alien1 = balanced.spawnCrab("Crab",  20 + 20 * i,120);
            Alien alien2 = balanced.spawnUfo("Ufo", 20 + 20 * i,140);
            Alien alien3 = defensive.spawnSquid("Squid", 100 + 20 * i,100);
            Alien alien4 = defensive.spawnCrab("Crab",  100 + 20 * i,120);
            Alien alien5 = defensive.spawnUfo("Ufo", 100 + 20 * i,140);
            Alien alien6 = offensive.spawnSquid("Squid", 180 + 20 * i,100);
            Alien alien7 = offensive.spawnCrab("Crab",  180 + 20 * i,120);
            Alien alien8 = offensive.spawnUfo("Ufo", 180 + 20 * i,140);

            aliens.add(alien);
            aliens.add(alien1);
            aliens.add(alien2);
            aliens.add(alien3);
            aliens.add(alien4);
            aliens.add(alien5);
            aliens.add(alien6);
            aliens.add(alien7);
            aliens.add(alien8);

            squidSwarm.add(alien);
            crabSwarm.add(alien1);
            ufoSwarm.add(alien2);
            squidSwarm.add(alien3);
            crabSwarm.add(alien4);
            ufoSwarm.add(alien5);
            squidSwarm.add(alien6);
            crabSwarm.add(alien7);
            ufoSwarm.add(alien8);

        }
    }

    public void thirdLevel()
    {
        walls = new ArrayList();
        Wall wall = new Wall.WallBuilder()
                .square(new WallBlockSquare("Purple"))
                .placement(new int[][]{
                        {1,0,0,1},
                        {0,1,1,0},
                        {0,1,0,0}})
                .y(50)
                .x(230)
                .build();
        WallAdapter target = new SquareWall(wall.getWallSquare());
        walls.addAll(target.getWall());

        wall = new Wall.WallBuilder()
                .triangle(new WallBlockTriangle("Blue"))
                .placement(new int[][]{
                        {1,0,0,0},
                        {1,0,1,0},
                        {1,0,1,1}})
                .y(250)
                .x(230)
                .build();
        target = new TriangleWall(wall.getWallTriangle());
        walls.addAll(target.getWall());

        wall = new Wall.WallBuilder()
                .triangle(new WallBlockTriangle("Purple"))
                .placement(new int[][]{
                        {0,1,0,1},
                        {0,1,0,1},
                        {1,0,1,0}})
                .y(130)
                .x(230)
                .build();
        target = new TriangleWall(wall.getWallTriangle());
        walls.addAll(target.getWall());

        wall = new Wall.WallBuilder()
                .square(new WallBlockSquare("Purple"))
                .placement(new int[][]{
                        {0,1,1,0},
                        {0,1,1,1},
                        {1,1,0,0}})
                .y(180)
                .x(230)
                .build();
        target = new SquareWall(wall.getWallSquare());
        walls.addAll(target.getWall());

        BalancedAliensFactory balanced = new BalancedAliensFactory();
        DefensiveAliensFactory defensive = new DefensiveAliensFactory();
        OffensiveAliensFactory offensive = new OffensiveAliensFactory();
        aliens = new ArrayList<Alien>();
        int i;
        for (i = 0; i<5; i++){
            Alien alien = balanced.spawnSquid("Squid",200 + 20 * i,100);
            Alien alien1 = balanced.spawnCrab("Crab",  200 + 20 * i,120);
            Alien alien2 = balanced.spawnUfo("Ufo", 200 + 20 * i,140);
            Alien alien3 = defensive.spawnSquid("Squid", 20 * i,100);
            Alien alien4 = defensive.spawnCrab("Crab", 20 * i,120);
            Alien alien5 = defensive.spawnUfo("Ufo", 20 * i,140);
            Alien alien6 = offensive.spawnSquid("Squid", 100 + 20 * i,100);
            Alien alien7 = offensive.spawnCrab("Crab",  100 + 20 * i,120);
            Alien alien8 = offensive.spawnUfo("Ufo", 100 + 20 * i,140);


            aliens.add(alien);
            aliens.add(alien1);
            aliens.add(alien2);
            aliens.add(alien3);
            aliens.add(alien4);
            aliens.add(alien5);
            aliens.add(alien6);
            aliens.add(alien7);
            aliens.add(alien8);

            squidSwarm.add(alien);
            crabSwarm.add(alien1);
            ufoSwarm.add(alien2);
            squidSwarm.add(alien3);
            crabSwarm.add(alien4);
            ufoSwarm.add(alien5);
            squidSwarm.add(alien6);
            crabSwarm.add(alien7);
            ufoSwarm.add(alien8);

        }
    }

    public boolean gameStart(int level){


        while (true){
            switch (gameState.getState()) {
                case "begin" -> {
                    shot1 = ShotFactory.getShot("Basic");
                    shot2 = ShotFactory.getShot("Basic");

                    context1 = new ShootingContext(new BasicShot());
                    context2 = new ShootingContext(new BasicShot());

                    //create mover
                    AlienMover alienMoves = new AlienMover();

                    //create swarms
                    ufoSwarm = new Swarm("Ufo");
                    crabSwarm = new Swarm("Crab");
                    squidSwarm = new Swarm("Squid");

                    //create movements
                    Movement ufoMove = new LineMovement(alienMoves,"Ufo");
                    Movement crabMove = new ZigZagMovement(alienMoves,"Crab");
                    Movement squidMove = new ZigZagMovement(alienMoves,"Squid");

                    //chain movements
                    squidMove.setNextChain(crabMove);
                    crabMove.setNextChain(ufoMove);

                    //set chain start
                    alienMove = squidMove;

                    tracker = new LifeTracker();

                    switch (level){
                        case 2:
                            secondLevel();
                            break;
                        case 3:
                            thirdLevel();
                            break;
                        default:
                            firstLevel();
                    }
                    Crab c = new OffensiveCrab(10, 10);
                    System.out.println("Initial damage and health" + c.damagePoints + " " + c.healthPoints);
                    Crab dmg = new CrabDamagePointsDecorator(new CrabDamagePointsDecorator(c));
                    System.out.println("Added damage" + dmg.getDamage() + " " + dmg.getHealth());
                    dmg.setImage(3);
                    aliens.add(dmg);

                    Squid newAl = new BalancedSquid(20, 50);
                    System.out.println(newAl.getClass());
                    aliens.add(newAl);

                    Iterator<Alien> iter = aliens.iterator();


                    while(iter.hasNext()){
                        Alien next =iter.next();
                        next.accept(countCalc);
                        next.accept(nameCalc);
                        next.accept(winDmgCalc);
                    }





                    //powerup
                    PowerUpFactory factory = new PowerUpFactory();

                    // powerUp1 = factory.factoryMethod("ExtraLife",160,160) ;
                    // powerUp1 = factory.factoryMethod("MovementSpeed",160,160) ;
                    powerUp1 = factory.factoryMethod("AttackSpeed",160,160) ;

                    pw = factory.factoryMethod("ExtraLife", 50, 50);

                    // Set up player input and socket
                    players = new ArrayList<Player>();
                    player1 = new Player("/Images/player.png",false,new Location());


                    player2 = null;

                    if (nplayers == 2){
                        // player2 = player1.copyShallow();
                        player2 = player1.copyDeep();
                        player2.changeImg("/Images/player2.png");
                        player2.controlled = true;
                        player2.type="Player2";
//            player2.setLoc(150,280);
                        ingame2 = true;
                        try {
                            socket = new Socket(SERVER_IP.get(),4000);
                            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
                            input = new BufferedReader(reader);
                            output = new PrintWriter(socket.getOutputStream(),true);
                            input.readLine();
                        }catch (IOException ioException){
                            return false;

                            //ioException.printStackTrace();
                        }
                    }
                    players.add(player1);
                    players.add(player2);
                    Iterator<Player> iterPlayers = players.iterator();

                    while(iterPlayers.hasNext()){
                        Player next =iterPlayers.next();
                        next.accept(countCalc);
                        next.accept(nameCalc);
                        next.accept(winDmgCalc);
                    }


                    System.out.println("EntityCounterReport");
                    System.out.println(countCalc.report());

                    System.out.println("EntityNameReport");
                    System.out.println(nameCalc.report());

                    System.out.println("EntityWinConditionReport");
                    System.out.println(winDmgCalc.report());

                    gameState.operate();
                }
                case "during" -> {

                    if (animator == null || (!ingame1 && !ingame2)){
                        animator = new Thread(this);
                        animator.start();

                    }
                    return true;
                }
                case "nextlevel" -> {
                    //load next lvl
                }
                case "ending" -> {
                    gameOver(this.getGraphics());
                    System.out.println("Game over");
                 //   gameState.operate();

                }
            }
        }



    }

    public  void TimeOut(){


    }

    public void animationCycle() throws IOException {

        /*if (deaths == NUMBER_OF_ALIENS_TO_DESTROY) {
            ingame1 = false;
            ingame2 = false;
            message = "Game won!";
        }*/

        // player
        player1.update();
        player2.update();

        //Creating shots
        if (!shot1.isVisible() && player1.getShoot() == 1) {
            if (context1.whichType() == 1){
                shot1 = ShotFactory.getShot("Basic");
                shot1.setCoords(player1.getX(), player1.getY());
                shot1.setVisible(true);
                //shot1 = new BasicShot(player1.getX(), player1.getY());
                context1 = new ShootingContext((BasicShot)shot1);

            }
            if (context1.whichType() == 2){
                shot1 = ShotFactory.getShot("Power");
                shot1.setCoords(player1.getX(), player1.getY());
                shot1.setVisible(true);
                //shot1 = new PowerShot(player1.getX(), player1.getY());
                context1 = new ShootingContext((PowerShot)shot1);

            }

        }
        if (nplayers>1){
            if (!shot2.isVisible() && player2.getShoot() == 1) {
                if (context2.whichType() == 1){
                    shot2 = ShotFactory.getShot("Basic");
                    shot2.setCoords(player2.getX(), player2.getY());
                    shot2.setVisible(true);
                    //shot2 = new BasicShot(player2.getX(), player2.getY());
                    context2 = new ShootingContext((BasicShot)shot2);
                }
                if (context2.whichType() == 2){
                    shot2 = ShotFactory.getShot("Power");
                    shot2.setCoords(player2.getX(), player2.getY());
                    shot2.setVisible(true);
                    //shot2 = new PowerShot(player2.getX(), player2.getY());
                    context2 = new ShootingContext((PowerShot)shot2);
                }
            }
        }
        context1.executeShoot(aliens,players);
        context2.executeShoot(aliens,players);
        shot1 = context1.rShot();
        shot2 = context2.rShot();

        for (Alien alien:aliens) {
            for (BasicWall wall : walls) {
                Collision collision = new WallCollision();
                collision.checkHit(alien, wall);
            }
        }

        Swarm tempswarm = new Swarm("Line");
        tempswarm.add(squidSwarm);
        tempswarm.add(crabSwarm);
        tempswarm.add(ufoSwarm);
        GroupedAlien swarm = tempswarm;
        moveAlienFromSwarm(swarm, tempswarm.getSwarmingWay());

        /*
        for (Player player:players) {
            for (PowerUp power:powerUps) {
                if(player.y == power.y&&player.x == power.x){
                    tracker.addLife(new ExtraLife(player.getPlayer(),player.getWidth(),player.getLeft(),player.getRight(),player.getShoot(),player.healthpoints,player.type));
                }
            }
            if (player.healthpoints<=0){
                ExtraLife life = (ExtraLife)tracker.getLife(player.getPlayer());
                player.setWidth(life.getWidth());
                player.setLeft(life.getLeft());
                player.setRight(life.getRight());
                player.setShoot(life.getShoot());
                player.healthpoints = life.healthpoints;
                player.type = life.type;
            }
        }//*/

        if(lowestAlien>=270){
           // gameOver();
            gameState.operate();
        }
    }

    private void moveAlienFromSwarm(GroupedAlien swarm, String swarming){
        if (swarm.isAlien()){
            alienMove.Move((Alien) swarm, swarming);
            if (lowestAlien <((Alien) swarm).PosY){
                lowestAlien = ((Alien) swarm).PosY;
            }
        }
        else {
            Swarm swarm1 = (Swarm)swarm;
            for (GroupedAlien smallerSwarm: swarm1.getSwarm()) {
                moveAlienFromSwarm(smallerSwarm,swarm1.getSwarmingWay());
            }
            alienMove.UpdateDirection(swarm1.getSwarmingWay());
        }
    }


    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);

        if (ingame1 || ingame2) {

            g.drawLine(0, GROUND, BOARD_WIDTH, GROUND);
            drawAliens(g);
            drawPlayers(g);
            drawShot(g);
            drawWall(g);

        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void drawShot(Graphics g) {
        if (shot1.isVisible()) {
            g.drawImage(shot1.getImage(), shot1.getX(), shot1.getY(), this);
        }
        if (shot2.isVisible()) {
            g.drawImage(shot2.getImage(), shot2.getX(), shot2.getY(), this);
        }
    }

    public  void drawAliens(Graphics g){

        AlienAndWallIterator it = new AlienAndWallIterator(aliens);


       // g.drawImage(shallowcopy.getImage(), shallowcopy.PosX, shallowcopy.PosY, this);
      //  g.drawImage(alien0.getImage(), alien0.PosX, alien0.PosY, this);
        while (it.hasNext()){
            Alien alien = (Alien) it.getNext();
            if (alien.isVisible()){
                if (alien.getClass().equals(BalancedCrabProxy.class))
                {
                    aliens.set(aliens.indexOf(alien), ((BalancedCrabProxy) alien).setToBCrabWithImage());
                }
                if (alien.getClass().equals(DefensiveCrabProxy.class))
                {
                    aliens.set(aliens.indexOf(alien), ((DefensiveCrabProxy) alien).setToBCrabWithImage());
                }
                if (alien.getClass().equals(OffensiveCrabProxy.class))
                {
                    aliens.set(aliens.indexOf(alien), ((OffensiveCrabProxy) alien).setToBCrabWithImage());
                }
                g.drawImage(alien.getImage(), alien.PosX, alien.PosY, this);
            }
            else if (!alien.isVisible())
            {
                if (alien.getClass().equals(squid.getClass()))
                {
                    PowerUp p = ((BalancedSquid) alien).rollPower();
                    g.drawImage(p.getImage(), alien.PosX, alien.PosY, this);
                }
                if (alien.getClass().equals(squid2.getClass()))
                {
                    PowerUp p = ((OffensiveSquid) alien).rollPower();
                    g.drawImage(p.getImage(), alien.PosX, alien.PosY, this);
                }
                if (alien.getClass().equals(squid3.getClass()))
                {
                    PowerUp p = ((DefensiveSquid) alien).rollPower();
                    g.drawImage(p.getImage(), alien.PosX, alien.PosY, this);
                }

            }
            if (alien.isDying()){
                alien.die();


            }
        }

    }

    public void drawWall(Graphics g){
        AlienAndWallIterator it = new AlienAndWallIterator((ArrayList<BasicWall>) walls);
        while (it.hasNext()){
            BasicWall wall = (BasicWall) it.getNext();
            if(wall.isVisible()){
                g.drawImage(wall.getImage(),wall.getX(),wall.getY(),this);
            }

        }

    }

    public void drawPlayers(Graphics g) {

        if (player1.isVisible()) {
            g.drawImage(player1.getImage(), player1.getX(), player1.getY(), this);
        }
        if (nplayers > 1 && player2.isVisible()) {
            g.drawImage(player2.getImage(), player2.getX(), player2.getY(), this);
        }
        if (player1.isDying()) {
            player1.die();
            ingame1 = false;
        }
        if (nplayers > 1 && player2.isDying()) {
            player2.die();
            ingame2 = false;
        }
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        String action = "BEGIN";
        try {
            beforeTime = System.currentTimeMillis();
            if (nplayers > 1) {
                output.println(action);
                System.out.println(input.readLine());
            }
            while (ingame1 || ingame2) {

                if (nplayers > 1) {

                    output.println(player1.getSocketmessage());
                    output.flush();
                    action = input.readLine();
                    if (action.equals("QUIT")) {
                        break;
                    }
                    if (action.equals("PAUSE")){
                        while(true){
                            output.println("PAUSE");
                            output.flush();
                            action = input.readLine();
                            if (action.equals("UNPAUSE")) {
                                break;
                            }
                        }
                    }
                    Player2command(action);

                }

                if(lowestAlien<270) {
                    animationCycle();
                    repaint();
                }else{
                    gameOver(this.getGraphics());
                    break;
                }
                timeDiff = System.currentTimeMillis() - beforeTime;
                sleep = DELAY - timeDiff;

                if (sleep < 0) {
                    sleep = 10;
                }
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
                beforeTime = System.currentTimeMillis();
            }
        } catch (IOException ex) {
            System.out.println("Player 2 closed connection");
        }
        if (nplayers > 1) {
            output.println("QUIT");
            output.flush();
        }
        gameOver(this.getGraphics());
    }

    public void gameOver(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGTH);

        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, BOARD_WIDTH / 2 - 30, BOARD_WIDTH - 100, 50);
        g.setColor(Color.white);
        g.drawRect(50, BOARD_WIDTH / 2 - 30, BOARD_WIDTH - 100, 50);

        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (BOARD_WIDTH - metr.stringWidth(message)) / 2,
                BOARD_WIDTH / 2);
    }
    private void Player2command(String action) {
        String[] mes = action.split(" ");
        if (mes[0].equals("MOVE")) {
            int direction = Integer.parseInt(mes[1]);
            int shoot = Integer.parseInt(mes[2]);
            player2.setDirection(direction);
            if (player2.getShoot() == 2){
                //context2 = new ShootingContext(new BasicShot());
                Shot sh = ShotFactory.getShot("Basic");
                //sh.setCoords(player2.getX(), player2.getY());
                context2 = new ShootingContext((BasicShot)sh);

                shoot = 0;
            }
            if (player2.getShoot() == 3){
                //context2 = new ShootingContext(new PowerShot());
                context2 = new ShootingContext((BasicShot)ShotFactory.getShot("Power"));
                shoot = 0;
            }
            player2.setShoot(shoot);
        }
    }

    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyCode());
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                player1.setRight(1);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                player1.setLeft(1);
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                output.println("QUIT");
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                player1.setShoot(1);
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                player1.setShoot(2);
                //context1 = new ShootingContext(new BasicShot());
                context1 = new ShootingContext((BasicShot)ShotFactory.getShot("Basic"));
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                player1.setShoot(3);
                //context1 = new ShootingContext(new PowerShot());
                context1 = new ShootingContext((PowerShot)ShotFactory.getShot("Basic"));
            }
        }
        public void keyReleased(KeyEvent e) {
            if (ingame1) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player1.setRight(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player1.setLeft(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    player1.setShoot(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    player1.setShoot(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    player1.setShoot(0);
                }
            }
        }

    }
    public boolean isWorked() {
        return worked;
    }

}
