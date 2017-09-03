import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class imageoverlap extends JPanel{
    private JLayeredPane layeredPane;
    public imageoverlap(){

        //Create and set up the layered pane.
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 500));

        final ImageIcon icon = createImageIcon("scenery5.png");
        JLabel label = new JLabel(icon);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        Point origin = new Point(0, 0);
        int offset = 35;
        label.setBounds(origin.x, origin.y, 800, 500);
        layeredPane.add(label, new Integer(0));

        final ImageIcon icon2 = createImageIcon("boat12.png");
        JLabel label2 = new JLabel(icon2);
        label2.setVerticalAlignment(JLabel.TOP);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setOpaque(false);
        //decrease the value 450 to move the boat keeping all value fixed
        label2.setBounds(450, 265, 170, 70);
        layeredPane.add(label2, new Integer(3));

        final ImageIcon icon3 = createImageIcon("cannibal222.png");
        JLabel label3 = new JLabel(icon3);
        label3.setVerticalAlignment(JLabel.TOP);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setOpaque(false);
        label3.setBounds(700, 200, 140, 140);
        layeredPane.add(label3, new Integer(2));

        final ImageIcon icon4 = createImageIcon("cannibal222.png");
        JLabel label4 = new JLabel(icon4);
        label4.setVerticalAlignment(JLabel.TOP);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label4.setOpaque(false);
        label4.setBounds(665, 200, 140, 140);
        layeredPane.add(label4, new Integer(2));

        final ImageIcon icon5 = createImageIcon("cannibal222.png");
        JLabel label5 = new JLabel(icon5);
        label5.setVerticalAlignment(JLabel.TOP);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label5.setOpaque(false);
        label5.setBounds(690, 230, 140, 140);
        layeredPane.add(label5, new Integer(3));

        final ImageIcon icon6 = createImageIcon("missionary222.png");
        JLabel label6 = new JLabel(icon6);
        label6.setVerticalAlignment(JLabel.TOP);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label6.setOpaque(false);
        label6.setBounds(630, 200, 140, 140);
        layeredPane.add(label6, new Integer(2));

        final ImageIcon icon7 = createImageIcon("missionary222.png");
        JLabel label7 = new JLabel(icon7);
        label7.setVerticalAlignment(JLabel.TOP);
        label7.setHorizontalAlignment(JLabel.CENTER);
        label7.setOpaque(false);
        label7.setBounds(600, 215, 140, 140);
        layeredPane.add(label7, new Integer(2));

        final ImageIcon icon8 = createImageIcon("missionary222.png");
        JLabel label8 = new JLabel(icon8);
        label8.setVerticalAlignment(JLabel.TOP);
        label8.setHorizontalAlignment(JLabel.CENTER);
        label8.setOpaque(false);
        label8.setBounds(650, 227, 140, 140);
        layeredPane.add(label8, new Integer(3));

        add(layeredPane);
        label2.addMouseListener(new CustomMouseListener());
        label3.addMouseListener(new CustomMouseListener());
        label4.addMouseListener(new CustomMouseListener());
        label5.addMouseListener(new CustomMouseListener());
        label6.addMouseListener(new CustomMouseListener());
        label7.addMouseListener(new CustomMouseListener());
        label8.addMouseListener(new CustomMouseListener());
    }
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = imageoverlap.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    //MouseListener class
    class CustomMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //start animation of missionary or cannibal towards boat
            //start animation of missionary or cannibal towards land
            //start animation of boat from one point to another
        }
        @Override
        public void mousePressed(MouseEvent e) {
            //No use
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            //No use
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            //changing default cursor to hand cursor
            Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
//            label2.setCursor(cursor);
//            label3.setCursor(cursor);
//            label4.setCursor(cursor);
            //image can be replaced with another image showing selection
        }
        @Override
        public void mouseExited(MouseEvent e) {
            //image can be replaced with another image showing not selected
        }
    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("LayeredPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new imageoverlap();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
