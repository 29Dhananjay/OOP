import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * class Line extends the abstract shape class.
 * @author 210034146
 */
public class Line extends Shape{
    /**
     * Line constructor.
     * @param color sets the color.
     * @param fill sets the fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     */
    public Line (Color color, Boolean fill, int start_x, int start_y, int end_x, int end_y){
        super(color, fill,start_x,start_y,end_x, end_y);
    }
    @Override
    /**
     * paintComponent.
     * @param g graphics.
     */
    public void paintComponent(Graphics g)
    {
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(color);
      g2.draw(new Line2D.Double(start_x, start_y, end_x, end_y));
      //g2.draw(new Line2D.Double(x, y, x, y + 150));
      //g2.draw(new Line2D.Double(50, 50, 150, 600));
    }
  }

