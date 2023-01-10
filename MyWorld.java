import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * Under the sea ~~~
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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 835, 1, false); 
        
        //Create the diver
        Diver diver = new Diver();
        addObject(diver,400,40);
        
        //Create sharks
        createSharkLeft();
        createSharkRight();
        createSharkLeft();
        createSharkRight();
        
        //Create a treasure
        createTreasure();
        
        //Create a label
        scoreLabel = new Label(0,100);
        addObject(scoreLabel,70,50);
    }
    
    //Spawn treasure at different locations
    public void createTreasure()
    {
        Treasure treasure = new Treasure();
        int x = Greenfoot.getRandomNumber(800);
        int y = 805;
        addObject(treasure,x,y);
    }
    
    //Spawn sharks at different locations
    public void createSharkLeft()
    {
        Shark shark = new Shark();
        shark.setSpeed(level);
        int x = 0;
        int y = Greenfoot.getRandomNumber(795);
        addObject(shark,x,y);
    }
    
    public void createSharkRight()
    {
        Shark shark = new Shark();
        shark.setSpeed(level);
        int x = 800;
        int y = Greenfoot.getRandomNumber(795);
        addObject(shark,x,y);
    }
}
