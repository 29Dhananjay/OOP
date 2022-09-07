import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * class Ellipse extends the abstract shape class.
 * @author Dhananjay Saikumar
 */
public class Ellipse extends Shape{
    private Boolean lock_aspect_raio;
    /**
     * Ellipse constructor.
     * @param color sets the color.
     * @param fill sets the fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     * @param lock_aspect_raio aspect ratio sqaure or rectangle.
     */
    public Ellipse (Color color, Boolean fill, int start_x, int start_y, int end_x, int end_y, Boolean lock_aspect_raio){
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
        if (lock_aspect_raio == false){

          if (fill == true){g2.fill(new Ellipse2D.Double(start_x, start_y, Math.abs(start_x-end_x), Math.abs(start_y-end_y)));}
          else if (fill == false){g2.draw(new Ellipse2D.Double(start_x, start_y, Math.abs(start_x-end_x), Math.abs(start_y-end_y)));}}

        else if (lock_aspect_raio == true){
          if (fill == true){g2.fill(new Ellipse2D.Double(start_x, start_y, Math.abs(start_x-end_x), Math.abs(start_x-end_x)));}
          else if (fill == false){g2.draw(new Ellipse2D.Double(start_x, start_y, Math.abs(start_x-end_x), Math.abs(start_x-end_x)));}}
          /*
          if (fill == true){g2.fill(new Ellipse2D.Double(100, 50, 250, 50));}
          else if (fill == false){g2.draw(new Ellipse2D.Double(100, 50, 250, 50));}}

        else if (ellipse == false){
          if (fill == true){g2.fill(new Ellipse2D.Double(200, 400, 100, 100));}
          else if (fill == false){g2.draw(new Ellipse2D.Double(200, 400, 100, 100));}}
          */
      }
    }


