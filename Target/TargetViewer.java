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
    
        int screenX = (int) screensize.getWidth();
        int screenY = (int) screensize.getHeight();
        
        
        JFrame frame = new JFrame();
        frame.setSize(screenX-60, screenY-60);
        frame.setTitle("Target!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        TargetComponent component = new TargetComponent();
        frame.add(component);
        
        frame.setVisible(true);
    
    
    }
}
