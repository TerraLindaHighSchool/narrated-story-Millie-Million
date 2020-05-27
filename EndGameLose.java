import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndGameLose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGameLose extends World
{

    /**
     * Constructor for objects of class EndGameLose.
     * 
     */
    public EndGameLose()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        GreenfootImage image = getBackground();
        image.setColor(Color.BLACK);
        image.fill();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GameLose gameLose = new GameLose();
        addObject(gameLose,300,200);
    }
}
