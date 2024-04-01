import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class signUp extends JFrame implements ActionListener{
    JButton submit, reset, cancle;


    signUp(){
        super("Signup");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //UserName lable
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(170,20,50,20);
        add(lblname);

        //UserName field
        JTextField nmae = new JTextField();
        nmae.setBounds(270,20,200,20);
        add(nmae);

        //Address lable
        JLabel lbladrs = new JLabel("Address");
        lbladrs.setBounds(170,60,50,20);
        add(lbladrs);

        //Address field
        JTextField adrs = new JTextField();
        adrs.setBounds(270,60,200,20);
        add(adrs);

        //email lable 
        JLabel lblMail = new JLabel("Email");
        lblMail.setBounds(170,100,50,20);
        add(lblMail);

        //email field
        JTextField email = new JTextField();
        email.setBounds(270,100,200,20);
        add(email);

        //phone number lable
        JLabel lblphoNo = new JLabel("Phone No.");
        lblphoNo.setBounds(170,140,70,20);
        add(lblphoNo);

        //phone number field
        JFormattedTextField phoNo = new JFormattedTextField(createFormatter("##########"));
        phoNo.setBounds(270, 140, 100, 20);
        add(phoNo);

        //Username lable
        JLabel lblUsername = new JLabel("Username ");
        lblUsername.setBounds(170,180,70,20);
        add(lblUsername);

        //Username field
        JTextField userName = new JTextField();
        userName.setBounds(270,180,200,20);
        add(userName);

        //radio button
        JRadioButton vegOpt=new JRadioButton("Customer");
        vegOpt.setBackground(Color.WHITE);
        vegOpt.setBounds(190,220,80,20);
        add(vegOpt);

       JRadioButton nonVegOpt=new JRadioButton("Manager");
       nonVegOpt.setBackground(Color.WHITE);
        nonVegOpt.setBounds(350,220,80,20);
        add(nonVegOpt);

        ButtonGroup gender=new ButtonGroup();//grouping radio button 
        gender.add(vegOpt);
        gender.add(nonVegOpt);

        //password lable
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(170, 260, 70, 20);
        add(passwordLabel);
        
        // password field
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBounds(270, 260, 100, 20);
        add(passwordField);

        ImageIcon eye1 = new ImageIcon(ClassLoader.getSystemResource("icons/eyeClosed.png"));
        Image eye2 = eye1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon eye3 = new ImageIcon(ClassLoader.getSystemResource("icons/eyeOpen.png"));
        Image eye4 = eye3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);

        JToggleButton showPasswordButton = new JToggleButton(new ImageIcon(eye2));
        showPasswordButton.setBorderPainted(false);
        showPasswordButton.setBounds(375, 260, 20, 20);
        
        showPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordButton.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                    showPasswordButton.setIcon(new ImageIcon(eye4)); // Show password
                } else {
                    passwordField.setEchoChar('\u2022');
                    showPasswordButton.setIcon(new ImageIcon(eye2)); // Hide password
                }
            }
        });
        add(showPasswordButton);

        JLabel retypePasswordLabel = new JLabel("Retype Password");
        retypePasswordLabel.setBounds(150, 300, 100, 20);
        add(retypePasswordLabel);
        
        JPasswordField retypePasswordField = new JPasswordField(15);
        retypePasswordField.setBounds(270, 300, 100, 20);
        add(retypePasswordField);

 


        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(250,350,100,30);
        signUpButton.setBackground(Color.YELLOW );
        Border bdr = BorderFactory.createEmptyBorder();;
        signUpButton.setBorder(bdr);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userName.getText();
                char[] password = passwordField.getPassword();
                char[] retypePassword = retypePasswordField.getPassword();
                
                if (username.isEmpty() || password.length == 0 || retypePassword.length == 0) {
                    JOptionPane.showMessageDialog(null, "Username or password cannot be empty");
                    return;
                }
                
                String passwordStr = new String(password);
                String retypePasswordStr = new String(retypePassword);
                
                // Password validation
                if (!isValidPassword(passwordStr)) {
                    JOptionPane.showMessageDialog(null, "Password must length > 8 \n contains atleast 1-symbol \n 3-numbers \n 1-UpperCase characters \n");
                    return;
                }
                
                // Password rechecking
                if (!passwordStr.equals(retypePasswordStr)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match");
                    return;
                }
                
                // Continue with signup process
                // ...
                
                JOptionPane.showMessageDialog(null, "Sign up successful!");
                setVisible(false);
                new login();
            }
        });
        add(signUpButton);

        ImageIcon cust1 = new ImageIcon(ClassLoader.getSystemResource("icons/messUser2.jpg"));
        Image cust2 = cust1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon cust3 = new ImageIcon(cust2);
        JLabel img1 = new JLabel(cust3);
        img1.setBounds(300, 120, 300, 300);
        add(img1);


        setBounds(450, 200, 650, 500);
        // setLocationRelativeTo(null);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ee){
        if(ee.getSource() == submit){

        }else if(ee.getSource() == reset){

        }else if(ee.getSource() == cancle){
            setVisible(false);
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
        new signUp();
    }
}
