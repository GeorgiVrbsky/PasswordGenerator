import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider extends JSlider {

   private Frame frame;

    public  Slider(Frame frame,int min, int max, int value) {
        super(min, max, value);
        this.frame = frame;
        setPaintTicks(true);
        setPaintLabels(true);
        setBounds(25,300,200,50);

        addChangeListener(e -> {
          int sliderValue = Slider.this.getValue();
          frame.updateSliderValue(sliderValue);
      });
    }




}


