import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PrimeNumbers extends JFrame
{
    private JPanel slider_panel, text_panel;
    private JLabel text, isprime;

    public PrimeNumbers()
    {
        // Include code from the prime numbers algorithm from before
        boolean myarray[];
        myarray = new boolean[1000];

        for(int a = 0; a < 1000; a++)
        {
            myarray[a] = true;
        }

        for(int i = 2; i <= 999; i++)
            if(i%i == 0 && i%1 == 0 && myarray[i] == true)
            {
                for (int j = 2; j < 500; j++)
                {
                    int multiples = i * j;

                    if(multiples < 1000)
                    {
                        myarray[multiples] = false;
                    }
                }
            }

        // add JFrame and close on exit
        JFrame frame = new JFrame("Prime Number Slider");
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        frame.getContentPane(); //get pane

        //Create the panel to place on the frame with the slider
        slider_panel = new JPanel();
        text_panel = new JPanel();

        //create the number keeping panel
        text = new JLabel("Number: 0");



        //Create Slider for the frame
        JSlider slider = new JSlider(SwingConstants.HORIZONTAL,0,999,1);
        slider.setMinorTickSpacing(1); // make it do each individual number
        slider.setMajorTickSpacing(100);// show major numbers in intervals of 100
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        //Set the slider to update the value each time that it is changed
        slider.addChangeListener(new ChangeListener(){
            public void stateChanged( ChangeEvent e)
            {
                // change up the text box each time the value is altered
                int value = slider.getValue();
                if(myarray[value] == false)
                {
                    text.setText("Number: "+ value + " " + "is not Prime");
                }
                else
                {
                    text.setText("Number: "+ value +" "+ "is Prime");
                }

            }
        });

        text_panel.add(text);

        // add the slider to the panel w a new grid layout
        slider_panel.setLayout(new GridLayout(1,2,2,2));
        slider_panel.add(slider);


        // add slider to frame
        frame.add(slider_panel,BorderLayout.CENTER);

        //add text frame to frame
        frame.add(text,BorderLayout.NORTH);

        //Make Frame visible
        frame.setSize(1200,600);
        frame.setVisible(true);


    }

    public static void main(String args[])
    {
        PrimeNumbers c = new PrimeNumbers();
        c.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }

        });
    }

}