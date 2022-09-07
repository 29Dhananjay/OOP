import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * class Parallelogram extends the abstract shape class.
 * @author 210034146
 */
public class Parallelogram extends Shape{
    /**
     * Parallelogram constructor.
     * @param color sets the color.
     * @param fill sets the fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     */
    public Parallelogram (Color color, Boolean fill,int start_x, int start_y, int end_x, int end_y){
      super(color,fill,start_x,start_y,end_x,end_y);
    }
    @Override
    /**
     * paintComponent.
     * @param g graphics.
     */
    public void paintComponent(Graphics g)
    {
      Graphics2D g2 = (Graphics2D) g;
      Path2D.Double parallelogram = new Path2D.Double();
      parallelogram.moveTo(start_x,start_y);
      parallelogram.lineTo(start_x+35,start_y-Math.abs(start_y-end_y));
      parallelogram.lineTo(start_x+Math.abs(start_x-end_x)+35,start_y-Math.abs(start_y-end_y));
      parallelogram.lineTo(start_x+Math.abs(start_x-end_x),start_y);
      parallelogram.lineTo(start_x,start_y);
      /*
      parallelogram.moveTo(350,120);
      parallelogram.lineTo(380,90);
      parallelogram.lineTo(580,90);
      parallelogram.lineTo(550,120);
      parallelogram.lineTo(350,120);
      */
      parallelogram.closePath();
      g2.setColor(color);
      if (fill == true){g2.fill(parallelogram);}
      else if (fill == false){g2.draw(parallelogram);}
    }
  }

