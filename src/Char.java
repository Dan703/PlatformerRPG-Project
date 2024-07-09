import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Char extends GameObject implements KeyListener {

    private boolean rightKeyPressed = false;
    private boolean leftKeyPressed = false;
    private boolean jump = false;
    private boolean attack = false;
    private boolean meleeAttack = false;
    private double velX = 0;
    public int floorHeight = 485;
    private float jumpStrength, weight, speed;
    private BufferedImage playerImage;
    private boolean isRight = true;
    private int level = 1;
    private boolean didAttack = false;
    private int animCount = 0;
    private int cooldown = 0;
    private int meleeCooldown = 0;
    private boolean jumpReset = false;
    private int attackCount = 0;
    private int crouchCount = 0;
    private boolean attacking = false;
    private boolean isIdle = true;
    private boolean isRunning = false;
    private int checkPlat = 0;
    private boolean crouch = false;
    private boolean jumping = false;
    private boolean wallSliding = false;
    private int slideCount = 0;
    private boolean resetPos = false;
    private boolean dash = false;
    private boolean dashing = false;
    private boolean timer = false;
    private int time = 0;
    private float temp = 0;
    private int dashTimer = 0;
    private boolean wallJumped = false;
    private boolean hasSmashed = false;
    private int world = 1;

    public Char(int startingX, int startingY) {
        x = startingX;
        y = startingY;
        width = 192;
        height = 132;
        speed = 2;
        weight = 2;
        try {
            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getJump (){
        return jump;
    }

    public boolean getAttack (){
        return attack;
    }

    public int getLevel (){
        return level;
    }

    public void respawn () {
        x = 50;
        y = 485;
    }

    public boolean getDirection(){
        return isRight;
    }

    public boolean isJumping(){
        return jumping;
    }

    public boolean isCrouching(){
        return crouch;
    }

    public void stopJump(){
        if (!hasSmashed) {
            jumpStrength = 0;
            hasSmashed = true;
        }
    }

    public int getWorld(){
        return world;
    }

    public void setWorld(int world){
        this.world = world;
    }

    public void update() {
        dashTimer++;

        if(isRight) {
            if(world == 1) {
                if (x + 10 >= RPG_Game.getGame().getPlatformslvl1().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatformslvl1().getX() + 150 && y >= RPG_Game.getGame().getPlatformslvl1().getY() - 110 && y <= RPG_Game.getGame().getPlatformslvl1().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatformslvl1().getY() - 110;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms2().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms2().getX() + 150 && y >= RPG_Game.getGame().getPlatforms2().getY() - 110 && y <= RPG_Game.getGame().getPlatforms2().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms2().getY() - 110;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms3().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms3().getX() + 150 && y >= RPG_Game.getGame().getPlatforms3().getY() - 110 && y <= RPG_Game.getGame().getPlatforms3().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms3().getY() - 110;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms4().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms4().getX() + 150 && y >= RPG_Game.getGame().getPlatforms4().getY() - 110 && y <= RPG_Game.getGame().getPlatforms4().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms4().getY() - 110;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms5().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms5().getX() + 150 && y >= RPG_Game.getGame().getPlatforms5().getY() - 110 && y <= RPG_Game.getGame().getPlatforms5().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms5().getY() - 110;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms6().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms6().getX() + 150 && y >= RPG_Game.getGame().getPlatforms6().getY() - 110 && y <= RPG_Game.getGame().getPlatforms6().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms6().getY() - 110;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms7().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms7().getX() + 150 && y >= RPG_Game.getGame().getPlatforms7().getY() - 110 && y <= RPG_Game.getGame().getPlatforms7().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms7().getY() - 110;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms8().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms8().getX() + 150 && y >= RPG_Game.getGame().getPlatforms8().getY() - 110 && y <= RPG_Game.getGame().getPlatforms8().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms8().getY() - 110;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms9().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms9().getX() + 150 && y >= RPG_Game.getGame().getPlatforms9().getY() - 110 && y <= RPG_Game.getGame().getPlatforms9().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms9().getY() - 110;
                } else if (x + 10 >= RPG_Game.getGame().getLp1().getX() - 60 && x + 10 <= RPG_Game.getGame().getLp1().getX() + 840 && y >= RPG_Game.getGame().getLp1().getY() - 110 && y <= RPG_Game.getGame().getLp1().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getLp1().getY() - 110;
                } else if (x + 10 >= RPG_Game.getGame().getLp2().getX() - 60 && x + 10 <= RPG_Game.getGame().getLp2().getX() + 840 && y >= RPG_Game.getGame().getLp2().getY() - 110 && y <= RPG_Game.getGame().getLp2().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getLp2().getY() - 110;
                } else {
                    if (RPG_Game.getGame().getHL() == 1) {
                        floorHeight = 485;
                    } else {
                        floorHeight = 535;
                    }
                }
            }
            else if (world == 2){
                if (x + 10 >= RPG_Game.getGame().getPlatformslvl1().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatformslvl1().getX() + 225 && y >= RPG_Game.getGame().getPlatformslvl1().getY() - 110 && y <= RPG_Game.getGame().getPlatformslvl1().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatformslvl1().getY() - 95;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms2().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms2().getX() + 225 && y >= RPG_Game.getGame().getPlatforms2().getY() - 110 && y <= RPG_Game.getGame().getPlatforms2().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms2().getY() - 95;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms3().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms3().getX() + 225 && y >= RPG_Game.getGame().getPlatforms3().getY() - 110 && y <= RPG_Game.getGame().getPlatforms3().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms3().getY() - 95;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms4().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms4().getX() + 225 && y >= RPG_Game.getGame().getPlatforms4().getY() - 110 && y <= RPG_Game.getGame().getPlatforms4().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms4().getY() - 95;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms5().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms5().getX() + 225 && y >= RPG_Game.getGame().getPlatforms5().getY() - 110 && y <= RPG_Game.getGame().getPlatforms5().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms5().getY() - 95;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms6().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms6().getX() + 225 && y >= RPG_Game.getGame().getPlatforms6().getY() - 110 && y <= RPG_Game.getGame().getPlatforms6().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms6().getY() - 95;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms7().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms7().getX() + 225 && y >= RPG_Game.getGame().getPlatforms7().getY() - 110 && y <= RPG_Game.getGame().getPlatforms7().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms7().getY() - 95;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms8().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms8().getX() + 225 && y >= RPG_Game.getGame().getPlatforms8().getY() - 110 && y <= RPG_Game.getGame().getPlatforms8().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms8().getY() - 95;
                } else if (x + 10 >= RPG_Game.getGame().getPlatforms9().getX() - 60 && x + 10 <= RPG_Game.getGame().getPlatforms9().getX() + 225 && y >= RPG_Game.getGame().getPlatforms9().getY() - 110 && y <= RPG_Game.getGame().getPlatforms9().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms9().getY() - 95;
                } else if (x + 10 >= RPG_Game.getGame().getLp1().getX() - 60 && x + 10 <= RPG_Game.getGame().getLp1().getX() + 840 && y >= RPG_Game.getGame().getLp1().getY() - 110 && y <= RPG_Game.getGame().getLp1().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getLp1().getY() - 95;
                } else if (x + 10 >= RPG_Game.getGame().getLp2().getX() - 60 && x + 10 <= RPG_Game.getGame().getLp2().getX() + 840 && y >= RPG_Game.getGame().getLp2().getY() - 110 && y <= RPG_Game.getGame().getLp2().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getLp2().getY() - 95;
                } else {
                    if (RPG_Game.getGame().getHL() == 1) {
                        floorHeight = 485;
                    } else {
                        floorHeight = 535;
                    }
                }
            }
        }
        else{
            if (world == 1) {
                if (x + 35 >= RPG_Game.getGame().getPlatformslvl1().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatformslvl1().getX() + 150 && y >= RPG_Game.getGame().getPlatformslvl1().getY() - 110 && y <= RPG_Game.getGame().getPlatformslvl1().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatformslvl1().getY() - 110;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms2().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms2().getX() + 150 && y >= RPG_Game.getGame().getPlatforms2().getY() - 110 && y <= RPG_Game.getGame().getPlatforms2().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms2().getY() - 110;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms3().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms3().getX() + 150 && y >= RPG_Game.getGame().getPlatforms3().getY() - 110 && y <= RPG_Game.getGame().getPlatforms3().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms3().getY() - 110;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms4().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms4().getX() + 150 && y >= RPG_Game.getGame().getPlatforms4().getY() - 110 && y <= RPG_Game.getGame().getPlatforms4().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms4().getY() - 110;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms5().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms5().getX() + 150 && y >= RPG_Game.getGame().getPlatforms5().getY() - 110 && y <= RPG_Game.getGame().getPlatforms5().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms5().getY() - 110;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms6().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms6().getX() + 150 && y >= RPG_Game.getGame().getPlatforms6().getY() - 110 && y <= RPG_Game.getGame().getPlatforms6().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms6().getY() - 110;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms7().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms7().getX() + 150 && y >= RPG_Game.getGame().getPlatforms7().getY() - 110 && y <= RPG_Game.getGame().getPlatforms7().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms7().getY() - 110;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms8().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms8().getX() + 150 && y >= RPG_Game.getGame().getPlatforms8().getY() - 110 && y <= RPG_Game.getGame().getPlatforms8().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms8().getY() - 110;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms9().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms9().getX() + 150 && y >= RPG_Game.getGame().getPlatforms9().getY() - 110 && y <= RPG_Game.getGame().getPlatforms9().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms9().getY() - 110;
                } else if (x + 35 >= RPG_Game.getGame().getLp1().getX() - 60 && x + 35 <= RPG_Game.getGame().getLp1().getX() + 840 && y >= RPG_Game.getGame().getLp1().getY() - 110 && y <= RPG_Game.getGame().getLp1().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getLp1().getY() - 110;
                } else if (x + 35 >= RPG_Game.getGame().getLp2().getX() - 60 && x + 35 <= RPG_Game.getGame().getLp2().getX() + 840 && y >= RPG_Game.getGame().getLp2().getY() - 110 && y <= RPG_Game.getGame().getLp2().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getLp2().getY() - 110;
                } else {
                    if (RPG_Game.getGame().getHL() == 1) {
                        floorHeight = 485;
                    } else {
                        floorHeight = 535;
                    }
                }
            }
            else if (world == 2){
                if (x + 35 >= RPG_Game.getGame().getPlatformslvl1().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatformslvl1().getX() + 225 && y >= RPG_Game.getGame().getPlatformslvl1().getY() - 110 && y <= RPG_Game.getGame().getPlatformslvl1().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatformslvl1().getY() - 95;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms2().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms2().getX() + 225 && y >= RPG_Game.getGame().getPlatforms2().getY() - 110 && y <= RPG_Game.getGame().getPlatforms2().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms2().getY() - 95;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms3().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms3().getX() + 225 && y >= RPG_Game.getGame().getPlatforms3().getY() - 110 && y <= RPG_Game.getGame().getPlatforms3().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms3().getY() - 95;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms4().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms4().getX() + 225 && y >= RPG_Game.getGame().getPlatforms4().getY() - 110 && y <= RPG_Game.getGame().getPlatforms4().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms4().getY() - 95;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms5().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms5().getX() + 225 && y >= RPG_Game.getGame().getPlatforms5().getY() - 110 && y <= RPG_Game.getGame().getPlatforms5().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms5().getY() - 95;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms6().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms6().getX() + 225 && y >= RPG_Game.getGame().getPlatforms6().getY() - 110 && y <= RPG_Game.getGame().getPlatforms6().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms6().getY() - 95;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms7().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms7().getX() + 225 && y >= RPG_Game.getGame().getPlatforms7().getY() - 110 && y <= RPG_Game.getGame().getPlatforms7().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms7().getY() - 95;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms8().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms8().getX() + 225 && y >= RPG_Game.getGame().getPlatforms8().getY() - 110 && y <= RPG_Game.getGame().getPlatforms8().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms8().getY() - 95;
                } else if (x + 35 >= RPG_Game.getGame().getPlatforms9().getX() - 60 && x + 35 <= RPG_Game.getGame().getPlatforms9().getX() + 225 && y >= RPG_Game.getGame().getPlatforms9().getY() - 110 && y <= RPG_Game.getGame().getPlatforms9().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getPlatforms9().getY() - 95;
                } else if (x + 35 >= RPG_Game.getGame().getLp1().getX() - 60 && x + 35 <= RPG_Game.getGame().getLp1().getX() + 840 && y >= RPG_Game.getGame().getLp1().getY() - 110 && y <= RPG_Game.getGame().getLp1().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getLp1().getY() - 95;
                } else if (x + 35 >= RPG_Game.getGame().getLp2().getX() - 60 && x + 35 <= RPG_Game.getGame().getLp2().getX() + 840 && y >= RPG_Game.getGame().getLp2().getY() - 110 && y <= RPG_Game.getGame().getLp2().getY() - 60) {
                    floorHeight = (int) RPG_Game.getGame().getLp2().getY() - 95;
                } else {
                    if (RPG_Game.getGame().getHL() == 1) {
                        floorHeight = 485;
                    } else {
                        floorHeight = 535;
                    }
                }
            }
        }
        if (y < floorHeight){
            isIdle = false;
        }
        if (level >= 2) {
            if (isRight) {
                if (x+5 > RPG_Game.getGame().getwall1().getX()-90 && x+5 < RPG_Game.getGame().getwall1().getX()-15 && y > RPG_Game.getGame().getwall1().getY() - 30 && y < RPG_Game.getGame().getwall1().getY() + 145  && y < floorHeight) {
                    wallSliding = true;
                    if (!resetPos) {
                        x += 15;
                        resetPos = true;
                    }
                } else if (x + 5 > RPG_Game.getGame().getwall2().getX() - 90 && x+5 < RPG_Game.getGame().getwall2().getX()-15 && y > RPG_Game.getGame().getwall2().getY() - 30 && y < RPG_Game.getGame().getwall2().getY() + 145 && y < floorHeight) {
                    wallSliding = true;
                    if (!resetPos) {
                        x += 15;
                        resetPos = true;
                    }
                }
                else if (x + 5 > RPG_Game.getGame().getwall3().getX() - 90 && x+5 < RPG_Game.getGame().getwall3().getX()-15 && y > RPG_Game.getGame().getwall3().getY() - 30 && y < RPG_Game.getGame().getwall3().getY() + 195 && y < floorHeight) {
                    wallSliding = true;
                    if (!resetPos) {
                        x += 15;
                        resetPos = true;
                    }
                } else if (x + 5 > RPG_Game.getGame().getwall4().getX() - 90 && x+5 < RPG_Game.getGame().getwall4().getX()-15 && y > RPG_Game.getGame().getwall4().getY() - 30 && y < RPG_Game.getGame().getwall4().getY() + 195 && y < floorHeight) {
                    wallSliding = true;
                    if (!resetPos) {
                        x += 15;
                        resetPos = true;
                    }
                }
                else {
                    wallSliding = false;
                    if (resetPos) {
                        x -= 15;
                        resetPos = false;
                    }
                }
                if(wallSliding){
                    dashTimer += 30;
                }
            }
            else {
                if (x - 5 > RPG_Game.getGame().getwall1().getX() - 70 && x - 5 < RPG_Game.getGame().getwall1().getX() + 5 && y > RPG_Game.getGame().getwall1().getY() - 30 && y < RPG_Game.getGame().getwall1().getY() + 195 && y < floorHeight) {
                    wallSliding = true;
                    if (!resetPos) {
                        x -= 45;
                        resetPos = true;
                    }
                } else if (x-5 > RPG_Game.getGame().getwall2().getX()-70 && x-5 < RPG_Game.getGame().getwall2().getX() + 5 && y > RPG_Game.getGame().getwall2().getY() - 30 && y < RPG_Game.getGame().getwall2().getY() + 195 && y < floorHeight){
                    wallSliding = true;
                    if (!resetPos) {
                        x -= 45;
                        resetPos = true;
                    }
                }
                else if (x - 5 > RPG_Game.getGame().getwall3().getX() - 70 && x - 5 < RPG_Game.getGame().getwall3().getX() + 5 && y > RPG_Game.getGame().getwall3().getY() - 30 && y < RPG_Game.getGame().getwall3().getY() + 195 && y < floorHeight) {
                    wallSliding = true;
                    if (!resetPos) {
                        x -= 45;
                        resetPos = true;
                    }
                }
                else if (x - 5 > RPG_Game.getGame().getwall4().getX() - 70 && x - 5 < RPG_Game.getGame().getwall4().getX() + 5 && y > RPG_Game.getGame().getwall4().getY() - 30 && y < RPG_Game.getGame().getwall4().getY() + 195 && y < floorHeight) {
                    wallSliding = true;
                    if (!resetPos) {
                        x -= 45;
                        resetPos = true;
                    }
                }
                else {
                    wallSliding = false;
                    if (resetPos) {
                        x += 45;
                        resetPos = false;
                    }
                }
            }
        }

        if (wallSliding){
            weight = 1;
            if (isRight) {
                if(leftKeyPressed){
                    x -= velX;
                    wallJumped = false;
                }
                if (slideCount < 2) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_WallSlide_1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (slideCount < 4) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_WallSlide_2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (slideCount < 6) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_WallSlide_3.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (slideCount == 6) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_WallSlide_3.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    slideCount = 0;
                }
            }
            else{
                if(rightKeyPressed){
                    x += velX;
                    wallJumped = false;
                }
                if (slideCount < 2) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_WallSlide_1l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (slideCount < 4) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_WallSlide_2l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (slideCount < 6) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_WallSlide_3l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (slideCount == 6) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_WallSlide_3l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    slideCount = 0;
                }
            }
            slideCount++;
        }
        else{
            weight = 2;
        }

        if (y < floorHeight && meleeAttack){
            if (dashTimer >= 130) {
                dash = true;
                dashTimer = 0;
                meleeAttack = false;
            }
        }
        else{
            dash = false;
        }

        if (dash){
            jump = false;
            timer = true;
            weight = 0;
            temp = jumpStrength;
            jumpStrength = 0;

        }

        if (timer){
            dashing = true;
            time++;
            if (isRight) {
                x += 18;
                try {
                    playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Dash_1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                x -=18;
                try {
                    playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Dash_1l.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (time >= 8){
                velX = 0;
                weight = 3;
                jumpStrength = temp;
                time = 0;
                timer = false;
                attack = false;
                attacking = false;
                dashing = false;

            }
        }

        if (crouch && y < floorHeight){
            weight = 3;
        }
        if (isIdle && !crouch && !wallSliding) {
            if (isRight) {
                animCount++;
                if (animCount < 8) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 16) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 24) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_3.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 32) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_4.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 40) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_5.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 48) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_6.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount == 48) {
                    animCount = 0;
                }
            } else {
                animCount++;
                if (animCount < 8) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_1 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 16) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_2 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 24) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_3 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 32) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_4 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 40) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_5 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount < 48) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Idle_6 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (animCount == 48) {
                    animCount = 0;
                }
            }
        }
        if (isRunning && !attacking && !wallSliding || dashing) {
                if (rightKeyPressed) {
                    if(!dashing){
                    animCount++;
                    if (animCount < 6) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_1.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 12) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_2.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 18) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_3.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 24) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_4.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 30) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_5.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 36) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_6.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 42) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_7.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 48) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_8.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount == 48) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_8.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        animCount = 0;
                    }
                }

                isRight = true;
                if (x + 5 > 1480) {
                    level++;
                    x = 50;
                }
                else if(x+5 > RPG_Game.getGame().getwall1().getX()-90 && x+5 < RPG_Game.getGame().getwall1().getX()-15 && y > RPG_Game.getGame().getwall1().getY() - 30 && y < RPG_Game.getGame().getwall1().getY() + 145 ){
                    if(level >= 3) {
                        x += 0;
                        if (dashing){
                            time = 8;
                            x -= 75;
                        }
                    }
                    else{
                        if (!crouch) {
                            x += velX;
                        }
                    }
                }
                else if(x+5 > RPG_Game.getGame().getwall2().getX()-90 && x+5 < RPG_Game.getGame().getwall2().getX()-15 && y > RPG_Game.getGame().getwall2().getY() - 30 && y < RPG_Game.getGame().getwall2().getY() + 145 ){
                    if(level >= 3) {
                        x += 0;
                        if (dashing){
                            time = 8;
                        }
                    }
                    else{
                        if (!crouch) {
                            x += velX;
                        }
                    }
                }
                else if(x+5 > RPG_Game.getGame().getwall3().getX()-90 && x+5 < RPG_Game.getGame().getwall3().getX()-15 && y > RPG_Game.getGame().getwall3().getY() - 30 && y < RPG_Game.getGame().getwall3().getY() + 145 ){
                    if(level >= 3) {
                        x += 0;
                        if (dashing){
                            time = 8;
                        }
                    }
                    else{
                        if (!crouch) {
                            x += velX;
                        }
                    }
                }
                else if(x+5 > RPG_Game.getGame().getwall4().getX()-90 && x+5 < RPG_Game.getGame().getwall4().getX()-15 && y > RPG_Game.getGame().getwall4().getY() - 30 && y < RPG_Game.getGame().getwall4().getY() + 145 ){
                    if(level >= 3) {
                        x += 0;
                        if (dashing){
                            time = 8;
                        }
                    }
                    else{
                        if (!crouch) {
                            x += velX;
                        }
                    }
                }
                else {
                    if (!crouch) {
                        x += velX;
                    }
                }
            }
            if (leftKeyPressed) {
                if (!dashing) {
                    animCount++;
                    if (animCount < 6) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_1 - Left.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 12) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_2 - Left.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 18) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_3 - Left.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 24) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_4 - Left.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 30) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_5 - Left.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 36) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_6 - Left.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 42) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_7 - Left.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount < 48) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_8 - Left.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (animCount == 48) {
                        try {
                            playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Run_8 - Left.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        animCount = 0;
                    }
                }
                isRight = false;
                if (x - 5 < -50) {
                    x -= 0;
                }
                else if(x-5 > RPG_Game.getGame().getwall1().getX()-70 && x-5 < RPG_Game.getGame().getwall1().getX()+5 && y > RPG_Game.getGame().getwall1().getY() - 25 && y < RPG_Game.getGame().getwall1().getY() + 200){
                    if(level >= 3) {
                        x += 0;
                        if (dashing){
                            time = 8;
                        }
                    }
                    else{
                        if (!crouch) {
                            x += velX;
                        }
                    }
                }
                else if(x-5 > RPG_Game.getGame().getwall2().getX()-70 && x-5 < RPG_Game.getGame().getwall2().getX()+5 && y > RPG_Game.getGame().getwall2().getY() - 25 && y < RPG_Game.getGame().getwall2().getY() + 200){
                    if(level >= 3) {
                        x += 0;
                        if (dashing){
                            time = 8;
                        }
                    }
                    else{
                        if (!crouch) {
                            x += velX;
                        }
                    }
                }
                else if(x-5 > RPG_Game.getGame().getwall3().getX()-70 && x-5 < RPG_Game.getGame().getwall3().getX()+5 && y > RPG_Game.getGame().getwall3().getY() - 25 && y < RPG_Game.getGame().getwall3().getY() + 200 ){
                    if(level >= 3) {
                        x += 0;
                        if (dashing){
                            time = 8;
                        }
                    }
                    else{
                        if (!crouch) {
                            x += velX;
                        }
                    }
                }
                else if(x-5 > RPG_Game.getGame().getwall4().getX()-70 && x-5 < RPG_Game.getGame().getwall4().getX()+5 && y > RPG_Game.getGame().getwall4().getY() - 25 && y < RPG_Game.getGame().getwall4().getY() + 200 ){
                    if(level >= 3) {
                        x += 0;
                        if (dashing){
                            time = 8;
                        }
                    }
                    else{
                        if (!crouch) {
                            x += velX;
                        }
                    }
                }
                else {
                    if (!crouch) {
                        x -= velX;
                    }
                }
            }
        }

        if (jump && y >= floorHeight && !wallSliding)
            jumpStrength = 21;
            jumping = true;
            y -= jumpStrength;
            jumpStrength -= weight;


        if (jump && wallSliding) {
            if (!wallJumped)
                jumpStrength = 16;
                wallJumped = true;
            jumping = true;
            y -= jumpStrength;
            jumpStrength -= weight;
        }


        if (y >= floorHeight){
            y = floorHeight;
            hasSmashed = false;
            wallJumped = false;
            isIdle = true;
            weight = 2;
            jumping = false;// Ensure the player does not fall through the floor.
        }

        if (attack && cooldown >= 40) {
            cooldown = 0;
            if (RPG_Game.getGame().getMagic() > 0){
                didAttack = true;
            }
            if (isRight) {
                if (RPG_Game.getGame().getMagic() > 0) {
                    FireballProjectile fireball = new FireballProjectile(x+65, y+85);
                    RPG_Game.getGame().addGameObject(fireball);
                    attack = false;
                }
            } else {
                if (RPG_Game.getGame().getMagic() > 0) {
                    FireballProjectileLeft fireball = new FireballProjectileLeft(x + 15, y + 85);
                    RPG_Game.getGame().addGameObject(fireball);
                    attack = false;
                }
            }
        }

        if(meleeAttack){
            attacking = true;
        }

        if(attacking && meleeCooldown >= 20 && !(y < floorHeight)){
            if (isRight){
                if (attackCount < 2) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (attackCount < 4) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (attackCount < 6) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_3.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (attackCount < 8) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_4.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (attackCount < 10) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_5.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (attackCount < 12) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_6.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 14) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_7.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    SwordSlash swordSlash = new SwordSlash(x + 50, y);
                    RPG_Game.getGame().addGameObject(swordSlash);
                }
                else if (attackCount < 16) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_8.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 18) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_9.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 20) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_10.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 22) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_11.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 23) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_12.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount == 23) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_12.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    attacking = false;
                    attackCount = 0;
                    meleeCooldown = 0;
                    isIdle = true;
                }
                meleeAttack = false;
                attackCount++;
            }
            else{
                if (attackCount < 2) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_1l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (attackCount < 4) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_2l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (attackCount < 6) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_3l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (attackCount < 8) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_4l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (attackCount < 10) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_5l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (attackCount < 12) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_6l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 14) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_7l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 16) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_8l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 18) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_9l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 20) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_10l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 22) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_11l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount < 23) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_12l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (attackCount == 23) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Attack_12l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    attackCount = 0;
                    attacking = false;
                    meleeCooldown = 0;
                    isIdle = true;
                }
                attackCount++;
                meleeAttack = false;
            }
        }

        if(y < floorHeight && !wallSliding && !dashing) {
            if (isRight) {
                if (jumpStrength > 0) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Fall_1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Jump_1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (jumpStrength > 0) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Fall_1 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Jump_1 - Left.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (crouch && y >= floorHeight){
            if(isRight) {
                if (crouchCount < 2) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Crouch_1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (crouchCount < 4) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Crouch_2.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (crouchCount < 6) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Crouch_3.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (crouchCount < 8) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Crouch_4.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (crouchCount >= 8) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Crouch_5.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else{
                if (crouchCount < 2) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Crouch_1l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (crouchCount < 4) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Crouch_2l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (crouchCount < 6) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Crouch_3l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (crouchCount < 8) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Crouch_4l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (crouchCount >= 8) {
                    try {
                        playerImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("HeroAnims/Warrior_Crouch_5l.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            crouchCount++;
        }
        cooldown++;
        meleeCooldown++;
        checkPlat++;
    }

    public boolean checkAttack (){
        return didAttack;
    }

    public void setAttack (boolean set){
        didAttack = set;
    }

    public boolean getDirec () {
        return isRight;
    }

    public void setFloorHeight(int floorHeight){
        this.floorHeight = floorHeight;
    }

    public void draw(Graphics g, JFrame gameWindow) {
        g.drawImage(playerImage, x, y, width, height, gameWindow);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // This method will remain empty
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velX = 11;
            isIdle = false;
            isRunning = true;
            rightKeyPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            velX = 11;
            isIdle = false;
            isRunning = true;
            leftKeyPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            isIdle = false;
            jump = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            meleeAttack = true;
            isIdle = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            crouch = true;
            isIdle = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velX = 0;
            isIdle = true;
            isRunning = false;
            rightKeyPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            velX = 0;
            isIdle = true;
            isRunning = false;
            leftKeyPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            jump = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            meleeAttack = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            crouch = false;
            isIdle = true;
            crouchCount = 0;
        }
    }

}
