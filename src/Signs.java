import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Signs extends GameObject{

    private BufferedImage SignImage;
    private String text;
    private boolean isRight = false;

    public Signs (int startingX, int startingY, String text, boolean isRight){
        this.text = text;
        x = startingX;
        y = startingY;
        width = 70;
        height = 70;
        this.isRight = isRight;
        try {
            SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/sign.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return text;
    }

    @Override
    public void update() {
        if (isRight) {
            try {
                SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/sign.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                SignImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/signl.png"));
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
