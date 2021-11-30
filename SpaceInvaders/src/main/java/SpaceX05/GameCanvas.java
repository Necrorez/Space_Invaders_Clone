package SpaceX05;


import SpaceX05.AbstractFactory.BalancedAliensFactory;
import SpaceX05.AbstractFactory.DefensiveAliensFactory;
import SpaceX05.AbstractFactory.OffensiveAliensFactory;
import SpaceX05.Aliens.*;
import SpaceX05.Decorator.CrabDamagePointsDecorator;
import SpaceX05.Command.AlienMover;
import SpaceX05.Command.DownCommand;
import SpaceX05.Command.LeftCommand;
import SpaceX05.Command.RightCommand;
import SpaceX05.Adapter.BasicWall;
import SpaceX05.Adapter.SquareWall;
import SpaceX05.Adapter.TriangleWall;
import SpaceX05.Adapter.WallAdapter;
import SpaceX05.Strategy.BasicShot;
import SpaceX05.Strategy.PowerShot;
import SpaceX05.Strategy.ShootingContext;
import SpaceX05.Template.Collision;
import SpaceX05.Template.WallCollision;
import SpaceX05.WallBuilder.Wall;
import SpaceX05.WallBuilder.WallBlockSquare;


import SpaceX05.PowerUps.PowerUp;

import SpaceX05.Factory.PowerUpFactory;
import SpaceX05.WallBuilder.WallBlockTriangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;


public class GameCanvas extends JPanel implements Runnable,Commons {
    private final Dimension d;
    private Player player1, player2;

    private final BalancedSquid squid = new BalancedSquid();
    private final OffensiveSquid squid2 = new OffensiveSquid();
    private final DefensiveSquid squid3 = new DefensiveSquid();
    private ArrayList<Alien> aliens;

    private AlienMover alienMoves;
    private boolean sideMove = true;
    private boolean dir;
    private int alienDownMove = 10;
    private int rightMostAlien = 0;
    private int leftMostAlien = 400;
    private int lowestAlien=0;

    private Alien alien0;
    private Alien shallowCopy;
    private final int nPlayers;
    private boolean inGame1 = true, inGame2 = false; //player1 e player2

    private Shot shot1;
    private Shot shot2;
    private ShootingContext context1;
    private ShootingContext context2;

    private  ArrayList<BasicWall> walls;

    private final boolean worked;

    private Thread animator;
    private BufferedReader input;
    private PrintWriter output;
    /**
     * TODO | DOING | DONE
     * DONE
     * initialize frame for the game
     * @param n
     */
    @SuppressWarnings("SSDoc")
    public GameCanvas(int n) {
        nPlayers = n;
        setFocusable(true);
        addKeyListener(new TAdapter());

        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
        setBackground(Color.black);
        worked = gameStart();
        setDoubleBuffered(true);
    }

