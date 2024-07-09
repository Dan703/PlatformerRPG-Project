//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import sounds.Sound;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RPG_Game extends JPanel {

    // These values can be modified if you would like to change the size of the game window
    public static final int GAME_WIDTH = 1440;
    public static final int GAME_HEIGHT = 810;
    Color myColor;
    // Do not erase or modify these attributes, they are important for the overall game structure
    private static RPG_Game game;
    private JFrame gameWindow;
    private List<GameObject> objectsToAdd;
    private List<GameObject> objectsToRemove;
    Sound sound = new Sound();
    private BufferedImage background;
    private BufferedImage ground;
    private BufferedImage cave;
    private BufferedImage hubMap;
    private BufferedImage controls1;
    private BufferedImage controls2;
    private boolean script1;
    private boolean showMessage = false;
    private int messageCounter = 0;
    Font pixeloid;
    // This is a variable that allows us to quickly find the PlayerShip object if we need it
    private Char player;
    private hubPlayer loc;
    private menuPlayer menu;
    private Boundary bound1;
    private Signs sign1;
    private Signs sign2;
    private SingleSpike ss1;
    private SingleSpikeCeiling css1;
    private Spikes spike1;
    private Spikes spike2;
    private Spikes spike3;
    private Spikes spike4;
    private Spikes spike5;
    private Spikes spike6;
    private Spikes spike7;
    private Spikes spike8;
    private CeilingSpikes cs1;
    private CeilingSpikes cs2;
    private CeilingSpikes cs3;
    private CeilingSpikes cs4;
    private WallSpikes ws1;
    private WallSpikes ws2;
    private WallSpikes ws3;
    private WallSpikes ws4;
    private RegSkeleton enemy1;
    private WarriorSkeleton enemy2;
    private RegSkeleton enemy3;
    private RegSkeleton enemy4;
    private FastWarriorSkeleton enemy5;
    private HeartPowerUp item1;
    private MagicPowerUp item2;
    private Platform platform1;
    private Platform platform2;
    private Platform platform3;
    private Platform platform4;
    private Platform platform5;
    private Platform platform6;
    private Platform platform7;
    private Platform platform8;
    private Platform platform9;
    private LongPlatform lp1;
    private LongPlatform lp2;
    private Wall wall1 = new Wall(1400, 420);
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;
    private boolean onPlatform = false;
    private Tree tree1;
    private House house;
    private int damageCount = 0;
    private boolean reset = false;
    private int lives = 100;
    private int magic = 100;
    private int numEnemies = 0;
    private Rectangle hitBox;
    private Rectangle objectHitBox;
    private boolean movePlat = false;
    private int platsMoved = 0;
    private boolean deleteDaggers = false;
    private TreeDeco td1;
    private TreeDeco td2;
    private TreeDeco td3;
    private TreeDeco td4;
    private TreeDeco td5;
    private TreeDeco td6;
    private TreeDeco td7;
    private W2tree w2t;
    private RockDeco rd1;
    private RockDeco rd2;
    private RockDeco rd3;
    private RockDeco rd4;
    private RockDeco rd5;
    private BushDeco1 bd1;
    private BushDeco1 bd2;
    private BushDeco1 bd3;
    private BushDeco1 bd4;
    private BushDeco1 bd5;
    private BushDeco2 b1;
    private BushDeco2 b2;
    private BushDeco2 b3;
    private boolean menuRunning = true;
    private boolean hwRunning = false;
    private boolean gameRunning = false;
    private int hubLevel = 1;
    private int levelChosen = 1;
    private boolean startLevel = false;
    private boolean startGame = false;
    private boolean lvl1Comp = false;
    private boolean lvl2Comp = false;
    private boolean lvl1CompMessage = false;
    private hubFlag lvl1;
    private int deaths = 0;
    private int coinsTotal = 0;
    private int coinsAdded = 0;
    private int timer = 0;
    private int menuAction = 0;
    // This is the List that contains all the active GameObjects that should
    // be updated and drawn in the game loop
    private List<GameObject> activeGameObjects;

    // Feel free to add new attributes if you need them
    // (for example, if you would like to keep track of the player's score



    public static RPG_Game getGame() {
        return game;
    }

    public static void main(String[] args) throws InterruptedException {

        // This code is used to create the main Java object for the game and start running the game
        game = new RPG_Game();
        game.run();
    }

    public RPG_Game() {
        initMainMenu();
        // And create the window in which the game will take place
        initializeGameWindow();
    }

    private void run() throws InterruptedException {
        // This is the main game loop and where we will repeatedly update the game
        while (true) {

            // This is just to set a small delay between each of the game's "frame"
            // Otherwise it will go too fast
            if (hwRunning || menuRunning) {
                Thread.sleep(20);
            }
            else if (gameRunning){
                if (player.getWorld() == 1){
                    Thread.sleep(20);
                }
                else{
                    Thread.sleep(10);
                }
            }

            // DO NOT REMOVE THIS, this allows us to update the List of active game objects
            // It adds any new objects that were created in the last iteration of the game loop
            addGameObjects();

            // Write your code here to update the game every iteration of the loop

            // ADD YOUR CODE HERE
            for (GameObject object : activeGameObjects){
                object.update();
            }

            if (gameRunning) {
                timer++;
                if (player.checkAttack()) {
                    playSE(2);
                    player.setAttack(false);
                    magic -= 8;
                }

                if (player.getLevel() == 2 && !reset) {
                    removeGameObject(tree1);
                    removeGameObject(platform1);
                    removeGameObject(platform2);
                    removeGameObject(platform3);
                    for (GameObject object : activeGameObjects) {
                        if (object instanceof RockDeco || object instanceof TreeDeco || object instanceof BushDeco2 || object instanceof BushDeco1) {
                            removeGameObject(object);
                        }
                    }
                    reset = true;
                    level2();
                }

                if (player.getLevel() == 3 && reset) {
                    removeGameObject(sign1);
                    removeGameObject(ss1);
                    removeGameObject(spike2);
                    removeGameObject(spike3);
                    removeGameObject(spike4);
                    removeGameObject(platform1);
                    for (GameObject object : activeGameObjects) {
                        if (object instanceof RockDeco || object instanceof TreeDeco || object instanceof BushDeco2 || object instanceof BushDeco1) {
                            removeGameObject(object);
                        }
                    }
                    reset = false;
                    level3();
                }

                if (player.getLevel() == 4 && !reset) {
                    removeGameObject(sign1);
                    removeGameObject(sign2);
                    removeGameObject(spike1);
                    removeGameObject(spike2);
                    removeGameObject(spike3);
                    removeGameObject(spike4);
                    removeGameObject(spike5);
                    removeGameObject(spike6);
                    removeGameObject(spike7);
                    removeGameObject(spike8);
                    removeGameObject(platform1);
                    removeGameObject(platform2);
                    removeGameObject(platform3);
                    removeGameObject(platform4);
                    removeGameObject(platform5);
                    removeGameObject(platform6);
                    removeGameObject(platform7);
                    removeGameObject(platform8);
                    removeGameObject(platform9);
                    removeGameObject(wall1);
                    removeGameObject(wall2);
                    removeGameObject(wall3);
                    removeGameObject(wall4);
                    removeGameObject(cs1);
                    removeGameObject(cs2);
                    removeGameObject(cs3);
                    removeGameObject(ss1);
                    removeGameObject(css1);
                    for (GameObject object : activeGameObjects) {
                        if (object instanceof RockDeco || object instanceof TreeDeco || object instanceof BushDeco2 || object instanceof BushDeco1) {
                            removeGameObject(object);
                        }
                    }
                    reset = true;
                    level4();
                }

                if (player.getLevel() == 5 && reset) {
                    removeGameObject(sign1);
                    removeGameObject(sign2);
                    removeGameObject(spike1);
                    removeGameObject(spike2);
                    removeGameObject(spike3);
                    removeGameObject(spike4);
                    removeGameObject(spike5);
                    removeGameObject(spike6);
                    removeGameObject(spike7);
                    removeGameObject(spike8);
                    removeGameObject(platform1);
                    removeGameObject(platform2);
                    removeGameObject(platform3);
                    removeGameObject(platform4);
                    removeGameObject(platform5);
                    removeGameObject(platform6);
                    removeGameObject(platform7);
                    removeGameObject(platform8);
                    removeGameObject(platform9);
                    removeGameObject(wall1);
                    removeGameObject(wall2);
                    removeGameObject(wall3);
                    removeGameObject(wall4);
                    removeGameObject(cs1);
                    removeGameObject(cs2);
                    removeGameObject(cs3);
                    removeGameObject(cs4);
                    removeGameObject(ws1);
                    removeGameObject(ws2);
                    removeGameObject(ws3);
                    removeGameObject(ws4);
                    removeGameObject(lp1);
                    removeGameObject(lp2);
                    removeGameObject(enemy1);
                    removeGameObject(enemy2);
                    removeGameObject(enemy3);
                    removeGameObject(enemy4);
                    removeGameObject(bound1);
                    removeGameObject(ss1);
                    removeGameObject(css1);
                    for (GameObject object : activeGameObjects) {
                        if (object instanceof RockDeco || object instanceof TreeDeco || object instanceof BushDeco2 || object instanceof BushDeco1) {
                            removeGameObject(object);
                        }
                    }
                    deleteDaggers = true;
                    reset = false;
                    level5();
                }
                else if (player.getLevel() == 6 && !reset){
                    removeGameObject(sign1);
                    removeGameObject(sign2);
                    removeGameObject(spike1);
                    removeGameObject(spike2);
                    removeGameObject(spike3);
                    removeGameObject(spike4);
                    removeGameObject(spike5);
                    removeGameObject(spike6);
                    removeGameObject(spike7);
                    removeGameObject(spike8);
                    removeGameObject(platform1);
                    removeGameObject(platform2);
                    removeGameObject(platform3);
                    removeGameObject(platform4);
                    removeGameObject(platform5);
                    removeGameObject(platform6);
                    removeGameObject(platform7);
                    removeGameObject(platform8);
                    removeGameObject(platform9);
                    removeGameObject(wall1);
                    removeGameObject(wall2);
                    removeGameObject(wall3);
                    removeGameObject(wall4);
                    removeGameObject(cs1);
                    removeGameObject(cs2);
                    removeGameObject(cs3);
                    removeGameObject(cs4);
                    removeGameObject(ws1);
                    removeGameObject(ws2);
                    removeGameObject(ws3);
                    removeGameObject(ws4);
                    removeGameObject(lp1);
                    removeGameObject(lp2);
                    removeGameObject(enemy1);
                    removeGameObject(enemy2);
                    removeGameObject(enemy3);
                    removeGameObject(enemy4);
                    removeGameObject(bound1);
                    removeGameObject(ss1);
                    removeGameObject(css1);
                    for (GameObject object : activeGameObjects) {
                        if (object instanceof RockDeco || object instanceof TreeDeco || object instanceof BushDeco2 || object instanceof BushDeco1) {
                            removeGameObject(object);
                        }
                    }
                    gameRunning = false;
                    hwRunning = true;
                    stopMusic();
                    initHubWorld();
                    coinsAdded = 1000 - (timer*20)/1000;
                    coinsTotal += coinsAdded;
                    if(coinsTotal < 0) {
                        coinsTotal = 0;
                    }
                    System.out.print(coinsTotal);
                    if(hubLevel == 1){
                        lvl1Comp = true;
                    }
                    gameWindow.addKeyListener(loc);
                    gameWindow.requestFocus();
                }

                if (movePlat && player.getLevel() == 4) {
                    if (platsMoved == 0) {
                        platform2.moveUp();
                    } else if (platsMoved >= 1) {
                        platform4.moveRight();
                        platform4.moveUp();
                    }
                    platsMoved++;
                    movePlat = false;
                }

                if (magic < 0) {
                    magic = 0;
                }

                if (lives < 0) {
                    lives = 0;
                }
                checkForCollisions();
            }
            else if (hwRunning){
                if (startLevel){
                    gameRunning = true;
                    hwRunning = false;
                    stopMusic();
                    if (hubLevel == 1) {
                        initLevel1();
                        player.setWorld(1);
                    }
                    else if (hubLevel == 2){
                        world2();
                        player.setWorld(2);
                    }
                    startLevel = false;
                    gameWindow.addKeyListener(player);
                    gameWindow.requestFocus();
                }
                if (lvl1Comp){
                    lvl1 = new hubFlag(200, 446);
                    addGameObject(lvl1);
                    loc.setLevelChosen(2);
                    lvl1CompMessage = true;
                    lvl1Comp = false;
                }
            }
            else{
                if (startGame){
                    menuRunning = false;
                    gameRunning = false;
                    hwRunning = true;
                    stopMusic();
                    initHubWorld();
                    gameWindow.addKeyListener(loc);
                    gameWindow.requestFocus();
                }
            }
            // DO NOT REMOVE THIS, this allows us to update the List of active game objects
            // It removes any objects that needs to be removed from the game window based on
            // this iteration of the game loop
            deleteGameObjects();
            repaint();
        }
    }

    private void checkHitBox (Platform p){
        System.out.print(hitBox.intersects(objectHitBox));
    }

    public int getMagic(){
        return magic;
    }

    private void checkForCollisions() {
        for (int i = 0; i < activeGameObjects.size(); i++) {

            for (int j = 0; j < activeGameObjects.size(); j++) {

                GameObject firstObject = activeGameObjects.get(i);
                GameObject secondObject = activeGameObjects.get(j);

                if (firstObject == secondObject) {
                    continue;
                }

                if (firstObject.collidesWith(secondObject)) {
                    if(firstObject instanceof Char && secondObject instanceof Signs){
                        script1 = true;
                        showMessage = true;
                    }
                    if(firstObject instanceof SwordSlash && secondObject instanceof RegSkeleton){
                        damageCount++;
                        if(damageCount == 75) {
                            removeGameObject(firstObject);
                            if(numEnemies == 0) {
                                enemy1.setDead(true);
                                numEnemies++;
                            }
                            else{
                                enemy4.setDead(true);
                                numEnemies++;
                            }
                            damageCount = 0;
                        }
                    }
                    if(firstObject instanceof SwordSlash && secondObject instanceof WarriorSkeleton){
                        damageCount++;
                        if(damageCount == 30) {
                            removeGameObject(firstObject);
                            if(player.getLevel() == 4) {
                                enemy2.setDead(true);
                                numEnemies++;
                            }
                            else{
                                //enemy4.setDead(true);
                                //numEnemies++;
                            }
                            damageCount = 0;
                        }
                    }
                    if (firstObject instanceof Char && (secondObject instanceof Spikes || secondObject instanceof CeilingSpikes || secondObject instanceof WallSpikes || secondObject instanceof SingleSpike || secondObject instanceof SingleSpikeCeiling)){
                        player.respawn();
                        deaths++;
                    }
                    if (firstObject instanceof Char && secondObject instanceof RegSkeleton){
                        player.respawn();
                        deaths++;
                    }
                    if (firstObject instanceof Char && secondObject instanceof WarriorSkeleton){
                        player.respawn();
                        deaths++;
                    }
                    if (firstObject instanceof Char && secondObject instanceof DaggerProjectile){
                        player.respawn();
                        deaths++;
                        removeGameObject(secondObject);
                    }
                    if (firstObject instanceof Char && secondObject instanceof HeartPowerUp){
                        lives += 75;
                        playSE(3);
                        removeGameObject(secondObject);
                    }
                    if (firstObject instanceof Char && secondObject instanceof MagicPowerUp){
                        magic += 80;
                        playSE(3);
                        removeGameObject(secondObject);
                    }
                    if (firstObject instanceof Char && secondObject instanceof Platform && player.isJumping()) {
                        player.stopJump();
                    }
                }
                else if(firstObject.collidesWithPlatform(secondObject)){
                    if (firstObject instanceof Char && secondObject instanceof Platform){
                        player.setFloorHeight((int)secondObject.getY() - 110);
                        onPlatform = true;
                    }
                }
                else{
                    onPlatform = false;
                }
            }
        }
    }

    public Platform getPlatformslvl1 (){
            return platform1;
    }
    public Platform getPlatforms2 (){
        return platform2;
    }
    public Platform getPlatforms3 (){
        return platform3;
    }
    public Platform getPlatforms4 (){
        return platform4;
    }
    public Platform getPlatforms5 (){
        return platform5;
    }
    public Platform getPlatforms6 (){
        return platform6;
    }
    public Platform getPlatforms7 (){
        return platform7;
    }
    public Platform getPlatforms8 (){
        return platform8;
    }
    public Platform getPlatforms9 (){
        return platform9;
    }

    public LongPlatform getLp1 (){
        return lp1;
    }

    public LongPlatform getLp2 (){
        return lp2;
    }

    public Wall getwall1 (){
        return wall1;
    }

    public Wall getwall2 (){
        return wall2;
    }

    public Wall getwall3(){
        return wall3;
    }

    public Wall getwall4(){
        return wall4;
    }

    public void setMovePlat (boolean move){
        movePlat = move;
    }

    public void setDD(boolean setDaggers){
        deleteDaggers = setDaggers;
    }

    public boolean getDD (){
        return deleteDaggers;
    }

    @Override
    public void paint(Graphics g) {
        // DO NOT DELETE THIS LINE
        // This performs the basic operation of drawing the game window
        super.paint(g);
        if (gameRunning) {
            if (hubLevel == 1) {
                try {
                    background = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/sky.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    ground = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/ground.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    cave = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/grassBack.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g.drawImage(background, 0, 0, 1440, 810, gameWindow);
                g.drawImage(ground, -55, 575, 1470, 245, gameWindow);
                if (player.getLevel() == 3) {
                    g.drawImage(cave, 620, 135, 260, 270, gameWindow);
                    g.drawImage(cave, 810, 135, 260, 270, gameWindow);
                }
                else if (player.getLevel() == 4) {
                    g.drawImage(cave, 220, 430, 210, 210, gameWindow);
                    g.drawImage(cave, 360, 430, 210, 210, gameWindow);
                    g.drawImage(cave, 500, 430, 210, 210, gameWindow);
                    g.drawImage(cave, 640, 430, 210, 210, gameWindow);
                    g.drawImage(cave, 780, 430, 210, 210, gameWindow);
                    g.drawImage(cave, 920, 430, 210, 210, gameWindow);
                }
            }
            else if (hubLevel == 2){
                try {
                    background = ImageIO.read(getClass().getClassLoader().getResourceAsStream("world2/w2_bg.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    ground = ImageIO.read(getClass().getClassLoader().getResourceAsStream("world2/groundW2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g.drawImage(background, 0, 0, 1440, 810, gameWindow);
                g.drawImage(ground, -35, 585, 730, 200, gameWindow);
                g.drawImage(ground, 655, 585, 730, 200, gameWindow);
            }
            /*
            if (player.getDirec()) {
                if (player.isCrouching()){
                    g.drawRect(player.x+70, player.y+75, 20, 30);
                }
                else{
                    g.drawRect(player.x+70, player.y+45, 20, 60);
                }
            }
            else{
                if (player.isCrouching()){
                    g.drawRect(player.x+105, player.y+75, 20, 30);
                }
                else{
                    g.drawRect(player.x+105, player.y+45, 20, 60);
                }
            }

             */
        }
        if (hwRunning){
            try {
                hubMap = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Maps/HubWorld1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                controls1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/spaceControls.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }try {
                controls2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/arrowControls.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(hubMap, 0, 0, 1440, 810, gameWindow);
            g.drawImage(controls1, 5, 650, 75, 25, gameWindow);
            g.drawImage(controls2, 2, 690, 75, 25, gameWindow);
        }


        InputStream is = getClass().getResourceAsStream("/font/PixeloidMono-d94EV.ttf");
        try {
            pixeloid = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(script1){
            g.setColor(Color.WHITE);
            if (showMessage) {
                g.setFont(pixeloid);
                g.setFont(g.getFont().deriveFont(Font.PLAIN, 20F));
                g.drawString(sign1.getText(), 550, 75);
                messageCounter++;
            }
            if (messageCounter >= 70){
                showMessage = false;
            }
        }
        g.setColor(Color.WHITE);
        g.setFont(pixeloid);
        if (hwRunning){
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 45F));
            g.drawString("World 1", 30, 55);
            if (hubLevel == 1){
                g.setFont(g.getFont().deriveFont(Font.PLAIN, 20F));
                g.drawString("Level 1-1 ~ Quiet Grasslands", 30, 90);
                if(lvl1CompMessage){
                    g.setColor(Color.GREEN);
                    g.drawString("Level Completed", 30, 125);
                }
            }
            else if (hubLevel == 2){
                g.setFont(g.getFont().deriveFont(Font.PLAIN, 20F));
                g.drawString("Level 1-2 ~ Lampshade Forest", 30, 90);
            }
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 15F));
            g.setColor(Color.WHITE);
            g.drawString("to play", 75,667);
            g.drawString("to move", 70, 707);
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 21F));
            g.drawString("Coins: " + coinsTotal, 1200, 30);
        }
    if (menuRunning){
        try {
            background = ImageIO.read(getClass().getClassLoader().getResourceAsStream("props/menuBack.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(background, 0, 0, 1440, 810, gameWindow);
        g.setFont(g.getFont().deriveFont(Font.PLAIN, 70F));
        g.setColor(Color.WHITE);
        g.drawString("GAME TITLE", 460, 100);
        g.setFont(g.getFont().deriveFont(Font.PLAIN, 40F));
        g.setColor(Color.CYAN);
        if (menu.getButtonPicked() == 0){
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 55F));
            g.drawString("New Game", 560, 250);
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 40F));
            g.drawString("Load Game", 560, 375);
            g.drawString("Credits", 560, 500);
        }
        else if (menu.getButtonPicked() == 1){
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 40F));
            g.drawString("New Game", 560, 250);
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 55F));
            g.drawString("Load Game", 560, 375);
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 40F));
            g.drawString("Credits", 560, 500);
        }
        else if (menu.getButtonPicked() == 2){
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 40F));
            g.drawString("New Game", 560, 250);
            g.drawString("Load Game", 560, 375);
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 55F));
            g.drawString("Credits", 560, 500);
        }

    }
        // Add code here to draw your game (i.e., background, GameObjects, etc.)
        for(GameObject object : activeGameObjects){
            object.draw(g, gameWindow);
        }

    }

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }

    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }

    public Char getPlayer(){
        return player;
    }

    public void setLevelChosen (int levelChosen){
        hubLevel = levelChosen;
    }

    public void setMenuAction (int levelChosen){
        hubLevel = levelChosen;
    }

    public void setStartLevel (boolean start){
        startLevel = start;
    }

    public void setStartGame (boolean start){
        startGame = start;
    }

    private void initMainMenu(){
        activeGameObjects = new ArrayList<>();
        objectsToAdd = new ArrayList<>();
        objectsToRemove = new ArrayList<>();
        playMusic(7);
        playMusic(6);
        menu = new menuPlayer(250,400);
        addGameObject(menu);
    }

    private void initHubWorld(){
        activeGameObjects = new ArrayList<>();
        objectsToAdd = new ArrayList<>();
        objectsToRemove = new ArrayList<>();
        playMusic(4);
        loc = new hubPlayer(250,400);
        addGameObject(loc);
    }

    private void initLevel1() {

        // Initialize the 3 lists that are used to manage game objects
        activeGameObjects = new ArrayList<>();
        objectsToAdd = new ArrayList<>();
        objectsToRemove = new ArrayList<>();
        playMusic(0);
        player = new Char(GAME_WIDTH / 4 + 75, GAME_HEIGHT - 225);
        tree1 = new Tree(25, 225);
        platform1 = new Platform(650, 500);
        platform2 = new Platform(850, 400);
        platform3 = new Platform(1050, 500);
        platform4 = new Platform(2000, 2000);
        platform5 = new Platform(2000, 2000);
        platform6 = new Platform(2000, 2000);
        platform7 = new Platform(2000, 2000);
        platform8 = new Platform(2000, 2000);
        platform9 = new Platform(2000, 2000);
        lp1 = new LongPlatform(2000, 2000);
        lp2 = new LongPlatform(2000, 2000);
        wall1 = new Wall(2000, 2000);
        wall2 = new Wall(2000, 2000);
        wall3 = new Wall(2000, 2000);
        wall4 = new Wall(2000, 2000);
        bound1 = new Boundary(2000,2000);


        //sign1 = new Signs(1200, 525, "Your fate awaits you! -->");
        addGameObject(player);
        addGameObject(tree1);
        addGameObject(platform1);
        addGameObject(platform2);
        addGameObject(platform3);



        //addGameObject(sign1);
        // This is where you will add any other code that is useful to prepare the game before it starts
        // For example, adding the enemy ships to the game

        // ADD YOUR CODE HERE
    }

    private void level2() {
        showMessage = false;
        sign1 = new Signs(770, 445, "A journey awaits you! -->", true);
        platform1 = new Platform(640, 485);
        platform2 = new Platform(2000, 2000);
        platform3 = new Platform(2000, 2000);
        ss1  = new SingleSpike(302, 565);
        spike1 = new Spikes(250,565);
        spike2 = new Spikes(480,565);
        spike3 = new Spikes(880,565);
        spike4 = new Spikes(1150,565);
        bd1 = new BushDeco1(670, 560);
        b1 = new BushDeco2(1020, 555);
        td1 = new TreeDeco(-40, 425);
        addGameObject(ss1);
        addGameObject(spike2);
        addGameObject(spike3);
        addGameObject(spike4);
        addGameObject(sign1);
        addGameObject(platform1);
        addGameObject(platform2);
        addGameObject(platform3);
        addGameObject(bd1);
        addGameObject(td1);
        addGameObject(b1);


    }

    private void level3() {
        showMessage = false;
        ss1 = new SingleSpike(980,305);
        css1 = new SingleSpikeCeiling(500, 170);
        spike1 = new Spikes(300,570);
        spike2 = new Spikes(380,570);
        spike3 = new Spikes(750,570);
        spike4 = new Spikes(830,570);
        spike5 = new Spikes(905,305);
        spike6 = new Spikes(720,100);
        spike7 = new Spikes(800,100);
        spike8 = new Spikes(876,100);
        wall1 = new Wall(1280, 235);
        wall2 = new Wall(1040, 315);
        wall3 = new Wall(50, 100);
        wall4 = new Wall(1280, 350);
        platform1 = new Platform(900,330 );
        platform2 = new Platform(725,330 );
        platform3 = new Platform(550,330 );
        platform4 = new Platform(810,125 );
        platform5 = new Platform(635,125 );
        platform6 = new Platform(460,125 );
        platform7 = new Platform(250,330 );
        platform8 = new Platform(985,125 );
        platform9 = new Platform(1160,125 );
        cs1 = new CeilingSpikes(500, 170);
        cs2 = new CeilingSpikes(765, 170);
        cs3 = new CeilingSpikes(1100, 170);
        enemy1 = new RegSkeleton(1100, 75);
        sign1 = new Signs(920, 555, "Jump while wall sliding to wall jump!", true);
        sign2 = new Signs(750, 300, "Space while in the air to DASH!", false);
        td1 = new TreeDeco(530, 425);
        rd1 = new RockDeco(475, 545);
        addGameObject(sign1);
        addGameObject(sign2);
        addGameObject(spike1);
        addGameObject(spike3);
        addGameObject(ss1);
        addGameObject(spike6);
        addGameObject(spike8);
        addGameObject(css1);
        addGameObject(cs2);
        addGameObject(cs3);
        addGameObject(platform1);
        addGameObject(platform2);
        addGameObject(platform3);
        addGameObject(platform4);
        addGameObject(platform5);
        addGameObject(platform6);
        addGameObject(platform7);
        addGameObject(platform8);
        addGameObject(platform9);
        addGameObject(wall4);
        addGameObject(wall1);
        addGameObject(wall2);
        addGameObject(wall3);
        addGameObject(td1);
        addGameObject(rd1);
    }

    private void level4() {
        showMessage = false;
        platform1 = new Platform(105, 520);
        platform2 = new Platform(15, 410);
        platform3 = new Platform(920, 412);
        platform4 = new Platform(1110, 410);
        platform5 = new Platform(1180, 105);
        platform6 = new Platform(1055, 250);
        platform7 = new Platform(2000,2000 );
        platform8 = new Platform(2000,2000 );
        platform9 = new Platform(2000,2000 );
        cs1 = new CeilingSpikes(300,155 );
        cs2 = new CeilingSpikes(470,155 );
        cs3 = new CeilingSpikes(710,155 );
        cs4 = new CeilingSpikes(880,155 );
        ws1 = new WallSpikes(1280,350, true );
        ws2 = new WallSpikes(1280,70, true );
        ws3 = new WallSpikes(1280,-70, true );
        ws4 = new WallSpikes(1280,210, true );
        spike1 = new Spikes(385, 85);
        spike2 = new Spikes(590, 85);
        spike3 = new Spikes(795, 85);
        lp1 = new LongPlatform(215, 410);
        lp2 = new LongPlatform(215, 105);
        wall1 = new Wall(625, 420);
        wall2 = new Wall(625, 250);
        wall3 = new Wall(625, 100);
        wall4 = new Wall(20, 0);
        bound1 = new Boundary(1310, -415);
        enemy1 = new RegSkeleton(570,350);
        enemy2 = new WarriorSkeleton(725,345);
        enemy3 = new RegSkeleton(1190,45);
        enemy4 = new RegSkeleton(1260,530);
        addGameObject(platform1);
        addGameObject(platform2);
        addGameObject(platform3);
        addGameObject(platform4);
        addGameObject(platform5);
        addGameObject(platform6);
        addGameObject(wall1);
        addGameObject(wall2);
        addGameObject(wall3);
        addGameObject(wall4);
        addGameObject(bound1);
        addGameObject(cs1);
        addGameObject(cs2);
        addGameObject(cs3);
        addGameObject(cs4);
        addGameObject(ws1);
        addGameObject(ws2);
        addGameObject(ws3);
        addGameObject(ws4);
        addGameObject(spike1);
        addGameObject(spike2);
        addGameObject(spike3);
        addGameObject(lp1);
        addGameObject(lp2);
        addGameObject(enemy1);
        addGameObject(enemy2);
        addGameObject(enemy3);
        addGameObject(enemy4);
    }

    private void level5() {
        showMessage = false;
        platform1 = new Platform(2000, 2000);
        platform2 = new Platform(2000, 2000);
        platform3 = new Platform(2000, 2000);
        platform4 = new Platform(2000, 2000);
        platform5 = new Platform(2000, 2000);
        platform6 = new Platform(2000, 2000);
        platform7 = new Platform(2000,2000 );
        platform8 = new Platform(2000,2000 );
        platform9 = new Platform(2000,2000 );
        cs1 = new CeilingSpikes(2000, 2000 );
        cs2 = new CeilingSpikes(2000, 2000);
        cs3 = new CeilingSpikes(2000, 2000);
        cs4 = new CeilingSpikes(2000, 2000);
        ws1 = new WallSpikes(2000, 2000, true );
        ws2 = new WallSpikes(2000, 2000, true );
        ws3 = new WallSpikes(2000, 2000, true );
        ws4 = new WallSpikes(2000, 2000, true );
        spike1 = new Spikes(2000, 2000);
        spike2 = new Spikes(2000, 2000);
        spike3 = new Spikes(2000, 2000);
        lp1 = new LongPlatform(2000, 2000);
        lp2 = new LongPlatform(2000, 2000);
        wall1 = new Wall(2000, 2000);
        wall2 = new Wall(2000, 2000);
        wall3 = new Wall(2000, 2000);
        wall4 = new Wall(2000, 2000);
        bound1 = new Boundary(2000, 2000);
        enemy1 = new RegSkeleton(2000, 2000);
        enemy2 = new WarriorSkeleton(2000, 2000);
        enemy3 = new RegSkeleton(2000, 2000);
        enemy4 = new RegSkeleton(2000, 2000);
        house = new House(700, 283);
        td1 = new TreeDeco(30, 425);
        td2 = new TreeDeco(230, 425);
        td3 = new TreeDeco(430, 425);
        td4 = new TreeDeco(630, 425);
        td5 = new TreeDeco(830, 425);
        addGameObject(td1);
        addGameObject(td2);
        addGameObject(td3);
        addGameObject(td4);
        addGameObject(td5);
    }

    private void world2(){
        activeGameObjects = new ArrayList<>();
        objectsToAdd = new ArrayList<>();
        objectsToRemove = new ArrayList<>();
        playMusic(5);
        player = new Char(GAME_WIDTH / 4 - 75, GAME_HEIGHT - 225);
        platform1 = new Platform(300, 420);
        platform2 = new Platform(800, 420);
        platform3 = new Platform(-75, 520);
        platform4 = new Platform(1105, 520);
        platform5 = new Platform(-75, 320);
        platform6 = new Platform(2000, 2000);
        platform7 = new Platform(2000, 2000);
        platform8 = new Platform(2000, 2000);
        platform9 = new Platform(2000, 2000);
        lp1 = new LongPlatform(2000, 2000);
        lp2 = new LongPlatform(2000, 2000);
        wall1 = new Wall(2000, 2000);
        wall2 = new Wall(2000, 2000);
        wall3 = new Wall(2000, 2000);
        wall4 = new Wall(2000, 2000);
        bound1 = new Boundary(2000,2000);
        w2t = new W2tree(500, 221);
        addGameObject(w2t);
        addGameObject(player);
        addGameObject(platform1);
        addGameObject(platform2);
        addGameObject(platform3);
        addGameObject(platform4);
        addGameObject(platform5);
        //addGameObject(platform6);

    }

    public int getHL (){
        return hubLevel;
    }

    private void initializeGameWindow() {

        // YOU WILL MOST LIKELY NOT NEED TO MODIFY THIS METHOD KEEP IT AS IS
        // This code creates the game window, feel free to ignore it
        gameWindow = new JFrame("Game window");
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameWindow.setSize(GAME_WIDTH, GAME_HEIGHT);
        gameWindow.setResizable(false);
        gameWindow.setLocationRelativeTo(null);

        this.setSize(GAME_WIDTH, GAME_HEIGHT);

        // This code, makes it possible to use the keyboard to control the PlayerShip object
        gameWindow.addKeyListener(menu);
        this.requestFocus();

        gameWindow.add(this);
        gameWindow.setVisible(true);
    }

    // THE NEXT 4 METHODS SHOULD NOT BE CHANGED/REMOVED
    // Those methods are useful as a mechanism to avoid modifying the list of activeGameObjects
    // at the same time that we are iterating on that same list
    public void addGameObject(GameObject newObject) {
        objectsToAdd.add(newObject);
    }

    private void addGameObjects() {
        activeGameObjects.addAll(objectsToAdd);
        objectsToAdd.clear();
    }

    public void removeGameObject(GameObject objectToRemove) {
        objectsToRemove.add(objectToRemove);
    }

    private void deleteGameObjects() {
        activeGameObjects.removeAll(objectsToRemove);
        objectsToRemove.clear();
    }
}