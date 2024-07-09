import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RockDeco extends GameObject{

    private BufferedImage SignImage;

    public RockDeco(int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 70;
        height = 70;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/rock.png"));
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
