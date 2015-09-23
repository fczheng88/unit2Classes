import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;


/**
 * Draws a target
 * 
 * @author Felix Zheng
 * @version 1
 */
public class TargetComponent extends JComponent
{
    private double screenX;
    private double screenY;
    public TargetComponent(double screenX, double screenY)
    {
        this.screenX = screenX;
        this.screenY = screenY;
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Target target = new Target(screenX/2,(screenY-60)/2,(screenY-60)/2);
        target.draw(g2);
    }
}
