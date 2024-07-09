import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MagicPowerUp extends GameObject{

    private BufferedImage SignImage;
    private boolean isUp = false;
    private int track = 0;
    private int inc = 1;

    public MagicPowerUp(int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 25;
        height = 25;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/Magic.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        if(!isUp){
            y+= inc;
            track++;
            if(track > 1){
                inc = 0;
            }
            if (track > 4){
                track = 0;
                isUp = true;
                inc = 1;
            }
        }
        else{
            y-= inc;
            track++;
            if(track > 1){
                inc = 0;
            }
            if (track > 4){
                track = 0;
                isUp = false;
                inc = 1;
            }
        }
    }

    @Override
    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(SignImage, x, y, width, height, gameWindow);
    }
}
