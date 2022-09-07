import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.EmptyStackException;
/**
 * class CanvasUtil, this class updates the model and also updates the view
 * @author Dhananjay Saikumar
 */
class CanvasUtil {
    private View view;
    /**
     * CanvasUtil constructor.
     * @param view takes the view as the input.
     */
    public CanvasUtil (View view){
        this.view = view;
    }

    /**
     * adds a line to the canvas.
     * @param fill current fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     */
    public void addline(Boolean fill ,int start_x, int start_y, int end_x, int end_y) {
        view.undostack.push(new Line(view.currentColorObject,fill,start_x,start_y,end_x,end_y));
        view.frame.add(view.undostack.peek());
    }

    /**
     * adds a rectangle to the canvas.
     * @param fill current fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     * @param lock_aspect_ratio locks/unlocks aspect ratio.
     */
    public void addrectangle(Boolean fill ,int start_x, int start_y, int end_x, int end_y, Boolean lock_aspect_ratio){
        view.undostack.push(new Rectangle(view.currentColorObject,fill,start_x,start_y,end_x,end_y, lock_aspect_ratio));
        view.frame.add(view.undostack.peek());
    }

    /**
     * adds an ellipse to the canvas.
     * @param fill current fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     * @param ellip a circle is drawn if false.
     */
    public void addellipse(Boolean fill ,int start_x, int start_y, int end_x, int end_y, Boolean ellip){
        view.undostack.push(new Ellipse(view.currentColorObject, fill, start_x, start_y,end_x,end_y, ellip));
        view.frame.add(view.undostack.peek());
    }

    /**
     * adds a cross to the canvas.
     * @param fill current fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     */
    public void addcross(Boolean fill ,int start_x, int start_y, int end_x, int end_y){
        view.undostack.push(new Crosses(view.currentColorObject,fill,start_x,start_y,end_x,end_y));
        view.frame.add(view.undostack.peek());
    }

    /**
     * adds a triangle to the canvas.
     * @param fill current fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     */
    public void addtriangle(Boolean fill ,int start_x, int start_y, int end_x, int end_y){
        view.undostack.push(new Triangle(view.currentColorObject,fill,start_x,start_y,end_x,end_y));
        view.frame.add(view.undostack.peek());

    }

    /**
     * adds a parallelogram to the canvas.
     * @param fill current fill state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     */
    public void addParallelogram(Boolean fill ,int start_x, int start_y, int end_x, int end_y){
        view.undostack.push(new Parallelogram(view.currentColorObject,fill,start_x,start_y,end_x,end_y));
        view.frame.add(view.undostack.peek());
    }

    /**
     * Removes the last added object.
     */
    public void undoAction(){
        view.frame.remove(view.undostack.peek());
        view.redostack.push(view.undostack.peek());
        view.undostack.pop();
        }

    /**
     * Adds the last removed object.
     */
    public void redoAction(){
        view.undostack.push(view.redostack.peek());
        view.redostack.pop();
        view.frame.add(view.undostack.peek());
    }

    /**
     * clears the canvas.
     */
    public void clear(){
        Iterator<Shape> iter = view.undostack.iterator();
        while (iter.hasNext()){
            view.frame.remove(iter.next());
        }
        view.undostack.empty();
        view.redostack.empty();
    }

    /**
     * Changes color of all graphics objects/shapes.
     */
    public void changeStrokeColor(){
        if (view.currentColor.equals("Black")){
            view.currentColorObject = Color.black;
        }
        if (view.currentColor.equals("Green")){
            view.currentColorObject = Color.green;
        }
        if (view.currentColor.equals("Blue")){
              view.currentColorObject = Color.blue;
        }
        if (view.currentColor.equals("Red")){
            view.currentColorObject = Color.red;
        }
        if (view.currentColor.equals("Gray")){
            view.currentColorObject = Color.gray;
        }
    }

    /**
     * draws object/shape depending on the model's state.
     * @param start_x start position (x) of the vector drawing.
     * @param start_y start position (y) of the vector drawing.
     * @param end_x end position (x) of the vector drawing.
     * @param end_y end position (y) of the vector drawing.
     */
    public void drawObject(int start_x, int start_y, int end_x, int end_y){
        if (!view.shapeName.equals("none")){
        if (view.shapeName.equals("Line")){
            addline(view.fill, start_x, start_y,end_x,end_y);
        }
        else if (view.shapeName.equals("Rectangle")){
            addrectangle(view.fill, start_x, start_y,end_x,end_y,view.lock_aspect_ratio);
        }
        else if (view.shapeName.equals("Ellipse")){
            addellipse(view.fill, start_x, start_y,end_x, end_y, view.lock_aspect_ratio);
        }
        else if (view.shapeName.equals("Cross")){
            addcross(view.fill, start_x, start_y,end_x,end_y);
        }
        else if (view.shapeName.equals("Triangle")){
            addtriangle(view.fill, start_x, start_y,end_x,end_y);
        }
        else if (view.shapeName.equals("Parallelogram")){
            addParallelogram(view.fill, start_x, start_y,end_x,end_y);
        }
        view.model.setdrawDone();
        //System.out.println(view.model.getUndoStack().peek());
    }
    }
}
