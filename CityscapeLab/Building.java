import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Color;
import java.util.Random;
import java.util.Arrays;

/**
 * Write a description of class TwoWindowBldg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Building
{
    // instance variables - replace the example below with your own
    private int numWinAcross, numWinDown;
    private int windowWidth, windowHeight;
    private int buildWidth, buildHeight;
    private Point lowerLeft;
    private int windowI, windowJ;
    private int[][] windowLighting;
    private int firstRun = 1;
    private int SCREEN_X, SCREEN_Y;
    
    /**
     * Constructor for objects of class TwoWindowBldg
     * 
     * @param int height the height of the building in windows
     */
    public Building(int numWinAcross, int numWinDown,int scrX, int scrY)
    {
        // initialise instance variables
        this.numWinAcross = numWinAcross;
        this.numWinDown = numWinDown;
        this.SCREEN_X = scrX;
        this.SCREEN_Y = scrY;
        windowLighting = new int[numWinDown][numWinAcross];
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
        
        g2.setPaint(color);
        g2.fill(rectangle);
        g2.draw(rectangle);
    }
    public Point getLowerRight()
    {
        return new Point((int)lowerLeft.getX()+buildWidth, (int) lowerLeft.getY());
    }
    public void drawBuilding(Graphics2D g2, Point lowerLeft)
    {
        //building width is 1/16 screen width and window width is 1/3 building width.
        //window height is 1/16 screen height and building height is bleh meh
        
        
        this.lowerLeft = lowerLeft;
        
        
        int windowHeight = SCREEN_Y/32;
        int windowWidth = SCREEN_X/64;
        this.buildHeight = (int) ((windowHeight/3.0)+(numWinDown)*(windowHeight*5.0/3.0));
        this.buildWidth = (int) ((windowWidth/3.0)+(numWinAcross)*(windowWidth*5.0/3.0));
        int cornerX = (int) lowerLeft.getX();
        int cornerY = (int) lowerLeft.getY()-buildHeight;
        //building
        makeRect(Color.GRAY, cornerX, cornerY, buildWidth, buildHeight, g2);
        //windows
        
        for(int i=0; i < numWinDown;  i++)
        {
            
            for(int j=0; j<numWinAcross; j++)
            {
                
                if(windowLighting[i][j] == 2)
                {
                    makeRect(Color.YELLOW, (int) (cornerX+windowWidth/2+(j*windowWidth*5.0/3.0)), cornerY+(int) ((windowHeight/3)+(i*5.0/3.0*windowHeight)), windowWidth, windowHeight, g2);
                }
                else if(windowLighting[i][j] == 1)
                {
                    makeRect(Color.LIGHT_GRAY, (int) (cornerX+windowWidth/2+(j*windowWidth*5.0/3.0)), cornerY+(int) ((windowHeight/3)+(i*5.0/3.0*windowHeight)), windowWidth, windowHeight, g2);
                }
                else
                {
                    makeRect(Color.BLACK, (int) (cornerX+windowWidth/2+(j*windowWidth*5.0/3.0)), cornerY+(int) ((windowHeight/3)+(i*5.0/3.0*windowHeight)), windowWidth, windowHeight, g2);
                }
            }
            
        }
        
    
    
    }
    public void updateByTime(TimeOfDay currentTime)
    {
        if(currentTime.isSwitchedDayNight())
        {
            Random rnd = new Random();
            for(int i=0; i < numWinDown; i++)
            {
                for(int j=0; j<numWinAcross; j++)
                {
                    if(rnd.nextInt(2) == 1 && currentTime.isNight())
                    {
                        //Lit/Yellow = 2
                        windowLighting[i][j]=2;
                        
                    }
                    else if(currentTime.isDay())
                    {
                        //gray = 1
                        windowLighting[i][j]=1;
                        
                    }
                    else
                    {
                        //Black = 0
                        windowLighting[i][j]=0;
                        
                    }
                }
            }
        
            firstRun=0;
        }
    }
}
