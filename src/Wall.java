import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Wall extends GameObject{

    private BufferedImage SignImage;

    public Wall(int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 75;
        height = 225;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/wall.png"));
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
