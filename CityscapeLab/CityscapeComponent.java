import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class CityscapeComponent extends JComponent
{
    private int SCREEN_X, SCREEN_Y;
    // define the objects in your Cityscape as instance variables
    // ...
    MoonSun moonSun = new MoonSun();
    GradientBackground background = new GradientBackground();
    
    // define the CityscapeComponent contructor and intiailize all instance variables
    // ...
    public CityscapeComponent(int screenX, int screenY /*need more stuffs*/)
    {
        this.SCREEN_X = screenX;
        this.SCREEN_Y = screenY;
        
        //////////*****////////    
    }
    
    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     *
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        // invoke the draw method on each object in your Cityscape
        // ...
        
        
        
        background.paintBackground(g2, Color.BLUE, Color.RED, SCREEN_X, SCREEN_Y);
        moonSun.drawMoonSun(g2, SCREEN_X, SCREEN_Y);
    }
    
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when they are next drawn.
     *
     */
    public void nextFrame(int seconds)
    {
        // update the objects in the cityscape so they are animated
        // ...
        moonSun.updateMoonSun();//seconds);
        
        
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        repaint();
    }

}
