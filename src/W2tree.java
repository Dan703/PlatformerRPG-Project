import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class W2tree extends GameObject{

    private BufferedImage SignImage;

    public W2tree(int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 390;
        height = 480;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("world2/w2_largetree.png"));
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
