import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class FireballProjectile extends GameObject{

    private BufferedImage ProjectileImage;
    private double velocity = 50;
    private double angle = 45;
    private double xVelocity = velocity * Math.cos(angle);
    private double yVelocity = velocity * Math.sin(angle);
    private double t = 0;
    private double temp = 0;
    private boolean status = false;

    public FireballProjectile(int startingX, int startingY) {
        x = startingX;
        y = startingY;
        width = 35;
        height = 35;
        try {
            ProjectileImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/Fireball.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (t < .24){
            t += 0.01;
            x += (int)((xVelocity * t)/2.6);
            y -= (int)(16*Math.pow(t,2) + yVelocity * t);
        }
        else if(t < .48){
            t += 0.01;
            temp += 0.01;
            x += (int)((xVelocity * t)/2.6);
            y += (int)(16*Math.pow(temp,2) + yVelocity * temp);
        }
        else {
            t += 0.01;
            if (t > .8){
                RPG_Game.getGame().removeGameObject(this);
            }
        }
    }

    public boolean getStatus(){
        return status;
    }

    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(ProjectileImage, x, y, width, height, gameWindow);
    }

}
