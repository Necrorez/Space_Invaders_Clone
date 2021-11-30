package SpaceX05.WallBuilder;

import SpaceX05.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WallBlockTriangle extends Sprite   {
    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for the WallBlockTriangle Object
     * @param color
     */
    @SuppressWarnings("SSDoc")
    public WallBlockTriangle(String color) {
        String toSet = switch (color) {
            case "White" -> "/Images/WallBlockTriangle.png";
            case "Blue" -> "/Images/WallBlockBlueTriangle.png";
            case "Purple" -> "/Images/WallBlockPurpleTriangle.png";
            default -> throw new RuntimeException("Invalid entry");
        };
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(toSet)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(10, 10,  Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for the WallBlockTriangle Object
     * @param color
     */
    @SuppressWarnings("SSDoc")
    public WallBlockTriangle(int x, int y,Image img){

        setImage(img);

        setX(x);
        setY(y);
    }
}
