import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * class Triangle extends the abstract shape class.
 * @author 210034146
 */
public class Triangle extends Shape{
    /**
     * Triangle constructor.
     * @param color sets the color.
     * @param fill sets the fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     */
    public Triangle (Color color, Boolean fill,int start_x, int start_y, int end_x, int end_y){
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
      Path2D.Double triangle = new Path2D.Double();
      triangle.moveTo(start_x,start_y);
      triangle.lineTo(start_x-Math.abs(start_x-end_x),start_y);
      triangle.lineTo(start_x,start_y-Math.abs(start_y-end_y));
      triangle.lineTo(start_x+Math.abs(start_x-end_x),start_y);
      triangle.lineTo(start_x,start_y);
      /*
      triangle.moveTo(550,550);
      triangle.lineTo(500,550);
      triangle.lineTo(550,400);
      triangle.lineTo(600,550);
      triangle.lineTo(550,550);
      */
      triangle.closePath();
      g2.setColor(color);
      if (fill == true){g2.fill(triangle);}
      else if (fill == false){g2.draw(triangle);}
    }
  }

