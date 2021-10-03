package SpaceX05;

import SpaceX05.Aliens.Squid;
import SpaceX05.Factory.AliensFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class GameCanvas extends JPanel implements Runnable,Commons {
    private Dimension d;
    private Player player1, player2;
    private Alien alien1;
    private Alien alien2;
    private Alien alien3;
    private Alien alien4;
    private Alien alien5;
    private Alien alien6;
    private Alien alien7;
    private Alien alien8;
    private Alien alien9;

    private final int nplayers;
    private int deaths = 0;
    private int direction = -1;
    private boolean ingame1 = true, ingame2 = false; //player1 e player2
    private String message = "Game Over";

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

        // TODO: Set up enemy spawner
        AliensFactory factory = new AliensFactory();

        alien1 = factory.factoryMethod("Squid",100,100);
        alien2 = factory.factoryMethod("Squid",120,100);
        alien3 = factory.factoryMethod("Squid",140,100);
        alien4 = factory.factoryMethod("Crab",100,120);
        alien5 = factory.factoryMethod("Crab",120,120);
        alien6 = factory.factoryMethod("Crab",140,120);
        alien7 = factory.factoryMethod("Ufo",100,140);
        alien8 = factory.factoryMethod("Ufo",120,140);
        alien9 = factory.factoryMethod("Ufo",140,140);


        // Set up player input and socket
        player1 = new Player("/SpaceX05/Images/player.png",false);

        player2 = null;

        if (nplayers == 2){
            player2 = new Player("/SpaceX05/Images/player2.png",true);
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
        if (nplayers>1){
            player2.update();

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

        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public  void drawAliens(Graphics g){

        g.drawImage(alien1.getImage(), alien1.PosX, alien1.PosY, this);
        g.drawImage(alien2.getImage(), alien2.PosX, alien2.PosY, this);
        g.drawImage(alien2.getImage(), alien3.PosX, alien3.PosY, this);

        g.drawImage(alien4.getImage(), alien4.PosX, alien4.PosY, this);
        g.drawImage(alien5.getImage(), alien5.PosX, alien5.PosY, this);
        g.drawImage(alien6.getImage(), alien6.PosX, alien6.PosY, this);

        g.drawImage(alien7.getImage(), alien7.PosX, alien7.PosY, this);
        g.drawImage(alien8.getImage(), alien8.PosX, alien8.PosY, this);
        g.drawImage(alien9.getImage(), alien9.PosX, alien9.PosY, this);


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
            player2.setDirection(direction);
            System.out.println(player2.getX()+" "+player2.dx);
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
        }
        public void keyReleased(KeyEvent e) {
            if (ingame1) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player1.setRight(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player1.setLeft(0);
                }
            }
        }

    }
    public boolean isWorked() {
        return worked;
    }
    public boolean isIngame2() {
        return ingame2;
    }
}
