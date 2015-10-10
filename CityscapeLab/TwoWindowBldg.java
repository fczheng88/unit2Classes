import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Color;

/**
 * Write a description of class TwoWindowBldg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwoWindowBldg
{
    // instance variables - replace the example below with your own
    private int width, height, SCREEN_X, SCREEN_Y;
    private int windowWidth, windowHeight;
    private int buildWidth, buildHeight;
    
    /**
     * Constructor for objects of class TwoWindowBldg
     * 
     * @param int height the height of the building in windows
     */
    public TwoWindowBldg()
    {
        // initialise instance variables
        this.width = 2;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void makeRect(Color color, int cornerX, int cornerY, int width, int height, Graphics2D g2)
    {
        Rectangle rectangle = new Rectangle(cornerX, cornerY, width, height);
        System.out.println(rectangle.toString());
        g2.setPaint(color);
        g2.fill(rectangle);
        g2.draw(rectangle);
    }
    public int getBuildHeight()
    {
        return this.buildHeight;
    }
    public int getBuildWidth()
    {
        return this.buildWidth;
    }
    
    public void drawBuilding(Graphics2D g2, int height, int width, int screenX, int screenY)
    {
        //building width is 1/16 screen width and window width is 1/3 building width.
        //window height is 1/16 screen height and building height is bleh meh
        
        this.height = height;
        this.SCREEN_X=screenX;
        this.SCREEN_Y=screenY;
        
        int cornerX = screenX/2;
        int cornerY = screenY/2;
        
        int windowHeight = SCREEN_Y/32;
        int windowWidth = SCREEN_X/64;
        this.buildHeight = (int) ((windowHeight/3.0)+(height)*(windowHeight*5.0/3.0));
        this.buildWidth = (int) ((windowWidth/3.0)+(width)*(windowWidth*5.0/3.0));
        //building
        makeRect(Color.GRAY, cornerX, cornerY, buildWidth, buildHeight, g2);
        //windows
        for(int i=0; i < height;  i++)
        {
            
            for(int j=0; j<width; j++)
            {
                makeRect(Color.LIGHT_GRAY, (int) (cornerX+windowWidth/2+(j*windowWidth*5.0/3.0)), cornerY+(int) ((windowHeight/3)+(i*5.0/3.0*windowHeight)), windowWidth, windowHeight, g2);
            }
            
        }
        
    
    
    }
}
