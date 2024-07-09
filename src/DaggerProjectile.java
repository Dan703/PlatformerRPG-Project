import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DaggerProjectile extends GameObject{

    private BufferedImage ProjectileImage;
    private boolean isLeft;
    private int ticks = 0;
    private int move;

    public DaggerProjectile(int startingX, int startingY, boolean isLeft, int ticks) {
        x = startingX;
        y = startingY;
        width = 45;
        height = 15;
        this.isLeft = isLeft;
        move = ticks;
        if (isLeft) {
            try {
                ProjectileImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/dagger.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                ProjectileImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/daggerRight.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if(isLeft){
            x-=8;
            ticks += 8;
            if(ticks > move){
                RPG_Game.getGame().removeGameObject(this);
            }
        }
        else{
            x+=8;
            ticks += 8;
            if(ticks > move){
                RPG_Game.getGame().removeGameObject(this);
            }
        }

        if (RPG_Game.getGame().getDD()){
            RPG_Game.getGame().removeGameObject(this);
        }
    }


    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(ProjectileImage, x, y, width, height, gameWindow);
    }

}
