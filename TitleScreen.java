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
        super(900, 600, 1); //600,400
        addObject(titleLabel,getWidth()/2,60);
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
        //Diver diver = new Diver();
        Treasure treasure = new Treasure();
        addObject(treasure,300,200);
        treasure.setLocation(300,235);//235
        
        Label label1 = new Label("Control The Diver",35);
        addObject(label1,300,130);
        label1.setLocation(300,130);
        
        Label label2 = new Label("Reach The Treasure!",35);
        addObject(label2,300,160);
        label2.setLocation(300,165);
        
        Label label3 = new Label("Press <Space> To Start",35);
        addObject(label3,300,300);
        label3.setLocation(300,300);
        
        Label label4 = new Label("Use W,A,S,D To Move", 35);
        addObject(label4,300,370);
        label4.setLocation(300,360);
    }
}
