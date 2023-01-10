import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Just Keep Swimming",60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel,300,70);
        prepare();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    private void prepare()
    {
        Diver diver = new Diver();
        addObject(diver,400,260);
        diver.setLocation(300,205);

        Label label2 = new Label("Use Arrow Keys To Move", 35);
        addObject(label2,280,370);
        label2.setLocation(300,360);
        
        Label label = new Label("Press <Space> To Start", 35);
        addObject(label,270,300);
        label.setLocation(300,315);
    }
}
