import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.GradientPaint;

public class GradientBackground
{
    private Color color1, color2;
    private int SCREEN_X, SCREEN_Y;
    
    public GradientBackground( int screenX, int screenY)
    {        
        SCREEN_X = screenX;
        SCREEN_Y = screenY;
        color1 = Color.RED;
        color2 = Color.BLUE;
    }
    public void paintBackground(Graphics2D g2)
    {
        
        
        
        Rectangle background = new Rectangle(0,0,SCREEN_X, SCREEN_Y*3/4);
        g2.setPaint(new GradientPaint(SCREEN_X/2 ,0, color1, SCREEN_X/2, SCREEN_Y/2, color2));
        
        g2.fill(background);
        g2.draw(background);
        
    }
    public void updateByTime(TimeOfDay currentTime)
    {
        color1 = Color.RED;
        color2 = Color.BLUE;
    }

}