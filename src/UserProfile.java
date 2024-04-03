import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;

public class UserProfile extends JFrame implements ActionListener{
    JButton back, edit;

    UserProfile(){
        super("User Profile");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //UserID lable
        JLabel lblUserId = new JLabel("User Id");
        lblUserId.setBounds(150,20,50,20);
        add(lblUserId);

        //UserID field
        JLabel UserId = new JLabel("USR12345");
        UserId.setBounds(250,20,200,20);
        add(UserId);

        //UserName lable
        JLabel lblusername = new JLabel("Name");
        lblusername.setBounds(150,60,50,20);
        add(lblusername);

        //UserName field
        JLabel userName = new JLabel("Client Name");
        userName.setBounds(250,60,200,20);
        add(userName);

        //Address lable
        JLabel lbladrs = new JLabel("Address");
        lbladrs.setBounds(150,100,50,20);
        add(lbladrs);

        //Address field
        JLabel adrs = new JLabel("Set Address");
        adrs.setBounds(250,100,200,20);
        add(adrs);

        //email lable 
        JLabel lblMail = new JLabel("Email");
        lblMail.setBounds(150,140,50,20);
        add(lblMail);

        //email field
        JLabel email = new JLabel("abc123@gmail.com");
        email.setBounds(250,140,200,20);
        add(email);

        //phone number lable
        JLabel lblphoNo = new JLabel("Phone No.");
        lblphoNo.setBounds(150,180,70,20);
        add(lblphoNo);

        //phone number field
        JLabel phoNo = new JLabel("012345679");
        phoNo.setBounds(250,180,70,20);
        add(phoNo);

        
        // Prefreance lable
        JLabel lblpreference = new JLabel("Preference ");
        lblpreference.setBounds(150,220,70,20);
        add(lblpreference);

        // Prefreance field
        JLabel preference = new JLabel("nonveg");
        preference.setForeground(Color.RED);
        preference.setBounds(250,220,70,20);
        add(preference);

        // edit = new JButton("Edit");
        // edit.setBounds(120,260,100,20);
        // edit.addActionListener(this);
        // add(edit);

        back = new JButton("Back");
        back.setBounds(190,300,100,20);
        back.addActionListener(this);
        add(back);

        setBounds(500, 200, 500, 400);
        // setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new ClientHome();
        }
    }

     private MaskFormatter createFormatter(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        return formatter;
    }

    private boolean isValidPassword(String password) {
        // Password constraints: minimum 8 characters, 1 capital letter, 3 numbers, 1 special character
        if (password.length() < 8) return false;
        
        int uppercaseCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) uppercaseCount++;
            if (Character.isDigit(c)) digitCount++;
            if (!Character.isLetterOrDigit(c)) specialCharCount++;
        }
        
        return uppercaseCount >= 1 && digitCount >= 3 && specialCharCount >= 1;
    }


    public static void main(String args[]){
        new UserProfile();
    }
}
