import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treasure here.
 * Treasure class
 * @author (Luke Xiao) 
 * @version (2022-12-21)
 */
public class Treasure extends Actor
{
    GreenfootImage treasure = new GreenfootImage("images/Treasure/Treasure.png");
    /**
     * Act - do whatever the Treasure wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY();
        setLocation(x,y);
    }
    
    public Treasure()
    {
        setImage(treasure);
    }
}
