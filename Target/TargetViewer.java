import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;


/**
 * Paints the Target
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TargetViewer
{
    // instance variables - replace the example below with your own
    
    public static void main(String[] args)
    {
        
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    
        double screenX =  screensize.getWidth();
        double screenY =  screensize.getHeight();
        
        double ctrX = screenX/2;
        double ctrY = (screenY-60)/2;
        double radius = (screenY-60);
    
        
        JFrame frame = new JFrame();
        frame.setSize((int) screenX, (int) screenY-60);
        frame.setTitle("Target!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        TargetComponent component = new TargetComponent(ctrX, ctrY, radius);
        frame.add(component);
        
        
        
        frame.setVisible(true);
    
    
    }
}
