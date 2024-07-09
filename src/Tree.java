import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tree extends GameObject{

    private BufferedImage SignImage;

    public Tree(int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 440;
        height = 440;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/free_bundle_2_trees_7.png"));
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
