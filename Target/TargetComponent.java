import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
//import java.awt.Toolkit;
//import java.awt.Dimension;

/**
 * Draws a target
 * 
 * @author Felix Zheng
 * @version 1
 */
public class TargetComponent extends JComponent
{
    private double ctrX;
    private double ctrY;
    private double radius;
    public TargetComponent(double ctrX, double ctrY, double radius)
    {
        this.ctrX = ctrX;
        this.ctrY = ctrY;
        this.radius = radius;
    }
    public void paintComponent(Graphics g)
    {
 


        Graphics2D g2 = (Graphics2D) g;
        Target target = new Target(ctrX,ctrY,radius/2, 25);
        target.drawTarget(g2);
        
        
        Target target1 = new Target(ctrX/2+ctrX, ctrY/2, radius/4, 10);
        target1.drawTarget(g2);
        Target target2 = new Target(ctrX/2, ctrY/2+ctrY, radius/4, 15);
        target2.drawTarget(g2);
        Target target3 = new Target(ctrX/2, ctrY/2, radius/4, 20);
        target3.drawTarget(g2);
        Target target4 = new Target(ctrX/2+ctrX, ctrY/2+ctrY, radius/4, 25);
        target4.drawTarget(g2);
        
    
    }
}
