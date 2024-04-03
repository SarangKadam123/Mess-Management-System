import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class managerMenuOpt extends JFrame implements ActionListener{

    JButton setMenu, seeMenu;
    managerMenuOpt() {
        super("Options");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setMenu = new JButton("Set Menu");
        setMenu.setBounds(30,200,100,30);
        setMenu.addActionListener(this);
        add(setMenu);

        seeMenu = new JButton("See Menu");
        seeMenu.setBounds(150,200,100,30);
        seeMenu.addActionListener(this);
        add(seeMenu);  


        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/Menu1.png"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(15, 0, 250, 250);
        add(image);

        setBounds(600, 250, 300, 300);
        // setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == setMenu) {
            setVisible(false);
            new setMenu();
        

        } else if(ae.getSource() == seeMenu) {
            setVisible(false);
            new SeeMenu("ManagerPage");
        }
    }


    public static void main(String[] args) {
        new managerMenuOpt();
    }
}
