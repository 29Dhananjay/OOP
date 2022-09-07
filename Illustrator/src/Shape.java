import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Abstract class shape.
 * @author 210034146
 */
public class Shape extends JComponent{
    protected Color color;
    protected Boolean fill;
    protected int start_x;
    protected int start_y;
    protected int end_x;
    protected int end_y;
    /**
     * Shape constructor.
     * @param color sets the color.
     * @param fill sets the fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     */
    public Shape(Color color, Boolean fill, int start_x, int start_y, int end_x, int end_y){
      this.color = color;
      this.fill = fill;
      this.start_x = start_x;
      this.start_y = start_y;
      this.end_x = end_x;
      this.end_y = end_y;

    }
    /**
     * paintComponent.
     * @param g graphics.
     */
    public void paintComponent(Graphics g){}
  }
