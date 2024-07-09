import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwordSlash extends GameObject{

    private BufferedImage SwordImage;
    private int animCount = 0;

    public SwordSlash(int startingX, int startingY) {
        x = startingX;
        y = startingY;
        width = 120;
        height = 60;
        try {
            SwordImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/attackHit.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        animCount++;
        if (animCount > 10){
            RPG_Game.getGame().removeGameObject(this);
        }
    }

    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(SwordImage, x, y, width, height, gameWindow);
    }

}
