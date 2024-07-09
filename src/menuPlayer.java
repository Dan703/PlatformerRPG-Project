import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class menuPlayer extends GameObject implements KeyListener {

    private int levelChosen = 0;
    private boolean nextButton = false;
    private boolean previousButton = false;
    private boolean startLevel = false;

    public menuPlayer(int x, int y) {
        this.x = x;
        this.y = y;
        width = 300;
        height = 75;
    }

    public void update() {
        if (startLevel){
            RPG_Game.getGame().setStartGame(startLevel);
            RPG_Game.getGame().removeGameObject(this);
        }
        if (nextButton){
            if (levelChosen < 2){
                levelChosen++;
                nextButton = false;
            }
        }
        else if (previousButton){
            if (levelChosen > 0){
                levelChosen--;
                previousButton = false;
            }
        }
        RPG_Game.getGame().setMenuAction(levelChosen);

    }

    public void setLevelChosen (int level){levelChosen = level;}

    public int getButtonPicked (){
        return levelChosen;
    }

    public void draw(Graphics g, JFrame gameWindow) {

    }

    public void keyTyped(KeyEvent e) {
        // This method will remain empty
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            nextButton = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            previousButton = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            startLevel = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            nextButton = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            previousButton = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            startLevel = false;
        }
    }
}