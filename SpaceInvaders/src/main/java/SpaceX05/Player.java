package SpaceX05;


import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class Player extends Sprite implements Commons,Cloneable,IPrototype{
    public Location location;
    private String player;
    private int width;
    private String socketMessage = "";
    private int left;
    private int right;
    private int shoot;
    public  boolean controlled;

    /**
     * TODO | DOING | DONE
     * Constructor for the player model
     * @param p, controlled,loc
     */
    @SuppressWarnings("SSDoc")
    public Player(String p, boolean controlled, Location loc) {
        player = p;
        location= loc;
        this.controlled = controlled;
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(player)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(PLAYER_HEIGHT, PLAYER_WIDTH, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        width = ii.getImage().getWidth(null);

        setImage(ii.getImage());
        setX(location.START_X);
        setY(location.START_Y);
    }


    /**
     * TODO | DOING | DONE
     * DONE
     * Method to change the player image
     * @param p
     */
    @SuppressWarnings("SSDoc")
    public void changeImg(String p) {
        player = p;
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(player)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(PLAYER_HEIGHT, PLAYER_WIDTH, Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        width = ii.getImage().getWidth(null);

        setImage(ii.getImage());
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Updates the player location and also creates a socketMessage to send out to the other player
     */
    @SuppressWarnings("SSDoc")
    public void update() {
        if (!controlled) {
            if (left > 0) {
                dx = -2;
            } else if (right > 0) {
                dx = 2;
            } else {
                dx = 0;
            }
            socketMessage = "MOVE " + dx + " " + shoot;
        }
        x += dx;
        if (x <= 2) {
            x = 2;
        }
        if (x >= BOARD_WIDTH - 2 * width) {
            x = BOARD_WIDTH - 2 * width;
        }

    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Shallow copy for the player model
     * @return player
     */
    @SuppressWarnings("SSDoc")
    public Player copyShallow()
    {
        try {
            return (Player)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Sets the current player location
     * @param location
     */
    @SuppressWarnings("SSDoc")
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Deep copy for the player model
     * @return player
     */
    @SuppressWarnings("SSDoc")
    public Player copyDeep()
    {
        try {
            Player copy = (Player)this.clone();
            copy.setLocation(this.location.copyShallow());
            return copy;
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }


    /**
     * TODO | DOING | DONE
     * DONE
     * Return the socket message created by this model
     * @return
     */
    @SuppressWarnings("SSDoc")
    public String getSocketMessage() {
        return socketMessage;
    }


    /**
     * TODO | DOING | DONE
     * DONE
     * Setter for left
     * @param left
     */
    @SuppressWarnings("SSDoc")
    public void setLeft(int left) {
        this.left = left;
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Setter for right
     * @param right
     */
    @SuppressWarnings("SSDoc")
    public void setRight(int right) {
        this.right = right;
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Setter for direction
     * @param right
     */
    @SuppressWarnings("SSDoc")
    public void setDirection(int direction) {
        this.dx = direction;
    }


    /**
     * TODO | DOING | DONE
     * DONE
     * Getter for shoot
     * @return the shoot values
     */
    @SuppressWarnings("SSDoc")
    public int getShoot() {
        return shoot;
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Setter for shoot
     * @param shoot
     */
    @SuppressWarnings("SSDoc")
    public void setShoot(int shoot) {
        this.shoot = shoot;
    }

}
