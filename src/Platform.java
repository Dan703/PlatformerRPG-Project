import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Platform extends GameObject{

    private BufferedImage SignImage;
    private boolean moveUp = false;
    private int count = 0;
    private boolean moveRight = false;

    public Platform(int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 225;
        height = 75;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/platform.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        if(RPG_Game.getGame().getPlayer().getWorld() == 2) {
            try {
                SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("world2/platformW2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            width = 300;
            height = 100;
        }
        if (moveUp){
            if(moveRight){
                if (count <= 60) {
                    x -= 3;
                    count++;
                }
            }
            else {
                if (count <= 40) {
                    y -= 3;
                    count++;
                }

            }
        }
    }

    public void moveUp (){
        moveUp = true;
    }

    public void moveRight (){
        moveRight = true;
    }

    @Override
    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(SignImage, x, y, width, height, gameWindow);
    }
}
