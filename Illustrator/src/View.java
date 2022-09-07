import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.EmptyStackException;

/**
 * class view @ GUI implimentation.
 * @author Dhananjay Saikumar
 */
class View {
    protected Model model;
    protected JFrame frame = new JFrame();
    protected JPanel toolbarPanel = new JPanel();
    // Stack which contains added graphic objects (enabling the undo method)
    protected Stack<Shape> undostack = new Stack<>();
    // Stack which contains removed graphic objects (removed by undo, enabling the redo method)
    protected Stack<Shape> redostack = new Stack<>();
    protected String currentColor = "Black";
    protected String shapeName = "none";
    protected Color currentColorObject = Color.black;
    protected Boolean fill = false;
    protected CanvasUtil util = new CanvasUtil(this);
    // start position_x (draw object)
    protected int start_x = 0;
    // start position_y (draw object)
    protected int start_y = 0;
    protected Boolean lock_aspect_ratio = false;
    private Boolean setVisible = true;

    /**
     * View constructor.
     * @param model takes the model as the input.
     */
    public View(Model model, Boolean setVisible) {
        this.model = model;
        this.setVisible = setVisible;
        model.addListener(this);

        frame.setLayout(new BorderLayout());
        // panel for the toolbar.
        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);

        frame.add(panel, BorderLayout.NORTH);
        // toolbar object is added to the panel.
        JToolBar jtb = new Toolbar(this);
        panel.add(jtb);

        //adding a MouseListener to the frame which records the start point of a drawing
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                start_x = e.getX();
                start_y = e.getY() -92 ;
                //system.out.println("mousepressed: " + e.getX() + " " + e.getY());
             }
        });

        //adding a MouseListener to the frame which records the end point of a drawing
        frame.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                //system.out.println("mouseReleased: " + e.getX() + " " + e.getY());
                if (start_x > e.getX() || start_y > e.getY() - 92) {
                    util.drawObject(e.getX(), e.getY() - 92, start_x, start_y);
                }
                else if (start_x < e.getX() || start_y < e.getY() - 92) {
                    util.drawObject(start_x, start_y, e.getX(), e.getY() - 92);
                }

             }
        });

        // Locks aspect ratio if key 'a' is clicked, and unlocks aspect ratio if the shift key is pressed.
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == 65){
                    lock_aspect_ratio = true;
                    //system.out.println("a" + lock_aspect_ratio);
            }
                else if (e.getKeyCode() == KeyEvent.VK_SHIFT){
                    lock_aspect_ratio = false;
                    //system.out.println("Shift" + lock_aspect_ratio);
            }
            return true;
        }
        });

        frame.setSize(1000,700);
        frame.setVisible(setVisible);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void update(){
        // update color
        currentColor = model.getColor();
        // update shape
        shapeName = model.getShape();
        // update fill
        fill = model.getFill();
        // changes the color for all graphics object
        util.changeStrokeColor();
        frame.validate();
        frame.repaint();
    }
}
