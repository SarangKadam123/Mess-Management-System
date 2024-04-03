import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class ClientEdit extends JFrame implements ActionListener{
    JButton save;

    ClientEdit(){
        super("ClientEdit");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //UserID lable
        JLabel lblUserId = new JLabel("User Id");
        lblUserId.setBounds(170,20,50,20);
        add(lblUserId);

        //UserID field
        JLabel UserId = new JLabel("USR12345");
        UserId.setBounds(270,20,100,20);
        add(UserId);

        //UserName lable
        JLabel lblusername = new JLabel("Name");
        lblusername.setBounds(170,60,50,20);
        add(lblusername);

        //UserName field
        JTextField userName = new JTextField();
        userName.setBounds(270,60,200,20);
        add(userName);

        //Address lable
        JLabel lbladrs = new JLabel("Address");
        lbladrs.setBounds(170,100,50,20);
        add(lbladrs);

        //Address field
        JTextField adrs = new JTextField();
        adrs.setBounds(270,100,200,20);
        add(adrs);

        //email lable 
        JLabel lblMail = new JLabel("Email");
        lblMail.setBounds(170,140,50,20);
        add(lblMail);

        //email field
        JTextField email = new JTextField();
        email.setBounds(270,140,200,20);
        add(email);

        //phone number lable
        JLabel lblphoNo = new JLabel("Phone No.");
        lblphoNo.setBounds(170,180,70,20);
        add(lblphoNo);

        //phone number field
        JFormattedTextField phoNo = new JFormattedTextField(createFormatter("##########"));
        phoNo.setBounds(270, 180, 100, 20);
        add(phoNo);

        // Prefreance lable
        JLabel lblpreference = new JLabel("Preference ");
        lblpreference.setBounds(170,220,70,20);
        add(lblpreference);

        //radio button
        JRadioButton vegOpt=new JRadioButton("Veg");
        vegOpt.setBackground(Color.WHITE);
        vegOpt.setForeground(Color.GREEN);
        vegOpt.setBounds(270,220,50,20);
        add(vegOpt);

        JRadioButton nonVegOpt=new JRadioButton("Non-veg");
        nonVegOpt.setBackground(Color.WHITE);
        nonVegOpt.setForeground(Color.RED);
        nonVegOpt.setBounds(350,220,80,20);
        add(nonVegOpt);

        ButtonGroup gender=new ButtonGroup();//grouping radio button 
        gender.add(vegOpt);
        gender.add(nonVegOpt);

        save = new JButton("Save");
        save.setBounds(250,280,100,30);
        save.setBackground(Color.YELLOW);
        save.addActionListener(this);
        add(save);
       
        setBounds(450, 200, 600, 400);
        setVisible(true);
        setResizable(false);


    }

    public void actionPerformed(ActionEvent ee){
        if(ee.getSource() == save){
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
        new ClientEdit();
    }
}
