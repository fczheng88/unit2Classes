import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.Scanner;


/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class CityscapeViewer
{ 
    // the cityscape will be animated for 60 seconds
    static final int ANIMATION_TIME_IN_SECONDS = 60000000;
    static final Dimension SCREEN_DIM = Toolkit.getDefaultToolkit().getScreenSize();
    
    static final int SCREEN_X = (int) SCREEN_DIM.getWidth();
    static final int SCREEN_Y = (int) SCREEN_DIM.getHeight();
    private static TimeOfDay currentTime = new TimeOfDay();
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    
    public static void main(String[] args) throws InterruptedException
    {
        // create and configure the frame (window) for the program
        
        
        JFrame frame = new JFrame();
        
        frame.setSize(SCREEN_X /* x */, SCREEN_Y /* y */);
        frame.setTitle("Cityscape");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // use the Scanner class to prompt the user for some configurable aspect of the cityscape
        // ...
        
        int sleepTime=-1;
        
        Scanner s = new Scanner(System.in);
        while(sleepTime == -1)
        {
            System.out.print("\n\nPlease select the speed of the animation - \ninput F for fast, M for medium, and S for slow: ");
            String opt = s.next();
            
           
            
            if(opt.toLowerCase().equals("s"))
            {
                sleepTime =  100;
            }
            else if(opt.toLowerCase().equals("m"))
            {
                sleepTime =  50;
            }
            else if(opt.toLowerCase().equals("f"))
            {
                sleepTime =  10;
            }
            else
            {
                System.out.println("\nu is fael. proegrim wil fael.\nTRY AGIN PLS\n");
                
            }
        }
        
        // a frame contains a single component; create the Cityscape component and add it to the frame
        CityscapeComponent component = new CityscapeComponent( /* pass the user-specified value */ SCREEN_X, SCREEN_Y);
        frame.add(component);
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // animate the cityscape
        while(true)//( int seconds = 0; seconds < ANIMATION_TIME_IN_SECONDS; seconds++ )
        {
            currentTime.addMinute();
            component.nextFrame(currentTime);
            Thread.sleep( sleepTime );
        }
        
    }

}