    /**
     * TODO | DOING | DONE
     * DOING: add more patterns if need be
     * Method for initializing objects for the game
     * @param
     * @return true if both players connected successfully
     */
    @SuppressWarnings("SSDoc")
    public boolean gameStart(){
        // SET UP: this a context strategy setup for shooting

        shot1 = new BasicShot();
        shot2 = new BasicShot();
        context1 = new ShootingContext(new BasicShot());
        context2 = new ShootingContext(new BasicShot());




        walls = new ArrayList<>();
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


        // TODO: Set up enemy spawner
        BalancedAliensFactory balanced = new BalancedAliensFactory();
        DefensiveAliensFactory defensive = new DefensiveAliensFactory();
        OffensiveAliensFactory offensive = new OffensiveAliensFactory();
        aliens = new ArrayList<>();
        int i;
        int id = 0;
        for (i = 0; i<3; i++){
                Alien alien = balanced.spawnSquid("Squid", id,100 + 20 * i,100);
                id++;
                Alien alien1 = balanced.spawnCrab("Crab", id, 100 + 20 * i,120);
                id++;
                Alien alien2 = balanced.spawnUfo("Ufo", id,100 + 20 * i,140);
                id++;
                Alien alien3 = defensive.spawnSquid("Squid", id,40 + 20 * i,100);
                id++;
                Alien alien4 = defensive.spawnCrab("Crab", id, 40 + 20 * i,120);
                id++;
                Alien alien5 = defensive.spawnUfo("Ufo", id,40 + 20 * i,140);
                id++;
                Alien alien6 = offensive.spawnSquid("Squid", id,160 + 20 * i,100);
                id++;
                Alien alien7 = offensive.spawnCrab("Crab", id, 160 + 20 * i,120);
                id++;
                Alien alien8 = offensive.spawnUfo("Ufo", id,160 + 20 * i,140);
                id++;

                aliens.add(alien);
                aliens.add(alien1);
                aliens.add(alien2);
                aliens.add(alien3);
                aliens.add(alien4);
                aliens.add(alien5);
                aliens.add(alien6);
                aliens.add(alien7);
                aliens.add(alien8);

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

        alien0 = balanced.spawnSquid("Crab", id,200,200);
        shallowCopy = alien0.copyShallow();
        shallowCopy.PosX=220;
        shallowCopy.PosY=220;

        //Comand

        alienMoves = new AlienMover();
        sideMove = true;
        dir = true;

        //powerup
        PowerUpFactory factory = new PowerUpFactory();



        // Set up player input and socket
        player1 = new Player("/Images/player.png",false,new Location());

        player2 = null;

        if (nPlayers == 2){
            player2 = player1.copyDeep();
            player2.changeImg("/Images/player2.png");
            player2.controlled = true;
//            player2.setLoc(150,280);
            inGame2 = true;
            try {
                Socket socket = new Socket("localhost", 4000);
                InputStreamReader reader = new InputStreamReader(socket.getInputStream());
                input = new BufferedReader(reader);
                output = new PrintWriter(socket.getOutputStream(),true);
                input.readLine();
            }catch (IOException ioException){
                return false;
            }
        }
        //TODO: Set up shooting system

        //Set up for animation
        if (animator == null || (!inGame1 && !inGame2)){
            animator = new Thread(this);
            animator.start();
        }
        return true;
    }

    /**
     * TODO | DOING | DONE
     * Method responsible for game animation updates
     * @param
     */
    @SuppressWarnings("SSDoc")
    public void animationCycle() {

        // player
        player1.update();
        player2.update();

        //Creating shots
        if (!shot1.isVisible() && player1.getShoot() == 1) {
            if (context1.whichType() == 1){
                shot1 = new BasicShot(player1.getX(), player1.getY());
                context1 = new ShootingContext((BasicShot)shot1);

            }
            if (context1.whichType() == 2){
                shot1 = new PowerShot(player1.getX(), player1.getY());
                context1 = new ShootingContext((PowerShot)shot1);

            }

        }
        if (nPlayers >1){
            if (!shot2.isVisible() && player2.getShoot() == 1) {
                if (context2.whichType() == 1){
                    shot2 = new BasicShot(player2.getX(), player2.getY());
                    context2 = new ShootingContext((BasicShot)shot2);
                }
                if (context2.whichType() == 2){
                    shot2 = new PowerShot(player2.getX(), player2.getY());
                    context2 = new ShootingContext((PowerShot)shot2);
                }
            }
        }
        context1.executeShoot(aliens);
        context2.executeShoot(aliens);
        shot1 = context1.rShot();
        shot2 = context2.rShot();
        for (Alien alien:aliens) {
            for (BasicWall wall:walls){
                Collision collision = new WallCollision();
                collision.checkHit(alien,wall);
            }
            if (sideMove){
                if (dir){
                    alienMoves.run(new RightCommand(alien));
                    if(alien.PosX>rightMostAlien){
                        rightMostAlien = alien.PosX;
                    }

                }
                else {
                    alienMoves.run(new LeftCommand(alien));
                    if(alien.PosX<leftMostAlien){
                        leftMostAlien = alien.PosX;
                    }
                }
            }
            else {
                alienMoves.run(new DownCommand(alien));
                alienDownMove--;
            }
            if(alien.PosY > lowestAlien){
                lowestAlien = alien.PosY;
            }
        }
        if (sideMove){
            if (dir){
                if (rightMostAlien >= 320){
                    dir = false;
                    sideMove = false;
                    alienDownMove = 10 * aliens.size();
                }
            }
            else {
                if (leftMostAlien <= 0){
                    dir = true;
                    sideMove = false;
                    alienDownMove = 10*aliens.size();
                }
            }
        }
        else {
            if (alienDownMove <= 0){
                sideMove = true;
                leftMostAlien =400;
                rightMostAlien = 0;
            }
        }
        if(lowestAlien>=270)
            gameOver(this.getGraphics());
    }


    /**
     * TODO | DOING | DONE
     * DOING: add more models to draw if need be
     * Method responsible for Calling other drawing methods
     * @param g
     * @return
     */
    @SuppressWarnings("SSDoc")
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);

