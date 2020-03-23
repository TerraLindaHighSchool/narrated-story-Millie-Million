import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instantiates stars and draws them to the world
 * 
 * @author Bruce Gustin
 * @version 3/15/2020 v1
 */
public class Space extends World
{
    private Star[] stars = new Star[210];
    Color color1 = new Color(123,230,30);
    Color color2 = new Color(123,150,230);
    Color color3 = new Color(123,50,200);

    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        GreenfootImage image = getBackground();
        image.setColor(Color.BLACK);
        image.fill();
        star();
    }
    
    private void star()
    {
        for(int i = 0; i < 210; i++){
             Star star;
             int deltaSpeed = Greenfoot.getRandomNumber(2);
             
             if(i < 70)
             {
                //star = new Star(-1 - deltaSpeed, color1, getWidth(), getHeight());
                //addObject(star, star.getX(), star.getY());
                //stars[i] = star;
             }
             
             if(i >= 70 && i < 140)
             {
                //star = new Star(-3 - deltaSpeed, color2, getWidth(), getHeight());
                //addObject(star, star.getX(), star.getY());
                //stars[i] = star;
             }
             
             if(i >= 140)
             {
                //star = new Star(-5 - deltaSpeed, color3, getWidth(), getHeight());
                //addObject(star, star.getX(), star.getY());
                //stars[i] = star;
             }
         }
    }
    
    public void act()
    {
            for(int i = 0; i < 210; i++)
            {
                if(stars[i] != null)
                {
                    stars[i].move();
                }
            }
    }
}
