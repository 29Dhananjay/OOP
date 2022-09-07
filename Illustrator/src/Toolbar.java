import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * class Toolbar, contains all the buttons, and a drop down menu.
 * @author Dhananjay Saikumar
 */
class Toolbar extends JToolBar{
    private View view;
    /**
     * View Toolbar.
     * @param view takes the view as the input.
     */
    public Toolbar(View view){
        this.view = view;

        //Combobox to select different colors.
        String[] colorStrings = { "Gray", "Red", "Blue", "Green", "Black" };
        JComboBox<String> colorList = new JComboBox<>(colorStrings);
        colorList.setSelectedIndex(4);
        colorList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                view.model.setColor((String)cb.getSelectedItem());
                //System.out.println("currentColor: " + view.currentColor);
        }});

        //Combobox to select fill.
        String[] fillstrings = {"Fill", "NoFill"};
        JComboBox<String> fillList = new JComboBox<>(fillstrings);
        fillList.setSelectedIndex(1);
        fillList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String t = (String)cb.getSelectedItem();
                if (t.equals("Fill")){
                    //System.out.println("Fill Button pressed");
                    view.model.setFill(true);
                }
                else if (t.equals("NoFill")){
                    //System.out.println("NoFill Button pressed");
                    view.model.setFill(false);
                }
            }
        });
        // Menu, does nothing at the moment (fix it).
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Load");
        file.add(load);
        menu.add(file);
        view.frame.setJMenuBar(menu);

        // Undo button.
        JButton undobutton = new JButton("Undo");
        undobutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Undo Button pressed");
                view.util.undoAction();
                view.model.performUndo();
            }
        });

        // Redo button.
        JButton redobutton = new JButton("Redo");
        redobutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Redo Button pressed");
                view.util.redoAction();
                view.model.performRedo();
            }
        });

        // Line button: Changes current object/shape to Line.
        JButton linebutton = new JButton("Line");
        linebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Line Button pressed");
                view.model.setShape("Line");
        }});

        // Rectangle button: Changes current object/shape to Rectangle.
        JButton rectanglebutton = new JButton("Rectangle");
        rectanglebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Rectangle Button pressed");
                view.model.setShape("Rectangle");
            }
        });

        // Ellipse button: Changes current object/shape to Ellipse.
        JButton ellipsesbutton = new JButton("Ellipse");
        ellipsesbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Ellipses Button pressed");
                view.model.setShape("Ellipse");
            }
        });

        // Diagonal crosses button: Changes current object/shape to Diagonal crosses.
        JButton crossbutton = new JButton("Diagonal crosses");
        crossbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Diagonal crosses Button pressed");
                view.model.setShape("Cross");
            }
        });

        // Triangle button: Changes current object/shape to Triangle.
        JButton trianglebutton = new JButton("Triangle");
        trianglebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Triangle Button pressed");
                view.model.setShape("Triangle");
            }
        });


        // Parallelogram button: Changes current object/shape to Parallelogram.
        JButton parallelogrambutton = new JButton("Parallelogram");
        parallelogrambutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Parallelogram Button pressed");
                view.model.setShape("Parallelogram");
            }
        });

        // Clears the canvas
        JButton clearbutttonn = new JButton("Clear");
        clearbutttonn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Clear Button pressed");
                view.util.clear();
                view.model.performClear();
            }
        });

        this.add(new JLabel("Color"));
        this.add(colorList);
        this.add(new JLabel("Fill"));
        this.add(fillList);
        this.add(undobutton);
        this.add(redobutton);
        this.add(linebutton);
        this.add(rectanglebutton);
        this.add(ellipsesbutton);
        this.add(crossbutton);
        this.add(trianglebutton);
        this.add(parallelogrambutton);
        this.add(clearbutttonn);
    }
 }

