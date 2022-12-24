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
        super(700, 840, 1, false); 
        
        //Create the diver
        Diver diver = new Diver();
        addObject(diver,300,40);
        
        //Create sharks
        
        
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
        int x = Greenfoot.getRandomNumber(600);
        int y = 815;
        addObject(treasure,x,y);
    }
}
