import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * class Rectangle extends the abstract shape class.
 * @author Dhananjay Saikumar
 */
public class Rectangle extends Shape{
    private Boolean lock_aspect_raio;
    /**
     * Rectangle constructor.
     * @param color sets the color.
     * @param fill sets the fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     * @param lock_aspect_raio aspect ratio lock, sqaure or rectangle.
     */
    public Rectangle (Color color, Boolean fill,int start_x, int start_y, int end_x, int end_y, Boolean lock_aspect_raio){
      super(color,fill,start_x,start_y,end_x,end_y);
      this.lock_aspect_raio = lock_aspect_raio;
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

      //if (fill == true){g2.fillRect(400, 200, 300, 80);}
      //else if (fill == false){g2.drawRect(400, 200, 300, 80);}

      if (lock_aspect_raio == false){
        if (fill == true){g2.fillRect(start_x, start_y, Math.abs(start_x-end_x), Math.abs(start_y-end_y));}
        else if (fill == false){g2.drawRect(start_x, start_y, Math.abs(start_x-end_x), Math.abs(start_y-end_y));}
        }

      else if (lock_aspect_raio == true){
        if (fill == true){g2.fillRect(start_x, start_y, Math.abs(start_x-end_x), Math.abs(start_x-end_x));}
        else if (fill == false){g2.drawRect(start_x, start_y, Math.abs(start_x-end_x), Math.abs(start_x-end_x));}
        }







    }
  }

