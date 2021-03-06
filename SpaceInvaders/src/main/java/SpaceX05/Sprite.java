package SpaceX05;

import java.awt.*;

public class Sprite {
    private boolean visible;
    private Image image;
    private String src;
    protected int x;
    protected int y;
    protected boolean dying;
     int dx;
    public Sprite() {
        visible = true;
    }
    public boolean isVisible() { return visible;}
    public void die() {
        visible = false;
    }
    protected void setVisible(boolean visible) {
        this.visible = visible;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public Image getImage() {
        return image;
    }
    public String getImageSrc() {return src;}
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public void setDying(boolean dying) {
        this.dying = dying;
    }
    public boolean isDying() {
        return this.dying;
    }

}
