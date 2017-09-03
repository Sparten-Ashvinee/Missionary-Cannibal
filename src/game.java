import java.awt.*;
import javax.swing.*;

public class game extends JFrame{
    private final JFrame frame;
    private final ImageIcon image1;
    private final JLabel label1;
    private final ImageIcon image2;
    private final JLabel label2;
    private final JPanel panel;
    private final ImageIcon image3;
    private final JLabel label3;
    private final ImageIcon image4;
    private final JLabel label4;

    game(){

        image1 = new ImageIcon("boat222.png");
        label1 = new JLabel(image1);
        image2 = new ImageIcon(getClass().getResource("scenery5.png"));
        label2 = new JLabel(image2);
        image3 = new ImageIcon(getClass().getResource("cannibal222.png"));
        label3 = new JLabel(image3);
        image4 = new ImageIcon(getClass().getResource("missionary222.png"));
        label4 = new JLabel(image4);
        label4.setBounds(10, 50, 60, 20);
        //label1.setHorizontalAlignment(JLabel.RIGHT);
        panel = new JPanel(){
            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
        };

        LayoutManager overlay = new OverlayLayout(panel);
        panel.setLayout(overlay);

        panel.add(label4);
        panel.add(label3);
        panel.add(label1);
        panel.add(label2);
        frame = new JFrame();
        frame.add(panel,BorderLayout.WEST);
        frame.setSize(800,500);
        frame.setVisible(true);
        frame.setTitle("Missionaries-and-Cannibals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        game gui = new game();
    }
}