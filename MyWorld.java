import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * Under the sea ~~~
 * 
 * @author (Luke)
 * @version (2022-12-20)
 */
public class MyWorld extends World 
{
    public int Score = 0;
    Label scoreLabel;
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() 
    {
        // Create a new world with 800x835 cells with a cell size of 1x1 pixels.
        super(800, 1200, 1, false);

        // Create the diver
        createDiver();

        //Create sharks
        createShark();
        
        // Create a treasure
        createTreasure();

        // Create a label
        scoreLabel = new Label(0, 100);
        addObject(scoreLabel, 70, 60);//70,50
        
        GreenfootSound ScubaSound = new GreenfootSound("scuba.mp3");
        while(Score >= 0)
        {
            ScubaSound.play();
        }
    }
    
    // Spawn treasure at different locations
    public void createTreasure() 
    {
        Treasure treasure = new Treasure();
        int x = Greenfoot.getRandomNumber(800);
        int y = 1155;
        addObject(treasure, x, y);
    }

    //Spawn a diver
    public void createDiver()
    {
        Diver diver = new Diver();
        int x = 400;
        int y = 36;
        addObject(diver,x,y);
    }
    
    //Spawn sharks at different locations
    public void createShark()
    {
        Shark shark = new Shark();
        shark.setSpeed(level);
        int x = 1;
        int y = Greenfoot.getRandomNumber(1024);
        addObject(shark,x,y);
    }
    
    // Score keeping
    public void score() {
        Score++;
        scoreLabel.setValue(Score);
        if (Score % 5 == 0) 
        {
            level++;
        }
    }

    // Ends the game
    public void gameOver() 
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 400, 300);
    }
}
