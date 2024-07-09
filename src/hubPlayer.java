import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class hubPlayer extends GameObject implements KeyListener {

    private BufferedImage location;
    private int anim = 0;
    private int animMult = 1;
    private int levelChosen = 1;
    private boolean nextLevel = false;
    private boolean previousLevel = false;
    private boolean startLevel = false;

    public hubPlayer(int x, int y) {
        this.x = x;
        this.y = y;
        width = 50;
        height = 50;
        try {
            location = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("props/pos1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (startLevel){
            RPG_Game.getGame().setStartLevel(startLevel);
            RPG_Game.getGame().removeGameObject(this);
        }
        if (nextLevel){
            if (levelChosen < 2){
                levelChosen++;
            }
        }
        else if (previousLevel){
            if (levelChosen > 1){
                levelChosen--;
            }
        }
        RPG_Game.getGame().setLevelChosen(levelChosen);
        if (levelChosen == 1){
            x = 212;
            y = 485;
        }
        else if (levelChosen == 2){
            x = 435;
            y = 443;
        }
        if (anim < animMult){
            try {
                location = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("props/pos1.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (anim < 2*animMult){
            try {
                location = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("props/pos2.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (anim < 3*animMult){
            try {
                location = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("props/pos4.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (anim < 4*animMult-1){
            try {
                location = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("props/pos3.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                location = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("props/pos3.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            anim = 0;
        }
        anim++;
    }

    public void setLevelChosen (int level){levelChosen = level;}

    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(location, x, y, width, height, gameWindow);
    }

    public void keyTyped(KeyEvent e) {
        // This method will remain empty
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            nextLevel = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            previousLevel = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            startLevel = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            nextLevel = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            previousLevel = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            startLevel = false;
        }
    }
}