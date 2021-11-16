package SpaceX05;


import SpaceX05.AbstractFactory.BalancedAliensFactory;
import SpaceX05.AbstractFactory.DefensiveAliensFactory;
import SpaceX05.AbstractFactory.OffensiveAliensFactory;
import SpaceX05.Aliens.*;
import SpaceX05.Decorator.CrabDamagePointsDecorator;
import SpaceX05.Strategy.BasicShot;
import SpaceX05.Strategy.PowerShot;
import SpaceX05.Strategy.ShootingContext;
import SpaceX05.WallBuilder.Wall;
import SpaceX05.WallBuilder.WallBlock;


import SpaceX05.PowerUps.PowerUp;

import SpaceX05.Factory.PowerUpFactory;
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
    private Dimension d;
    private Player player1, player2;

    private PowerUp powerUp1;
    private BalancedSquid squid = new BalancedSquid();
    private OffensiveSquid squid2 = new OffensiveSquid();
    private DefensiveSquid squid3 = new DefensiveSquid();
    private PowerUp pw;
    private ArrayList aliens;
    private Alien alien0;
    private Alien shallowcopy;
    private final int nplayers;
    private int deaths = 0;
    private int direction = -1;
    private boolean ingame1 = true, ingame2 = false; //player1 e player2
    private String message = "Game Over";

    private Shot shot1;
    private Shot shot2;
    private ShootingContext context1;
    private ShootingContext context2;

    private ArrayList walls;


    private String HOST = "1ocalhost";
    private int PORT = 4000;
    private boolean worked;

    private Thread animator;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    public GameCanvas(int n) {
        nplayers = n;
        setFocusable(true);
        addKeyListener(new TAdapter());

        d = new Dimension(BOARD_WIDTH, BOARD_HEIGTH);
        setBackground(Color.black);
        worked = true;
        if (!gameStart()) {
            worked = false;
        }
        setDoubleBuffered(true);
    }

    public boolean gameStart(){
        // SET UP: this a context strategy setup for shooting

        shot1 = new BasicShot();
        shot2 = new BasicShot();
        context1 = new ShootingContext(new BasicShot());
        context2 = new ShootingContext(new BasicShot());



        // SET UP: wall setup
        walls = new ArrayList();
        Wall wall = new Wall.WallBuilder()
                .color("Blue")
                .placement(new int[][]{
                        {0,0,1,0},
                        {0,1,1,0},
                        {1,1,1,1}})
                .y(50)
                .x(230)
                .build();
        walls.addAll(wall.getWall());
        wall = new Wall.WallBuilder()
                .color("Purple")
                .placement(new int[][]{
                        {1,0,1,1},
                        {1,0,1,1},
                        {1,1,1,1}})
                .y(250)
                .x(230)
                .build();
        walls.addAll(wall.getWall());


        // TODO: Set up enemy spawner
        BalancedAliensFactory balanced = new BalancedAliensFactory();
        DefensiveAliensFactory defensive = new DefensiveAliensFactory();
        OffensiveAliensFactory offensive = new OffensiveAliensFactory();
        aliens = new ArrayList();
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
        id++;
        shallowcopy = alien0.copyShallow();
        shallowcopy.PosX=220;
        shallowcopy.PosY=220;

        //powerup
        PowerUpFactory factory = new PowerUpFactory();

       // powerUp1 = factory.factoryMethod("ExtraLife",160,160) ;
        // powerUp1 = factory.factoryMethod("MovementSpeed",160,160) ;
         powerUp1 = factory.factoryMethod("AttackSpeed",160,160) ;

         pw = factory.factoryMethod("ExtraLife", 50, 50);

        // Set up player input and socket
        player1 = new Player("/Images/player.png",false,new Location());

        player2 = null;

        if (nplayers == 2){
           // player2 = player1.copyShallow();
            player2 = player1.copyDeep();
            player2.changeImg("/Images/player2.png");
            player2.controlled = true;
            player2.setLoc(150,280);
            ingame2 = true;
            try {
                socket = new Socket("localhost",4000);
                InputStreamReader reader = new InputStreamReader(socket.getInputStream());
                input = new BufferedReader(reader);
                output = new PrintWriter(socket.getOutputStream(),true);
                input.readLine();
            }catch (IOException ioException){
                return false;

                //ioException.printStackTrace();
            }
        }
        //TODO: Set up shooting system

        //Set up for animation
        if (animator == null || (!ingame1 && !ingame2)){
            animator = new Thread(this);
            animator.start();
        }
        return true;
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
                shot1 = new BasicShot(player1.getX(), player1.getY());
                context1 = new ShootingContext((BasicShot)shot1);

            }
            if (context1.whichType() == 2){
                shot1 = new PowerShot(player1.getX(), player1.getY());
                context1 = new ShootingContext((PowerShot)shot1);

            }

        }
        if (nplayers>1){
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

        Iterator it = aliens.iterator();

        g.drawImage(shallowcopy.getImage(), shallowcopy.PosX, shallowcopy.PosY, this);
        g.drawImage(alien0.getImage(), alien0.PosX, alien0.PosY, this);
        while (it.hasNext()){
            Alien alien = (Alien) it.next();
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


                g.drawImage(powerUp1.getImage(),alien.PosX, alien.PosY,this);

            }
        }

    }

    public void drawWall(Graphics g){
        Iterator it = walls.iterator();
        while (it.hasNext()){
            WallBlock wall = (WallBlock) it.next();
            g.drawImage(wall.getImage(),wall.getX(),wall.getY(),this);
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
        if (nplayers > 1) {
            output.println("QUIT");
            output.flush();
        }
        gameOver();
    }

    public void gameOver() {

        Graphics g = this.getGraphics();

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
