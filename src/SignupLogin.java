import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SignupLogin {
    public static void main(String args[]) {
        JFrame f = new JFrame();
        Container c = f.getContentPane();
        c.setLayout(null);

        JLabel label = new JLabel("Select Option");
        label.setBounds(300, 50, 200, 60);
        c.add(label);

        JRadioButton radio1 = new JRadioButton("signup");
        radio1.setBounds(200, 100, 100, 20);
        c.add(radio1);

        JRadioButton radio2 = new JRadioButton("login");
        radio2.setBounds(300, 100, 100, 20);
        c.add(radio2);

        Font font = new Font("arial", Font.BOLD, 16);// font class object
        label.setFont(font);
        radio1.setFont(font);
        radio2.setFont(font);

        ButtonGroup gender = new ButtonGroup();// grouping radio button
        gender.add(radio1);
        gender.add(radio2);

        JButton btn = new JButton("submit");
        btn.setSize(85, 20);
        btn.setLocation(250, 265);// (left,top)
        c.add(btn);

        f.setVisible(true);// window visibility
        f.setBounds(100, 100, 700, 500);// window size
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
