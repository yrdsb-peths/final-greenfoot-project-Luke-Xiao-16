import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends Actor
{
    int speed = 1;
    GreenfootImage[] Right = new GreenfootImage[2];
    GreenfootImage[] Left = new GreenfootImage[2];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Act - do whatever the Shark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        int x = getX()+speed;
        int y = getY();
        setLocation(x,y);
        
        
        if(x==0)
        {
            facing = "Right";
            setLocation(getX()+1,getY());
        }
        
        else if(x==800)
        {
            facing = "left";
            setLocation(getX()-1,getY());
        }
        
        //Shark animation
        SharkAnimation();
    }
    
    public void setSpeed(int Speed)
    {
        speed = Speed;
    }
    
    public Shark()
    {
        for(int i=0; i<Right.length; i++)
        {
            Right[i] = new GreenfootImage("images/shark"+ i +".0.png");
            Right[i].mirrorHorizontally();
            Right[i].scale(180,60);
        }
        
        for(int i=0; i<Left.length; i++)
        {
            Left[i] = new GreenfootImage("images/shark"+ i +".0.png");
            Left[i].scale(180,60);
        }
        
        //Timer
        animationTimer.mark();
        
        /*
        int x = getX();
        if(x==0)
        {
            setImage(Right[0]);
        }
        
        else if(x==800)
        {
            setImage(Left[0]);
        }
        */
        setImage(Right[0]);
    }
    
    int imageIndex = 0;
    public void SharkAnimation()
    {
        if(animationTimer.millisElapsed() < 600)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(Right[imageIndex]);
            imageIndex = (imageIndex + 1) % Right.length;
        }
            
        else
        {
            setImage(Left[imageIndex]);
            imageIndex = (imageIndex + 1) % Left.length;
        }
    }
}
