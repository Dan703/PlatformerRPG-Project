import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class FastWarriorSkeleton extends GameObject{

    private BufferedImage SkeletonImage;
    private int animCount = 0;
    private boolean isRight = true;
    private int moveCounter = 0;
    private int attackCounter = 0;
    private boolean dead = false;
    private boolean reset = false;

    public FastWarriorSkeleton(int startingX, int startingY){
        x = startingX;
        y = startingY;
        width = 90;
        height = 90;
        try {
            SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        if (!dead) {
            if (isRight) {
                x += 2;
                moveCounter++;
                attackCounter++;
                if (attackCounter % 100 == 0) {
                    DaggerProjectile dagger = new DaggerProjectile(x, y, !isRight, 300);
                    RPG_Game.getGame().addGameObject(dagger);
                }
                if (moveCounter > 50) {
                    isRight = false;
                    moveCounter = 0;
                }
                animCount++;
                if (animCount < 4) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 8) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 12) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun3.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 16) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun4.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 20) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun5.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 24) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun6.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount == 24) {
                    animCount = 0;
                }
            } else {
                x -= 2;
                moveCounter++;
                attackCounter++;
                if (attackCounter % 100 == 0) {
                    DaggerProjectile dagger = new DaggerProjectile(x, y, !isRight, 300);
                    RPG_Game.getGame().addGameObject(dagger);
                }
                if (moveCounter > 50) {
                    isRight = true;
                    moveCounter = 0;
                }
                animCount++;
                if (animCount < 4) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun1 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 8) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun2 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 12) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun3 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 16) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun4 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 20) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun5 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 24) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Animations/WarriorSkeletonRun6 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount == 24) {
                    animCount = 0;
                }
            }
        }
        else{
            if (!reset){
                animCount = 0;
                reset = true;
            }
            animCount++;
            if (isRight) {
                if (animCount < 16) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 24) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 32) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath3.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 40) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath4.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 48) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath5.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 56) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath6.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount == 64) {
                    RPG_Game.getGame().removeGameObject(this);
                }
            }
            else {
                if (!reset){
                    animCount = 0;
                    reset = true;
                }
                animCount++;
                if (animCount < 16) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath1 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (animCount < 24) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath2 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (animCount < 32) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath3 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (animCount < 40) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath4 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (animCount < 48) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath5 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (animCount < 56) {
                    try {
                        SkeletonImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("DeathAnims/WSdeath6 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (animCount == 64) {
                    RPG_Game.getGame().removeGameObject(this);
                }
            }
        }
    }

    public void setDead (boolean dead){
        this.dead = dead;
    }

    @Override
    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(SkeletonImage, x, y, width, height, gameWindow);
    }
}
