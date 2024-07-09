import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WallSpikes extends GameObject{

    private BufferedImage SignImage;
    private boolean isLeft;
    public WallSpikes(int startingX, int startingY, boolean direction){
        x = startingX;
        y = startingY;
        width = 52;
        height = 156;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/LeftSpikes.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        isLeft = direction;
    }

    @Override
    public void update() {
        if (!isLeft){
            try {
                SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/RightSpikes.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(SignImage, x, y, width, height, gameWindow);
    }
}
