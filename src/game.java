import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class game extends JFrame{
    public JFrame frame;
    public ImageIcon image1;
    public JLabel label1;
    private ImageIcon image2;
    private JLabel label2;
    public JPanel panel;
    public ImageIcon image3;
    public JLabel label3;
    public ImageIcon image4;
    public JLabel label4;


    game(){

        image1 = new ImageIcon(getClass().getResource("boat12.png"));
        label1 = new JLabel(image1);
        image2 = new ImageIcon(getClass().getResource("scenery5.png"));
        label2 = new JLabel(image2);
        image3 = new ImageIcon(getClass().getResource("cannibal222.png"));
        label3 = new JLabel(image3);
        image4 = new ImageIcon(getClass().getResource("missionary222.png"));
        label4 = new JLabel(image4);
//        label4.setBounds(10, 50, 60, 20);
//        label4.setBounds(15, 225,
//                image4.getIconWidth(),
//                image4.getIconHeight());
//        label1.setHorizontalAlignment(JLabel.RIGHT);


//        panel = new JPanel(){
//            @Override
//            public boolean isOptimizedDrawingEnabled() {
//                return false;
//            }
//        };
        panel = new JPanel();
        LayoutManager overlay = new OverlayLayout(panel);
        panel.setLayout(overlay);

        panel.add(label4);
        panel.add(label3);
        panel.add(label1);
        panel.add(label2);

        frame = new JFrame();
        frame.add(panel);
        frame.setSize(800,500);
        frame.setVisible(true);
        frame.setTitle("Missionaries-and-Cannibals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //WindowListener interface is used for receiving the window events.
        //WindowAdapter is an abstract adapter class for receiving window events.
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        //label used for MouseListener
        label4.addMouseListener(new CustomMouseListener());
        label3.addMouseListener(new CustomMouseListener());
        label1.addMouseListener(new CustomMouseListener());
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
            label4.setCursor(cursor);
            label3.setCursor(cursor);
            label1.setCursor(cursor);
            //image can be replaced with another image showing selection
        }
        @Override
        public void mouseExited(MouseEvent e) {
            //image can be replaced with another image showing not selected
        }
    }

    public static void main(String[] args) {
        game gui = new game();
    }
}