import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;


public class ManagerPage extends JFrame implements ActionListener {
    JButton Menu, Data, Feedback;

    ManagerPage(){
        
        super("Home");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); 

        //menu bar
        JMenuBar menubr = new JMenuBar();
        JMenu menu = new JMenu("Info");

        JMenuItem i1=new JMenuItem("View Information");
        i1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        i1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ManagerProfile("ManagerPage");
            }
        });


        JMenuItem i2=new JMenuItem("Edit Information");
        i2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ManagerEdit();
            }
        });


        ImageIcon three = new ImageIcon(ClassLoader.getSystemResource("icons/more.png"));
        Image three2 = three.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);


        menu.add(i1);
        menu.add(i2);
        menu.setIcon(new ImageIcon(three2));
        menubr.add(menu);
        menubr.setBounds(0,0,1000,30);
        add(menubr);


         // Load the image
         ImageIcon backgroundImage = new ImageIcon("MessClientBackground.jpg"); // Path to your image file

         // Create a custom JPanel subclass to paint the image
         JPanel backgroundPanel = new JPanel() {
             @Override
             protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
             }
         };
 
         // Set layout to null since we're manually positioning components
         backgroundPanel.setLayout(null);
 
         // Add other components or set content here
 
         // Add the custom panel to the content pane
         getContentPane().add(backgroundPanel);


        JLabel heading = new JLabel("Hello Manager !");
        Font labelFont = new Font("Arial", Font.BOLD, 40); // You can adjust the font size and style here
        heading.setFont(labelFont);
        heading.setBounds(350,30,400,50);
        add(heading);

        ImageIcon cust1 = new ImageIcon(ClassLoader.getSystemResource("icons/setMenuIcon.png"));
        Image cust2 = cust1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon cust3 = new ImageIcon(cust2);
        JLabel img1 = new JLabel(cust3);
        img1.setBounds(150, 150, 200, 200);
        add(img1);

        JButton menuBtn = new JButton("Menu");
        menuBtn.setBounds(200, 350, 100, 40);
        menuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                new managerMenuOpt();
            }
        });
        add(menuBtn);


        ImageIcon dImg = new ImageIcon(ClassLoader.getSystemResource("icons/Data1.png"));
        Image img2 = dImg.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon DImgu = new ImageIcon(img2);
        JLabel dimg = new JLabel(DImgu);
        dimg.setBounds(400, 150, 200, 200);
        add(dimg);
        
        JButton dataBtn = new JButton("Data");
        dataBtn.setBounds(450, 350, 100, 40);
        add(dataBtn);


        ImageIcon fImg = new ImageIcon(ClassLoader.getSystemResource("icons/SeeFeedbackIcon.png"));
        Image img3 = fImg.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon fImgu = new ImageIcon(img3);
        JLabel fimg = new JLabel(fImgu);
        fimg.setBounds(650, 150, 200, 200);
        add(fimg);

        JButton feedBtn = new JButton("See Feedback");
        feedBtn.setBounds(700, 350, 120, 40);
        feedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                FeedbackPage feedbackPage = new FeedbackPage();
                feedbackPage.setVisible(true);
            }
        });
        add(feedBtn);

        // feedBtn.

        setBounds(300, 70, 1000, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent as){

    }

    public static void main(String args[]){
        new ManagerPage();
    }
}
