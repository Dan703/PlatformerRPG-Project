import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TreeDeco extends GameObject{

    private BufferedImage SignImage;

    public TreeDeco(int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 200;
        height = 200;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/tree.png"));
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
