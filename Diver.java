import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diver here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Diver extends Actor {
    GreenfootImage[] Right = new GreenfootImage[9];
    GreenfootImage[] Left = new GreenfootImage[9];
    GreenfootSound ScubaSound = new GreenfootSound("scuba.mp3");
    GreenfootSound ScreamSound = new GreenfootSound("scream.mp3");
    String facing = "right";
    SimpleTimer Timer = new SimpleTimer();
    /**
     * Act - do whatever the Diver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Diver() 
    {
        for (int i = 0; i < Right.length; i++) {
            Right[i] = new GreenfootImage("images/1." + i + ".png");
            Right[i].scale(100, 100);
        }

        for (int i = 0; i < Left.length; i++) {
            Left[i] = new GreenfootImage("images/1." + i + ".png");
            Left[i].mirrorHorizontally();
            Left[i].scale(100, 100);
        }

        // Timer
        Timer.mark();

        // Initial image
        setImage(Right[0]);
    }

    // Diver animation
    int imageIndex = 0;

    public void DiverAnimation() 
    {
        if (Timer.millisElapsed() < 200) {
            return;
        }
        Timer.mark();

        if (facing.equals("right")) {
            setImage(Right[imageIndex]);
            imageIndex = (imageIndex + 1) % Right.length;
        }

        else {
            setImage(Left[imageIndex]);
            imageIndex = (imageIndex + 1) % Left.length;
        }
    }

    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX() - 2, getY());
            facing = "left";
            setRotation(0);
        }

        else if (Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX() + 2, getY());
            facing = "right";
            setRotation(0);
        }

        else if (Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY() - 2);
            if (facing.equals("left"))
            {
                setRotation(90);
            }
            
            else if (facing.equals("right"))
            {
                setRotation(270);
            }
        }

        else if (Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY() + 2);
            if (facing.equals("left"))
            {
                setRotation(270);
            }
            
            else if (facing.equals("right"))
            {
                setRotation(90);
            }
        }

        // Diver animation
        DiverAnimation();

        //Remove the diver
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Shark.class))
        {
            world.gameOver();
            world.removeObject(this);
            ScreamSound.play();
        }
        // Diver finds the treasure
        else if(isTouching(Treasure.class)) 
        {
            foundTreasure();
        }
    }
    
    public void foundTreasure() 
    {
        removeTouching(Treasure.class);
        MyWorld world = (MyWorld) getWorld();
        world.createShark();
        world.createTreasure();
        world.createDiver();
        world.score();
        world.removeObject(this);
        ScubaSound.play();
    }
}
