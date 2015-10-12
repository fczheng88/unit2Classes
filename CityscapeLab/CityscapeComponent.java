import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Point;
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
    
    MoonSun moonSun;
    GradientBackground background;
    Building building1;
    Building building2;
    Building building3;
    Building building4;
    Building building5;
    Building building6;
    
    TimeDisplay timeDisp;
    
    
    Road road;
    
    
    // define the CityscapeComponent contructor and intiailize all instance variables
    // ...
    public CityscapeComponent(int screenX, int screenY /*need more stuffs*/)
    {
        this.SCREEN_X = screenX;
        this.SCREEN_Y = screenY;
        moonSun = new MoonSun(SCREEN_X, SCREEN_Y);
        background = new GradientBackground(SCREEN_X, SCREEN_Y);
        building1 = new Building(3,2, SCREEN_X, SCREEN_Y);
        building2 = new Building(4,4, SCREEN_X, SCREEN_Y);
        building3 = new Building(5,6, SCREEN_X, SCREEN_Y);
        building4 = new Building(5,6, SCREEN_X, SCREEN_Y);
        building5 = new Building(4,4, SCREEN_X, SCREEN_Y);
        building6 = new Building(3,2, SCREEN_X, SCREEN_Y);
        road = new Road(SCREEN_X, SCREEN_Y);
        timeDisp = new TimeDisplay();
        //////////*****////////    
    }
    
    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     * @param g the graphics stuff
     *
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        // invoke the draw method on each object in your Cityscape
        // ...
                
        background.paintBackground(g2);
        moonSun.drawMoonSun(g2);
        building1.drawBuilding(g2, new Point(200, (int)(SCREEN_Y*3/4)));
        building2.drawBuilding(g2, new Point((int)building1.getLowerRight().getX()+SCREEN_X/136, (int)(SCREEN_Y*0.75)));
        building3.drawBuilding(g2, new Point((int)building2.getLowerRight().getX()+SCREEN_X/136, (int)(SCREEN_Y*0.75)));
        building4.drawBuilding(g2, new Point((int)building3.getLowerRight().getX()+SCREEN_X/136, (int)(SCREEN_Y*0.75)));
        building5.drawBuilding(g2, new Point((int)building4.getLowerRight().getX()+SCREEN_X/136, (int)(SCREEN_Y*0.75)));
        building6.drawBuilding(g2, new Point((int)building5.getLowerRight().getX()+SCREEN_X/136, (int)(SCREEN_Y*0.75)));
        
        timeDisp.drawTimeInSun(g2);
        road.drawRoad(g2);
    }
    
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when they are next drawn.
     *
     *@param currentTime all updates depend on the time kept by the currentTime object
     */
    public void nextFrame(TimeOfDay currentTime)
    {
        // update the objects in the cityscape so they are animated
        // ...
        moonSun.updateByTime(currentTime);
        background.updateByTime(currentTime);
        building1.updateByTime(currentTime);
        building2.updateByTime(currentTime);
        building3.updateByTime(currentTime);
        building4.updateByTime(currentTime);
        building5.updateByTime(currentTime);
        building6.updateByTime(currentTime);
        timeDisp.updateByTime(currentTime, moonSun);
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        repaint();
    }

}
