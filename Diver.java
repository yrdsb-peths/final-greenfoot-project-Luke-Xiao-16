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
    String facing = "right";
    SimpleTimer Timer = new SimpleTimer();

    /**
     * Act - do whatever the Diver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Diver() {
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

    public void DiverAnimation() {
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

    public void act() {
        // Add your action code here.
        if (Greenfoot.isKeyDown("left")) {
            // move(-1);
            setLocation(getX() - 2, getY());
            facing = "left";
        }

        else if (Greenfoot.isKeyDown("right")) {
            // move(1);
            setLocation(getX() + 2, getY());
            facing = "right";
        }

        else if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 2);
        }

        else if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 2);
        }

        // Diver finds the treasure
        find();

        // Diver animation
        DiverAnimation();
    }

    public void find() {
        if (isTouching(Treasure.class)) {
            removeTouching(Treasure.class);
            MyWorld world = (MyWorld) getWorld();
            world.createTreasure();
            world.score();
        }
    }
}
