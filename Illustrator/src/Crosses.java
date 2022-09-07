import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * class Crosses extends the abstract shape class.
 * @author 210034146
 */
public class Crosses extends Shape{
    /**
     * Crosses constructor.
     * @param color sets the color.
     * @param fill sets the fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     */
    public Crosses (Color color, Boolean fill,int start_x, int start_y, int end_x, int end_y){
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
      Path2D.Double cross = new Path2D.Double();
      cross.moveTo(start_x,start_y);
      //cross.lineTo(350,360);
      float ratio_x =  Math.abs(start_x-end_x)/10;
      float ratio_y = ratio_x;
      cross.lineTo(start_x+1*ratio_x,start_y-1*ratio_y);
      cross.lineTo(start_x+5*ratio_x,start_y+3*ratio_y);
      cross.lineTo(start_x+9*ratio_x,start_y-1*ratio_y);
      cross.lineTo(start_x+10*ratio_x,start_y);
      cross.lineTo(start_x+6*ratio_x,start_y+4*ratio_y);
      cross.lineTo(start_x+10*ratio_x,start_y+8*ratio_y);
      cross.lineTo(start_x+9*ratio_x,start_y+9*ratio_y);
      cross.lineTo(start_x+5*ratio_x,start_y+5*ratio_y);
      cross.lineTo(start_x+1*ratio_x,start_y+9*ratio_y);
      cross.lineTo(start_x,start_y+8*ratio_y);
      cross.lineTo(start_x+4*ratio_x,start_y+4*ratio_y);
      cross.lineTo(start_x,start_y);
      /*
      cross.moveTo(350,360);
      cross.lineTo(360,350);
      cross.lineTo(400,390);

      cross.lineTo(440,350);
      cross.lineTo(450,360);
      cross.lineTo(410,400);
      cross.lineTo(450,440);
      cross.lineTo(440,450);
      cross.lineTo(400,410);
      cross.lineTo(360,450);
      cross.lineTo(350,440);
      cross.lineTo(390,400);
      cross.lineTo(350,360);
      */
      cross.closePath();
      g2.setColor(color);
      if (fill == true){g2.fill(cross);}
      else if (fill == false){g2.draw(cross);}
    }
  }

