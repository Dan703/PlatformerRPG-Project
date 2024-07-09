import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BushDeco2 extends GameObject{

    private BufferedImage SignImage;

    public BushDeco2(int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 75;
        height = 75;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/bush2.png"));
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
