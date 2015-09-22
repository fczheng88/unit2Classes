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
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Target target = new Target(0,0,5.0);
        target.draw(g2);
    }
}
