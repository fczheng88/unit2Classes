import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.GradientPaint;
/**
 * Creates the background using GradientPaint
 * 
 * @author Felix Zheng 
 * @version 1
 */
public class GradientBackground
{
    private Color color1, color2;
    private int SCREEN_X, SCREEN_Y;
    /**
     * Constructor
     * 
     * @param screenX The width of the frame/screen
     * @param screenY The height of the frame/screen
     */
    public GradientBackground( int screenX, int screenY)
    {        
        SCREEN_X = screenX;
        SCREEN_Y = screenY;
        color1 = Color.BLUE;
        color2 = Color.RED;
    }
    /**
     * Paint the gradient background
     * 
     * @param g2 The graphics object for painting/drawing
     */
    
    public void draw(Graphics2D g2)
    {
        
        
        
        Rectangle background = new Rectangle(0,0,SCREEN_X, SCREEN_Y*3/4);
        g2.setPaint(new GradientPaint(SCREEN_X/2 ,0, color1, SCREEN_X/2, SCREEN_Y/2, color2));
        
        g2.fill(background);
        g2.draw(background);
        
    }
    /**
     * Updates the background for repaint() based on day/night.
     * @param currentTime The time object needed to call certain methods on for proper updating.
     * 
     */
    public void updateByTime(TimeOfDay currentTime)
    {
        //         /*--------------- Failed first attempt at sunrise/set, please ignore----------------------
        //         //sun rising
        //         if(currentTime.getHour()>currentTime.getRiseSet(true)&&currentTime.getHour()<=currentTime.getRiseSet(true)+3)
        //         {
        //             color1 = Color.BLUE.brighter().brighter().brighter();
        //             color2 = new Color(color2.getRed()-1, 0, color2.getBlue()+1);
        //         }
        //         //sun setting
        //         else if(currentTime.getHour()>=currentTime.getRiseSet(false)-3 && currentTime.getHour()<=currentTime.getRiseSet(false))
        //         {
        //             color1 = Color.BLUE;
        //             color2 = new Color(color2.getRed()+1,  0, color2.getBlue()- 1);
        //         }
        //         //presunrise sun rising
        //         else if(currentTime.getHour()<currentTime.getRiseSet(true)&&currentTime.getHour()>=currentTime.getRiseSet(true)-3)
        //         {
        //             color1 = Color.BLACK;
        //             color2 = new Color(color2.getRed()+1, 0, color2.getBlue()-1);
        //         }
        //         //postsunset sun setting
        //         else if(currentTime.getHour()<=currentTime.getRiseSet(false)+3 && currentTime.getHour()>=currentTime.getRiseSet(false))
        //         {
        //             color1 = Color.BLACK;
        //             color2 = new Color(color2.getRed()-1,  0, color2.getBlue()- 1);
        //         }
        //         //night
        //         else ----------------------------see message above-------------------*/
        if(currentTime.getHour()<currentTime.getRiseSet(true) || currentTime.getHour()>=currentTime.getRiseSet(false))
        {//night
            color1 = new Color(25,25,112);
            color2 = color1.darker().darker().darker().darker();
        }
        //day
        else
        {
            color1 = new Color(135, 206, 250) ;
            color2 = color1.brighter().brighter().brighter();
        }
                
    }

}