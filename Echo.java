import greenfoot.*;

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 1.1
 */
public class Echo extends SmoothMover
{
    private static final int gunReloadTime = 5;         // The minimum delay between firing the gun.
    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private boolean gameLose = false;
    private Boolean gameWin = false;
    
    private GreenfootImage echo = new GreenfootImage("Slipstream.png");
    private GreenfootImage echoWithThrust = new GreenfootImage("EchoThrust.png");
    
    /**
     * Initialise the Echo.
     */
    public Echo()
    {
        reloadDelayCount = 5;
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        checkKeys();
        reloadDelayCount++;
        move();
        checkCollision();
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        ignite(Greenfoot.isKeyDown("up"));
        
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
        
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-5);
        }
        
        if (Greenfoot.isKeyDown("right"))
        {
            turn(5);
        }
        
    }
    
    private void ignite(boolean boosterOn) 
    {
        if (boosterOn) 
        {
            setImage (echoWithThrust);
            addToVelocity(new Vector(getRotation(), 0.5));
            move();
        }
        else
        {
            setImage(echo);        
        }
    }
    
    private void checkCollision()
    {
        Drone a = (Drone) getOneIntersectingObject(Drone.class);
        if (a != null)
        {
            gameLose = true;
            endGame();
            getWorld().removeObject(this);
        }
    }
    
    private void endGame()
    {
        if (gameLose = true)
        {
            Greenfoot.setWorld(new EndGameLose());
        }
        
        if (gameWin = true)
        {
            Greenfoot.setWorld(new EndGameWin());
        }
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
           Bullet bullet = new Bullet (getVelocity(), getRotation());
           getWorld().addObject (bullet, getX(), getY());
           bullet.move ();
           reloadDelayCount = 0;
        }
    }
}