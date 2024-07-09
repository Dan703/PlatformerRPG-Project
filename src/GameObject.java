import javax.swing.*;
import java.awt.*;

public abstract class GameObject {

    // The x and y coordinate of the GameObject and the getters to access them
    protected int x;
    protected int y;
    Rectangle firstObjectRect = new Rectangle(x, y, 50, 110);

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    // The width and the height of the GameObject and the getters to access them
    protected int width;
    protected int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // This indicates that every class that extend GameObject will need to define an update() method
    public abstract void update();

    // This indicates that every class that extend GameObject will need to define an draw() method
    public abstract void draw(Graphics g, JFrame gameWindow);

    // Code that can be used to check if two GameObjects collide with each other
    public boolean collidesWith(GameObject secondObject) {

        if (this instanceof Char) {
            if (((Char) this).getDirec()){
                firstObjectRect = new Rectangle(x+70, y+45, 20, 60);
                if (((Char) this).isCrouching()){
                    firstObjectRect = new Rectangle(x+70, y+75, 20, 30);
                }
            }
            else {
                firstObjectRect = new Rectangle(x + 105, y + 45, 20, 60);
                if (((Char) this).isCrouching()){
                    firstObjectRect = new Rectangle(x+105, y+75, 20, 30);
                }
            }
        }
        else{
            firstObjectRect = new Rectangle(x, y, getWidth(), getHeight());
        }
        Rectangle secondObjectRect = new Rectangle(secondObject.x, secondObject.y, secondObject.getWidth(), secondObject.getHeight());

        if (secondObject instanceof Platform && this instanceof Char && ((Char) this).getWorld() == 2) {
            secondObjectRect = new Rectangle(secondObject.x+70, secondObject.y, secondObject.getWidth()-125, secondObject.getHeight());
        }
        return firstObjectRect.intersects(secondObjectRect);
    }

    public boolean collidesWithPlatform(GameObject secondObject) {


        firstObjectRect = new Rectangle(x+15, y+110, getWidth()/4, getHeight()/5);


        Rectangle secondObjectRect = new Rectangle(secondObject.x+20, secondObject.y+20, secondObject.getWidth()-45, secondObject.getHeight()-60);

        return firstObjectRect.intersects(secondObjectRect);
    }

    public Rectangle getRect(){
        return firstObjectRect;
    }
}
