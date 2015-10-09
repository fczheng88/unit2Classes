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
    public GradientBackground()
    {        
    }
    public void paintBackground(Graphics2D g2, Color color1, Color color2, int screenX, int screenY)
    {
        this.color1 = color1;
        this.color2 = color2;
        this.SCREEN_X = screenX;
        this.SCREEN_Y = screenY;
        
        Rectangle background = new Rectangle(0,0,SCREEN_X, SCREEN_Y);
        g2.setPaint(new GradientPaint(SCREEN_X/2 ,0, color1, SCREEN_X/2, SCREEN_Y/2, color2));
        
        g2.fill(background);
        g2.draw(background);
        
    }


}