package SpaceX05.WallBuilder;

import SpaceX05.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WallBlockSquare extends Sprite {

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for the WallBlockSquare Object
     * @param color
     */
    @SuppressWarnings("SSDoc")
    public WallBlockSquare(String color){
        String toSet = switch (color) {
            case "White" -> "/Images/WallBlock.png";
            case "Blue" -> "/Images/WallBlockBlue.png";
            case "Purple" -> "/Images/WallBlockPurple.png";
            default -> throw new RuntimeException("Invalid entry");
        };

        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(toSet)));
        Image image = ii.getImage();

        Image newImage = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for the WallBlockSquare Object
     * @param color
     */
    @SuppressWarnings("SSDoc")
    public WallBlockSquare(int x, int y, Image img){

        setImage(img);

        setX(x);
        setY(y);
    }
}
