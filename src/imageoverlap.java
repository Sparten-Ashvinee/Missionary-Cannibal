import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class imageoverlap extends JPanel{

   static int rider_count=0;

    static int boat_right_first_x =731;
    static int boat_y =440;
    static int boat_right_second_x =771;

    static int boat_coord_right_x=700;
    static int boat_coord_left_x=500;
    static int boat_coord_y=460;

    static boolean boat_first_free=true;
    static boolean boat_second_free=true;

    static int common_y=430;

    static int cannibal1_right_x=1300;
    static int cannibal2_right_x=1250;
    static int cannibal3_right_x=1200;

    static int missionary1_right_x=1150;
    static int missionary2_right_x=1100;
    static int missionary3_right_x=1050;

    static int cannibal1_left_x=300;
    static int cannibal2_left_x=250;
    static int cannibal3_left_x=200;

    static int missionary1_left_x=150;
    static int missionary2_left_x=100;
    static int missionary3_left_x=50;

    private static JLayeredPane layeredPane;
    public static JLabel label;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static JLabel label5;
    private static JLabel label6;
    private static JLabel label7;
    private static JLabel label8;
    private static int layer_count=2;
    public imageoverlap(){
        //Create and set up the layered pane.
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1366 , 768));

        final ImageIcon icon = createImageIcon("scenery5.png");
        label = new JLabel(icon);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        Point origin = new Point(0, 0);
        label.setBounds(origin.x, origin.y, 1366 , 768);
        layeredPane.add(label, new Integer(0));

        final ImageIcon icon2 = createImageIcon("boat12.png");
        label2 = new JLabel(icon2);
        label2.setVerticalAlignment(JLabel.TOP);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setOpaque(false);
        label2.setBounds(boat_coord_right_x, boat_coord_y, 170, 70);
        layeredPane.add(label2, new Integer(3));


        final ImageIcon icon3 = createImageIcon("cannibal222.png");
        label3 = new JLabel(icon3);
        label3.setVerticalAlignment(JLabel.TOP);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setOpaque(false);
        label3.setBounds(1300, 430, 35, 59);
        layeredPane.add(label3, new Integer(2));

        final ImageIcon icon4 = createImageIcon("cannibal222.png");
        label4 = new JLabel(icon4);
        label4.setVerticalAlignment(JLabel.TOP);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label4.setOpaque(false);
        label4.setBounds(1250, 430, 35, 59);
        layeredPane.add(label4, new Integer(2));

        final ImageIcon icon5 = createImageIcon("cannibal222.png");
        label5 = new JLabel(icon5);
        label5.setVerticalAlignment(JLabel.TOP);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label5.setOpaque(false);
        label5.setBounds(1200, 430, 35, 59);
        layeredPane.add(label5, new Integer(2));

        final ImageIcon icon6 = createImageIcon("missionary222.png");
        label6 = new JLabel(icon6);
        label6.setVerticalAlignment(JLabel.TOP);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label6.setOpaque(false);
        label6.setBounds(1150, 430, 32, 59);
        layeredPane.add(label6, new Integer(2));

        final ImageIcon icon7 = createImageIcon("missionary222.png");
        label7 = new JLabel(icon7);
        label7.setVerticalAlignment(JLabel.TOP);
        label7.setHorizontalAlignment(JLabel.CENTER);
        label7.setOpaque(false);
        label7.setBounds(1100, 430, 32, 59);
        layeredPane.add(label7, new Integer(2));

        final ImageIcon icon8 = createImageIcon("missionary222.png");
        label8 = new JLabel(icon8);
        label8.setVerticalAlignment(JLabel.TOP);
        label8.setHorizontalAlignment(JLabel.CENTER);
        label8.setOpaque(false);
        label8.setBounds(1050, 430, 32, 59);
        layeredPane.add(label8, new Integer(2));

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
                boat_animation("boat");
            }
            if(senderName.getName().equals("cannibal1")){
                cannibal_animation("cannibal1");
            }
            if(senderName.getName().equals("cannibal2")){
                cannibal_animation("cannibal2");
            }
            if(senderName.getName().equals("cannibal3")){
                cannibal_animation("cannibal3");
            }
            if(senderName.getName().equals("missionary1")){
                missionary_animation("missionary1");
            }
            if(senderName.getName().equals("missionary2")){
                missionary_animation("missionary2");
            }
            if(senderName.getName().equals("missionary3")){
                missionary_animation("missionary3");
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

        JComponent newContentPane = new imageoverlap();

        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }
    public  void boat_animation(String c) {
        int offset = 10, f = 0;
        Point point = MouseInfo.getPointerInfo().getLocation();
        double X = point.getX();
        System.out.println(X);
        if(isRight(point))
        {
            if((!boat_first_free)||(!boat_second_free))
            {
                if(!isOnLand(new Point(label3.getX(),label3.getY())))
                {
                    int temp_x=label3.getX();
                    label3.setBounds(temp_x-200,boat_y,35,59);
                    layeredPane.add(label3,new Integer(3));
                }
                if(!isOnLand(new Point(label4.getX(),label4.getY())))
                {
                    int temp_x=label4.getX();
                    label4.setBounds(temp_x-200,boat_y,35,59);
                    layeredPane.add(label4,new Integer(3));
                }
                if(!isOnLand(new Point(label5.getX(),label5.getY())))
                {
                    int temp_x=label5.getX();
                    label5.setBounds(temp_x-200,boat_y,35,59);
                    layeredPane.add(label5,new Integer(3));
                }
                if(!isOnLand(new Point(label6.getX(),label6.getY())))
                {
                    int temp_x=label6.getX();
                    label6.setBounds(temp_x-200,boat_y,32,59);
                    layeredPane.add(label6,new Integer(3));
                }
                if(!isOnLand(new Point(label7.getX(),label7.getY())))
                {
                    int temp_x=label7.getX();
                    label7.setBounds(temp_x-200,boat_y,32,59);
                    layeredPane.add(label7,new Integer(3));
                }
                if(!isOnLand(new Point(label8.getX(),label8.getY())))
                {
                    int temp_x=label8.getX();
                    label8.setBounds(temp_x-200,boat_y,32,59);
                    layeredPane.add(label8,new Integer(3));
                }

                label2.setBounds(boat_coord_left_x,boat_coord_y,170,70);
                layeredPane.add(label2,new Integer(3));
                checkGameStatus();
            }
        }
        else {
            if ((!boat_first_free) || (!boat_second_free)) {
                if (!isOnLand(new Point(label3.getX(), label3.getY()))) {
                    int temp_x = label3.getX();
                    label3.setBounds(temp_x + 200, boat_y, 35, 59);
                    layeredPane.add(label3, new Integer(3));
                }
                if (!isOnLand(new Point(label4.getX(), label4.getY()))) {
                    int temp_x = label4.getX();
                    label4.setBounds(temp_x + 200, boat_y, 35, 59);
                    layeredPane.add(label4, new Integer(3));
                }
                if (!isOnLand(new Point(label5.getX(), label5.getY()))) {
                    int temp_x = label5.getX();
                    label5.setBounds(temp_x + 200, boat_y, 35, 59);
                    layeredPane.add(label5, new Integer(3));
                }
                if (!isOnLand(new Point(label6.getX(), label6.getY()))) {
                    int temp_x = label6.getX();
                    label6.setBounds(temp_x + 200, boat_y, 32, 59);
                    layeredPane.add(label6, new Integer(3));
                }
                if (!isOnLand(new Point(label7.getX(), label7.getY()))) {
                    int temp_x = label7.getX();
                    label7.setBounds(temp_x + 200, boat_y, 32, 59);
                    layeredPane.add(label7, new Integer(3));
                }
                if (!isOnLand(new Point(label8.getX(), label8.getY()))) {
                    int temp_x = label8.getX();
                    label8.setBounds(temp_x + 200, boat_y, 32, 59);
                    layeredPane.add(label8, new Integer(3));
                }

                label2.setBounds(boat_coord_right_x, boat_coord_y, 170, 70);
                layeredPane.add(label2, new Integer(3));
                checkGameStatus();
            }
        }
    }
    public  void cannibal_animation(String c) {
        Point point = MouseInfo.getPointerInfo().getLocation();

        switch (c)
        {
            case "cannibal1":

                if((isRight(new Point(label3.getX(),label3.getY()))&&(isRight(new Point(label2.getX(),label2.getY()))))||(!isRight(new Point(label3.getX(),label3.getY()))&&(!isRight(new Point(label2.getX(),label2.getY())))))
                {
                    if(isRight(point))
                    {
                        if(isOnLand(point))
                        {
                            if(boat_first_free)
                            {
                                label3.setBounds(boat_right_first_x, boat_y, 35, 59);
                                layeredPane.add(label3, new Integer(3));
                                boat_first_free=false;
                            }
                            else if(boat_second_free)
                            {
                                label3.setBounds(boat_right_second_x, boat_y, 35, 59);
                                layeredPane.add(label3, new Integer(3));
                                boat_second_free=false;
                            }
                        }
                        else
                        {
                            int x=label3.getX();

                            if(x== boat_right_first_x)boat_first_free=true;
                            else if(x== boat_right_second_x)boat_second_free=true;

                            label3.setBounds(cannibal1_right_x,common_y,35,59);
                            layeredPane.add(label3, new Integer(3));

                        }
                    }
                    else
                    {
                        if(isOnLand(point))
                        {
                            if(boat_first_free)
                            {
                                label3.setBounds(boat_right_first_x-200, boat_y, 35, 59);
                                layeredPane.add(label3, new Integer(3));
                                boat_first_free=false;
                            }
                            else if(boat_second_free)
                            {
                                label3.setBounds(boat_right_second_x-200, boat_y, 35, 59);
                                layeredPane.add(label3, new Integer(3));
                                boat_second_free=false;
                            }
                        }
                        else
                        {
                            int x=label3.getX();

                            if(x== boat_right_first_x-200)boat_first_free=true;
                            else if(x== boat_right_second_x-200)boat_second_free=true;

                            label3.setBounds(cannibal1_left_x,common_y,35,59);
                            layeredPane.add(label3, new Integer(3));

                        }
                    }
                }



                break;

            case "cannibal2":

                if((isRight(new Point(label4.getX(),label4.getY()))&&(isRight(new Point(label2.getX(),label2.getY()))))||(!isRight(new Point(label4.getX(),label4.getY()))&&(!isRight(new Point(label2.getX(),label2.getY())))))
                {
                    if(isRight(point))
                    {
                        if(isOnLand(point))
                        {
                            if(boat_first_free)
                            {
                                label4.setBounds(boat_right_first_x, boat_y, 35, 59);
                                layeredPane.add(label4, new Integer(3));
                                boat_first_free=false;
                            }
                            else if(boat_second_free)
                            {
                                label4.setBounds(boat_right_second_x, boat_y, 35, 59);
                                layeredPane.add(label4, new Integer(3));
                                boat_second_free=false;
                            }
                        }
                        else
                        {
                            int x=label4.getX();

                            if(x== boat_right_first_x)boat_first_free=true;
                            else if(x== boat_right_second_x)boat_second_free=true;

                            label4.setBounds(cannibal2_right_x,common_y,35,59);
                            layeredPane.add(label4, new Integer(3));

                        }
                    }
                    else
                    {
                        if(isOnLand(point))
                        {
                            if(boat_first_free)
                            {
                                label4.setBounds(boat_right_first_x-200, boat_y, 35, 59);
                                layeredPane.add(label4, new Integer(3));
                                boat_first_free=false;
                            }
                            else if(boat_second_free)
                            {
                                label4.setBounds(boat_right_second_x-200, boat_y, 35, 59);
                                layeredPane.add(label4, new Integer(3));
                                boat_second_free=false;
                            }
                        }
                        else
                        {
                            int x=label4.getX();

                            if(x== boat_right_first_x-200)boat_first_free=true;
                            else if(x== boat_right_second_x-200)boat_second_free=true;

                            label4.setBounds(cannibal2_left_x,common_y,35,59);
                            layeredPane.add(label4, new Integer(3));

                        }
                    }
                }



                break;

            case "cannibal3":

                if((isRight(new Point(label5.getX(),label5.getY()))&&(isRight(new Point(label2.getX(),label2.getY()))))||(!isRight(new Point(label5.getX(),label5.getY()))&&(!isRight(new Point(label2.getX(),label2.getY())))))
                {
                    if(isRight(point))
                    {
                        if(isOnLand(point))
                        {
                            if(boat_first_free)
                            {
                                label5.setBounds(boat_right_first_x, boat_y, 35, 59);
                                layeredPane.add(label5, new Integer(3));
                                boat_first_free=false;
                            }
                            else if(boat_second_free)
                            {
                                label5.setBounds(boat_right_second_x, boat_y, 35, 59);
                                layeredPane.add(label5, new Integer(3));
                                boat_second_free=false;
                            }
                        }
                        else
                        {
                            int x=label5.getX();

                            if(x== boat_right_first_x)boat_first_free=true;
                            else if(x== boat_right_second_x)boat_second_free=true;

                            label5.setBounds(cannibal3_right_x,common_y,35,59);
                            layeredPane.add(label5, new Integer(3));

                        }
                    }

                    else
                    {
                        if(isOnLand(point))
                        {
                            if(boat_first_free)
                            {
                                label5.setBounds(boat_right_first_x-200, boat_y, 35, 59);
                                layeredPane.add(label5, new Integer(3));
                                boat_first_free=false;
                            }
                            else if(boat_second_free)
                            {
                                label5.setBounds(boat_right_second_x-200, boat_y, 35, 59);
                                layeredPane.add(label5, new Integer(3));
                                boat_second_free=false;
                            }
                        }
                        else
                        {
                            int x=label5.getX();

                            if(x== boat_right_first_x-200)boat_first_free=true;
                            else if(x== boat_right_second_x-200)boat_second_free=true;

                            label5.setBounds(cannibal3_left_x,common_y,35,59);
                            layeredPane.add(label5, new Integer(3));

                        }
                    }
                }



                break;
        }
    }
    public  void missionary_animation(String c) {
        int offset = 10, f = 0;
        Point point = MouseInfo.getPointerInfo().getLocation();
        double X = point.getX();

        switch (c)
        {

            case "missionary1":

                if((isRight(new Point(label6.getX(),label6.getY()))&&(isRight(new Point(label2.getX(),label2.getY()))))||(!isRight(new Point(label6.getX(),label6.getY()))&&(!isRight(new Point(label2.getX(),label2.getY())))))
                {
                    if (isRight(point))
                    {
                        if (isOnLand(point))
                        {
                            if (boat_first_free)
                            {
                                label6.setBounds(boat_right_first_x, boat_y, 32, 59);
                                layeredPane.add(label6, new Integer(3));
                                boat_first_free = false;
                            }
                            else if (boat_second_free)
                            {
                                label6.setBounds(boat_right_second_x, boat_y, 32, 59);
                                layeredPane.add(label6, new Integer(3));
                                boat_second_free = false;
                            }
                        }
                        else
                        {
                            int x = label6.getX();

                            if (x == boat_right_first_x) boat_first_free = true;
                            else if (x == boat_right_second_x) boat_second_free = true;

                            label6.setBounds(missionary1_right_x, common_y, 32, 59);
                            layeredPane.add(label6, new Integer(3));

                        }
                    }
                    else
                    {
                        if(isOnLand(point))
                        {
                            if(boat_first_free)
                            {
                                label6.setBounds(boat_right_first_x-200, boat_y, 35, 59);
                                layeredPane.add(label6, new Integer(3));
                                boat_first_free=false;
                            }
                            else if(boat_second_free)
                            {
                                label6.setBounds(boat_right_second_x-200, boat_y, 35, 59);
                                layeredPane.add(label6, new Integer(3));
                                boat_second_free=false;
                            }
                        }
                        else
                        {
                            int x=label6.getX();

                            if(x== boat_right_first_x-200)boat_first_free=true;
                            else if(x== boat_right_second_x-200)boat_second_free=true;

                            label6.setBounds(missionary1_left_x,common_y,35,59);
                            layeredPane.add(label6, new Integer(3));

                        }
                    }
                }



                break;

            case "missionary2":

                if((isRight(new Point(label7.getX(),label7.getY()))&&(isRight(new Point(label2.getX(),label2.getY()))))||(!isRight(new Point(label7.getX(),label7.getY()))&&(!isRight(new Point(label2.getX(),label2.getY())))))
                {
                    if (isRight(point))
                    {
                        if (isOnLand(point))
                        {
                            if (boat_first_free)
                            {
                                label7.setBounds(boat_right_first_x, boat_y, 32, 59);
                                layeredPane.add(label7, new Integer(3));
                                boat_first_free = false;
                            }
                            else if (boat_second_free)
                            {
                                label7.setBounds(boat_right_second_x, boat_y, 32, 59);
                                layeredPane.add(label7, new Integer(3));
                                boat_second_free = false;
                            }
                        }
                        else
                        {
                            int x = label7.getX();

                            if (x == boat_right_first_x) boat_first_free = true;
                            else if (x == boat_right_second_x) boat_second_free = true;

                            label7.setBounds(missionary2_right_x, common_y, 32, 59);
                            layeredPane.add(label7, new Integer(3));

                        }
                    }
                    else
                    {
                        if(isOnLand(point))
                        {
                            if(boat_first_free)
                            {
                                label7.setBounds(boat_right_first_x-200, boat_y, 35, 59);
                                layeredPane.add(label7, new Integer(3));
                                boat_first_free=false;
                            }
                            else if(boat_second_free)
                            {
                                label7.setBounds(boat_right_second_x-200, boat_y, 35, 59);
                                layeredPane.add(label7, new Integer(3));
                                boat_second_free=false;
                            }
                        }
                        else
                        {
                            int x=label7.getX();

                            if(x== boat_right_first_x-200)boat_first_free=true;
                            else if(x== boat_right_second_x-200)boat_second_free=true;

                            label7.setBounds(missionary2_left_x,common_y,35,59);
                            layeredPane.add(label7, new Integer(3));

                        }
                    }
                }

                break;

            case "missionary3":

                if((isRight(new Point(label8.getX(),label8.getY()))&&(isRight(new Point(label2.getX(),label2.getY()))))||(!isRight(new Point(label8.getX(),label8.getY()))&&(!isRight(new Point(label2.getX(),label2.getY())))))
                {
                    if (isRight(point))
                    {
                        if (isOnLand(point))
                        {
                            if (boat_first_free)
                            {
                                label8.setBounds(boat_right_first_x, boat_y, 32, 59);
                                layeredPane.add(label8, new Integer(3));
                                boat_first_free = false;
                            }
                            else if (boat_second_free)
                            {
                                label8.setBounds(boat_right_second_x, boat_y, 32, 59);
                                layeredPane.add(label8, new Integer(3));
                                boat_second_free = false;
                            }
                        }
                        else
                        {
                            int x = label8.getX();

                            if (x == boat_right_first_x) boat_first_free = true;
                            else if (x == boat_right_second_x) boat_second_free = true;

                            label8.setBounds(missionary3_right_x, common_y, 32, 59);
                            layeredPane.add(label8, new Integer(3));

                        }
                    }
                    else
                    {
                        if(isOnLand(point))
                        {
                            if(boat_first_free)
                            {
                                label8.setBounds(boat_right_first_x-200, boat_y, 35, 59);
                                layeredPane.add(label8, new Integer(3));
                                boat_first_free=false;
                            }
                            else if(boat_second_free)
                            {
                                label8.setBounds(boat_right_second_x-200, boat_y, 35, 59);
                                layeredPane.add(label8, new Integer(3));
                                boat_second_free=false;
                            }
                        }
                        else
                        {
                            int x=label8.getX();

                            if(x== boat_right_first_x-200)boat_first_free=true;
                            else if(x== boat_right_second_x-200)boat_second_free=true;

                            label8.setBounds(missionary3_left_x,common_y,35,59);
                            layeredPane.add(label8, new Integer(3));

                        }
                    }

                    break;
                }
        }
    }

    public static boolean isRight(Point p)
    {
        if(p.getX()>680)return true;

        else return false;
    }

    public static boolean isOnLand(Point p)
    {
        if((p.getX()>1000)||(p.getX()<400))return true;

        else return false;
    }

    public static void checkGameStatus()
    {
        int missionary_count=0;
        int cannibal_count=0;

        if(isRight(new Point(label3.getX(),label3.getY())))cannibal_count++;
        if(isRight(new Point(label4.getX(),label4.getY())))cannibal_count++;
        if(isRight(new Point(label5.getX(),label5.getY())))cannibal_count++;

        if(isRight(new Point(label6.getX(),label6.getY())))missionary_count++;
        if(isRight(new Point(label7.getX(),label7.getY())))missionary_count++;
        if(isRight(new Point(label8.getX(),label8.getY())))missionary_count++;

        if((cannibal_count>missionary_count)&&(missionary_count!=0))
        {
            infoBox("Game over! The cannibals have eaten the missionaries!","Game Status");

            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });

        }

        missionary_count=0;cannibal_count=0;

        if(!isRight(new Point(label3.getX(),label3.getY())))cannibal_count++;
        if(!isRight(new Point(label4.getX(),label4.getY())))cannibal_count++;
        if(!isRight(new Point(label5.getX(),label5.getY())))cannibal_count++;

        if(!isRight(new Point(label6.getX(),label6.getY())))missionary_count++;
        if(!isRight(new Point(label7.getX(),label7.getY())))missionary_count++;
        if(!isRight(new Point(label8.getX(),label8.getY())))missionary_count++;

        if((cannibal_count>missionary_count)&&(missionary_count!=0))
        {
            infoBox("Game over! The cannibals have eaten the missionaries!","Game Status");

            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });

        }
        else if(missionary_count+cannibal_count==6)
        {
            infoBox("You've managed to get them across safely!\n Congratulations!","Game Status");

            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
        }

    }

    public static void infoBox(String infoMessage, String location)
    {JOptionPane.showMessageDialog(null, infoMessage,location, JOptionPane.INFORMATION_MESSAGE);
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
