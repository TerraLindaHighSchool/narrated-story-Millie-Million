import greenfoot.*;

/**
 * A rock in space.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 */
public class Drone extends SmoothMover
{
    /** Size of this drone */
    private int size;

    /** When the stability reaches 0 the asteroid will explode */
    private int stability;


    /**
     * Create a drone with default size and random direction of movement.
     */
    public Drone()
    {
        this(50);
    }
    
    /**
     * Create a drone with a given size and random direction of movement.
     */
    public Drone(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
        setSize(size);
    }
    
    /**
     * Create a drone with a given size and direction of movement.
     */
    public Drone(int size, Vector velocity)
    {
        super(velocity);
        setSize(size);
    }
    
    public void act()
    {         
        move();
    }

    /**
     * Set the size of this drone. Note that stability is directly
     * related to size. Smaller drones are less stable.
     */
    public void setSize(int size) 
    {
        stability = size;
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size, size);
    }

    /**
     * Return the current stability of this asteroid. (If it goes down to 
     * zero, it breaks up.)
     */
    public int getStability() 
    {
        return stability;
    }
    
    /**
     * Hit this drone dealing the given amount of damage.
     */
    public void hit(int damage) 
    {
        stability = stability - damage;
        if (stability <= 0) 
        {
            breakUp();
        }
    }
    
    /**
     * Break up this drone. If we are still big enough, this will create two
     * smaller drones. If we are small already, just disappear.
     */
    private void breakUp() 
    {
        //Greenfoot.playSound("Explosion.wav");
        
        if (size <= 16) {
            getWorld().removeObject(this);
        }
        else {
            int r = getVelocity().getDirection() + Greenfoot.getRandomNumber(45);
            double l = getVelocity().getLength();
            Vector speed1 = new Vector(r + 60, l * 1.2);
            Vector speed2 = new Vector(r - 60, l * 1.2);        
            Drone a1 = new Drone(size/2, speed1);
            Drone a2 = new Drone(size/2, speed2);
            getWorld().addObject(a1, getX(), getY());
            getWorld().addObject(a2, getX(), getY());        
            a1.move();
            a2.move();
        
            getWorld().removeObject(this);
        }
    }
}
