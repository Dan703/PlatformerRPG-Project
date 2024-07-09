import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class RegSkeleton extends GameObject{

    private BufferedImage SkeletonImage;
    private int animCount = 0;
    private boolean dead = false;
    private boolean isReset = false;
    private int attackCounter = 0;

    public RegSkeleton (int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 80;
        height = 80;
        try {
            SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/SkeletonIdol1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        animCount++;
        attackCounter++;
        if (attackCounter == 90){
            DaggerProjectile dagger = new DaggerProjectile(x, y, true, 1200);
            RPG_Game.getGame().addGameObject(dagger);
            attackCounter = 0;
        }
        if(dead){
            if (!isReset) {
                animCount = 0;
                isReset = true;
            }
            if (animCount < 12){
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/DeathSkeleton1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (animCount < 18){
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/DeathSkeleton2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (animCount < 24){
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/DeathSkeleton3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (animCount < 30) {
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/DeathSkeleton4.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (animCount < 36) {
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/DeathSkeleton5.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (animCount < 42) {
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/DeathSkeleton6.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (animCount < 48) {
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/DeathSkeleton7.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (animCount < 54) {
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/DeathSkeleton8.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (animCount == 66){
                RPG_Game.getGame().removeGameObject(this);
                RPG_Game.getGame().setMovePlat(true);
            }
        }
        if (!dead) {
            if (animCount < 12) {
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/SkeletonIdol1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (animCount < 24) {
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/SkeletonIdol2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (animCount < 36) {
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/SkeletonIdol3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (animCount < 48) {
                try {
                    SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/SkeletonIdol4.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (animCount == 48) {
                animCount = 0;
            }
        }
    }

    public void setDead(boolean isDead){
        dead = isDead;
    }

    @Override
    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(SkeletonImage, x, y, width, height, gameWindow);
    }
}