        if (inGame1 || inGame2) {

            g.drawLine(0, GROUND, BOARD_WIDTH, GROUND);
            drawAliens(g);
            drawPlayers(g);
            drawShot(g);
            drawWall(g);

        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Method responsible for drawing shot model
     * @param g
     */
    @SuppressWarnings("SSDoc")
    public void drawShot(Graphics g) {
        if (shot1.isVisible()) {
            g.drawImage(shot1.getImage(), shot1.getX(), shot1.getY(), this);
        }
        if (shot2.isVisible()) {
            g.drawImage(shot2.getImage(), shot2.getX(), shot2.getY(), this);
        }
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Method responsible for drawing alien model
     * @param g
     */
    @SuppressWarnings("SSDoc")
    public void drawAliens(Graphics g) {

        Iterator<Alien> it = aliens.iterator();

        g.drawImage(shallowCopy.getImage(), shallowCopy.PosX, shallowCopy.PosY, this);
        g.drawImage(alien0.getImage(), alien0.PosX, alien0.PosY, this);
        while (it.hasNext()){
            Alien alien = it.next();
            if (alien.isVisible()){
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


    /**
     * TODO | DOING | DONE
     * DONE
     * Method responsible for drawing wall model
     * @param g
     */
    @SuppressWarnings("SSDoc")
    public void drawWall(Graphics g) {
        for (BasicWall wall : walls) {
            if (wall.isVisible()) {
                g.drawImage(wall.getImage(), wall.getX(), wall.getY(), this);
            }
        }

    }



    /**
     * TODO | DOING | DONE
     * DONE
     * Method responsible for drawing the player model
     * @param g
     */
    @SuppressWarnings("SSDoc")
    public void drawPlayers(Graphics g) {

        if (player1.isVisible()) {
            g.drawImage(player1.getImage(), player1.getX(), player1.getY(), this);
        }
        if (nPlayers > 1 && player2.isVisible()) {
            g.drawImage(player2.getImage(), player2.getX(), player2.getY(), this);
        }
        if (player1.isDying()) {
            player1.die();
            inGame1 = false;
        }
        if (nPlayers > 1 && player2.isDying()) {
            player2.die();
            inGame2 = false;
        }
    }


    @Override
    public
    void run() {
        long beforeTime, timeDiff, sleep;
        String action = "BEGIN";
        try {
            beforeTime = System.currentTimeMillis();
            if (nPlayers > 1) {
                output.println(action);
                System.out.println(input.readLine());
            }
            while (inGame1 || inGame2) {

                if (nPlayers > 1) {

                    output.println(player1.getSocketMessage());
                    output.flush();
                    action = input.readLine();
                    if (action.equals("QUIT")) {
                        break;
                    }
                    if (action.equals("PAUSE")){
                        do {
                            output.println("PAUSE");
                            output.flush();
                            action = input.readLine();
                        } while (!action.equals("UNPAUSE"));
                    }
                    Player2command(action);

                }

                animationCycle();
                repaint();

                timeDiff = System.currentTimeMillis() - beforeTime;
                sleep = DELAY - timeDiff;

                if (sleep < 0) {
                    sleep = 2;
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
        if (nPlayers > 1) {
            output.println("QUIT");
            output.flush();
        }
        gameOver(this.getGraphics());
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Method to draw the game over screen
     * @param g
     */
    @SuppressWarnings("SSDoc")
    public void gameOver(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);

        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, BOARD_WIDTH / 2 - 30, BOARD_WIDTH - 100, 50);
        g.setColor(Color.white);
        g.drawRect(50, BOARD_WIDTH / 2 - 30, BOARD_WIDTH - 100, 50);

        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        String message = "Game Over";
        g.drawString(message, (BOARD_WIDTH - metr.stringWidth(message)) / 2,
                BOARD_WIDTH / 2);
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Method for sending commands to second player
     * @param action
     */
    @SuppressWarnings("SSDoc")
    private void Player2command(String action) {
        String[] mes = action.split(" ");
        if (mes[0].equals("MOVE")) {
            int direction = Integer.parseInt(mes[1]);
            int shoot = Integer.parseInt(mes[2]);
            player2.setDirection(direction);
            if (player2.getShoot() == 2){
                context2 = new ShootingContext(new BasicShot());
                shoot = 0;
            }
            if (player2.getShoot() == 3){
                context2 = new ShootingContext(new PowerShot());
                shoot = 0;
            }
            player2.setShoot(shoot);
        }
    }

    private class TAdapter extends KeyAdapter {
        /**
         * TODO | DOING | DONE
         * DONE
         * Method for check keyboard key presses and sending them to the player object
         * @param e
         */
        @SuppressWarnings("SSDoc")
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
                    context1 = new ShootingContext(new BasicShot());
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    player1.setShoot(3);
                    context1 = new ShootingContext(new PowerShot());
                }
            }

        /**
         * TODO | DOING | DONE
         * DONE
         * Method for check keyboard key release and sending them to the player object
         * @param e
         */
        @SuppressWarnings("SSDoc")
        public void keyReleased(KeyEvent e) {
                if (inGame1) {
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

    /**
     * TODO | DOING | DONE
     * DONE method to send back to the main menu if the game has started
     * @return worked
     */
    @SuppressWarnings("SSDoc")
    public boolean isWorked() {
        return worked;
    }

}
