import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BushDeco1 extends GameObject{

    private BufferedImage SignImage;

    public BushDeco1(int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 140;
        height = 70;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/bush1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(SignImage, x, y, width, height, gameWindow);
    }
}
