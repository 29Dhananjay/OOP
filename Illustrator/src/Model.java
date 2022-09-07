import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * class Model, contains properties such as shape, color, fill, objectstack.
 * @author Dhananjay Saikumar
 */
class Model{
    // adds listeners to the model
    public interface Listener {
        void update();
    }
    private String color = "Black";
    private String shape = "none";
    private Boolean fill = false;
    // Stack which contains added graphic objects (enabling the undo method)
    private Stack<String> undostack = new Stack<>();
    // Stack which contains removed graphic objects (removed by undo, enabling the redo method)
    private Stack<String> redostack = new Stack<>();

    // A list of listeners
    private List<View> listeners;

    /**
     * Model constructor.
     */
    public Model() {
        listeners = new ArrayList<View>();
    }

    public void addListener(View listener) {
        listeners.add(listener);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        changed();
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
        changed();
    }

    public Boolean getFill() {
        return fill;
    }
    // Sets fill (if user selects to draw filled shapes)
    public void setFill(Boolean fill) {
        this.fill = fill;
        changed();
    }

    public void performUndo() {
        redostack.push(undostack.peek());
        undostack.pop();
        changed();
    }

    public void performRedo() {
        undostack.push(redostack.peek());
        redostack.pop();
        changed();
    }

    public void performClear() {
        undostack.clear();
        redostack.clear();
        changed();
    }

    public void setdrawDone() {
        undostack.push("Shape: " + shape + ", " + "Color: " + color + ", " + "Fill: " + fill);
        changed();
    }

    public Stack<String> getUndoStack() {
        return undostack;
    }

    // Updates all the listeners
    private void changed() {
        for (View listener : listeners) {
            listener.update();
        }
    }
}
