import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;


/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class CityscapeViewer
{
    // the cityscape will be animated for 60 seconds
    static final int ANIMATION_TIME_IN_SECONDS = 6000;
    static final Dimension SCREEN_DIM = Toolkit.getDefaultToolkit().getScreenSize();
    
    static final int SCREEN_X = (int) SCREEN_DIM.getWidth();
    static final int SCREEN_Y = (int) SCREEN_DIM.getHeight();
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    public static void main(String[] args) throws InterruptedException
    {
        // create and configure the frame (window) for the program
        
        
        
        JFrame frame = new JFrame();
        System.out.println(SCREEN_X + SCREEN_Y);
        frame.setSize(SCREEN_X /* x */, SCREEN_Y /* y */);
        frame.setTitle("Cityscape");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // use the Scanner class to prompt the user for some configurable aspect of the cityscape
        // ...
        
        
        
        // a frame contains a single component; create the Cityscape component and add it to the frame
        CityscapeComponent component = new CityscapeComponent( /* pass the user-specified value */ SCREEN_X, SCREEN_Y);
        frame.add(component);
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // animate the cityscape
        for( int seconds = 0; seconds < ANIMATION_TIME_IN_SECONDS; seconds++ )
        {
            component.nextFrame(seconds);
            Thread.sleep( 50 );
        }
        
    }

}
