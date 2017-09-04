import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class imageoverlap extends JPanel{
    private JLayeredPane layeredPane;
    public JLabel label;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    public imageoverlap(){
        //Create and set up the layered pane.
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 500));

        final ImageIcon icon = createImageIcon("scenery5.png");
        label = new JLabel(icon);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        Point origin = new Point(0, 0);
        int offset = 35;
        label.setBounds(origin.x, origin.y, 800, 500);
        layeredPane.add(label, new Integer(0));

        final ImageIcon icon2 = createImageIcon("boat12.png");
        label2 = new JLabel(icon2);
        label2.setVerticalAlignment(JLabel.TOP);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setOpaque(false);
        label2.setBounds(450, 265, 170, 70);
        layeredPane.add(label2, new Integer(3));

        final ImageIcon icon3 = createImageIcon("cannibal222.png");
        label3 = new JLabel(icon3);
        label3.setVerticalAlignment(JLabel.TOP);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setOpaque(false);
        label3.setBounds(700, 200, 140, 140);
        layeredPane.add(label3, new Integer(2));

        final ImageIcon icon4 = createImageIcon("cannibal222.png");
        label4 = new JLabel(icon4);
        label4.setVerticalAlignment(JLabel.TOP);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label4.setOpaque(false);
        label4.setBounds(665, 200, 140, 140);
        layeredPane.add(label4, new Integer(2));

        final ImageIcon icon5 = createImageIcon("cannibal222.png");
        label5 = new JLabel(icon5);
        label5.setVerticalAlignment(JLabel.TOP);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label5.setOpaque(false);
        label5.setBounds(690, 230, 140, 140);
        layeredPane.add(label5, new Integer(3));

        final ImageIcon icon6 = createImageIcon("missionary222.png");
        label6 = new JLabel(icon6);
        label6.setVerticalAlignment(JLabel.TOP);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label6.setOpaque(false);
        label6.setBounds(630, 200, 140, 140);
        layeredPane.add(label6, new Integer(2));

        final ImageIcon icon7 = createImageIcon("missionary222.png");
        label7 = new JLabel(icon7);
        label7.setVerticalAlignment(JLabel.TOP);
        label7.setHorizontalAlignment(JLabel.CENTER);
        label7.setOpaque(false);
        label7.setBounds(600, 215, 140, 140);
        layeredPane.add(label7, new Integer(2));

        final ImageIcon icon8 = createImageIcon("missionary222.png");
        label8 = new JLabel(icon8);
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

        label2.setName("boat");
        label3.setName("cannibal1");
        label4.setName("cannibal2");
        label5.setName("cannibal3");
        label6.setName("missionary1");
        label7.setName("missionary2");
        label8.setName("missionary3");
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
            javax.swing.JLabel senderName = (javax.swing.JLabel) e.getSource();
            System.out.println(senderName.getName());
            //start animation of missionary or cannibal towards boat
            if(senderName.getName().equals("boat")){
                boatanimation("boat");
            }
            if(senderName.getName().equals("cannibal1")){
                cannibalanimation("cannibal1");
            }
            if(senderName.getName().equals("cannibal2")){
                cannibalanimation("cannibal2");
            }
            if(senderName.getName().equals("cannibal3")){
                cannibalanimation("cannibal3");
            }
            if(senderName.getName().equals("missionary1")){
                missionaryanimation("missionary1");
            }
            if(senderName.getName().equals("missionary2")){
                missionaryanimation("missionary2");
            }
            if(senderName.getName().equals("missionary3")){
                missionaryanimation("missionary3");
            }
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
            label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            //image can be replaced with another image showing not selected
        }
    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Missionary and Cannibal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new imageoverlap();

        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public  void boatanimation(String c) {
        int offset = 10, f = 0;
        Point point = MouseInfo.getPointerInfo().getLocation();
        double X = point.getX();
        if (c.equals("boat")) {
            if (X > 450 && X < 650) {
                Point origin = new Point(450, 265);
                //Point origin1 = new Point(700, 200);
                for (int i = 0; i < 27; i++) {
                    try {
                        Thread.sleep(10);
                        origin.x -= offset;
                        label2.setBounds(origin.x, 265, 170, 70);
                        if (f == 1) {
                            //origin1.x -= offset;
                            label3.setBounds(origin.x, origin.y, 140, 140);
                        }
                        layeredPane.add(label2, new Integer(3));
                    } catch (Exception e) {
                    }
                }
            } else if (X < 355 && X > 100) {
                Point origin = new Point(180, 265);
                for (int i = 0; i < 27; i++) {
                    try {
                        Thread.sleep(10);
                        origin.x += offset;
                        label2.setBounds(origin.x, 265, 170, 70);
                        layeredPane.add(label2, new Integer(3));
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
    public  void cannibalanimation(String c) {
        int offset = 10,f=0;
        Point point = MouseInfo.getPointerInfo().getLocation();
        double X = point.getX();
        if (c.equals("cannibal1")) {
            System.out.println("cannibal1");
            f=1;
            System.out.println("X="+X);
            if (X > 600 && X < 800) {
                Point origin = new Point(700, 200);
                for (int i = 0; i < 27; i++) {
                    try {
                        Thread.sleep(10);
                        origin.x -= offset;
                        origin.y += 1.99;
                        label3.setBounds(origin.x, origin.y, 140, 140);
                        layeredPane.add(label3, new Integer(3));
                    } catch (Exception e) {
                    }
                }
            }
            else if (X < 540 && X > 480){
                System.out.println("Equals to 180");
                Point origin = new Point(540, 200);
                for (int i=0; i<17; i++) {
                    try{
                        Thread.sleep(10);
                        origin.x += offset;
                        origin.y-=0.1;
                        label3.setBounds(origin.x, origin.y, 140, 140);
                        layeredPane.add(label3, new Integer(3));
                    }catch(Exception e){}
                }
            }
        }
        if (c.equals("cannibal2")) {
            System.out.println("cannibal2");
            if (X > 700 && X < 800) {
                Point origin = new Point(665, 200);
                for (int i = 0; i < 25; i++) {
                    try {
                        Thread.sleep(10);
                        origin.x -= offset;
                        origin.y += 1.99;
                        label4.setBounds(origin.x, origin.y, 140, 140);
                        layeredPane.add(label4, new Integer(3));
                    } catch (Exception e) {
                    }
                }
            }
            else if (X < 500 && X > 450){
                Point origin = new Point(540, 200);
                for (int i=0; i<12; i++) {
                    try{
                        Thread.sleep(10);
                        origin.x += offset;
                        origin.y-=0.1;
                        label4.setBounds(origin.x, origin.y, 140, 140);
                        layeredPane.add(label4, new Integer(3));
                    }catch(Exception e){}
                }
            }
        }
        if (c.equals("cannibal3")) {
            double XX = point.getX();
            System.out.println("cannibal3");
            System.out.println("XX="+XX);
            if (X > 700 && X < 800) {
                Point origin = new Point(690, 230);
                for (int i = 0; i < 25; i++) {
                    try {
                        Thread.sleep(10);
                        origin.x -= offset;
                        origin.y += 0.1;
                        label5.setBounds(origin.x, origin.y, 140, 140);
                        layeredPane.add(label5, new Integer(3));
                    } catch (Exception e) {
                    }
                }
            }
            else if (X < 550 && X > 450){
                Point origin = new Point(540, 200);
                for (int i=0; i<15; i++) {
                    try{
                        Thread.sleep(10);
                        origin.x += offset;
                        //origin.y-=0.1;
                        label5.setBounds(origin.x, 230, 140, 140);
                        layeredPane.add(label5, new Integer(4));
                    }catch(Exception e){}
                }
            }
        }
    }
    public  void missionaryanimation(String c) {
        int offset = 10, f = 0;
        Point point = MouseInfo.getPointerInfo().getLocation();
        double X = point.getX();
        if (c.equals("missionary1")) {
            f = 1;
//            System.out.println("X=" + X);
//            if (X > 600 && X < 800) {
//                System.out.println("Equals to 450");
//                Point origin = new Point(700, 200);
//                for (int i = 0; i < 27; i++) {
//                    try {
//                        Thread.sleep(10);
//                        origin.x -= offset;
//                        origin.y += 1.99;
//                        label3.setBounds(origin.x, origin.y, 140, 140);
//                        layeredPane.add(label3, new Integer(3));
//                    } catch (Exception e) {
//                    }
//                }
//            } else if (X < 540 && X > 480) {
//                System.out.println("Equals to 180");
//                Point origin = new Point(540, 200);
//                for (int i = 0; i < 17; i++) {
//                    try {
//                        Thread.sleep(10);
//                        origin.x += offset;
//                        origin.y -= 0.1;
//                        label3.setBounds(origin.x, origin.y, 140, 140);
//                        layeredPane.add(label3, new Integer(3));
//                    } catch (Exception e) {
//                    }
//                }
//            }

        }
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
