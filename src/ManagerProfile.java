import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;

public class ManagerProfile extends JFrame implements ActionListener{
    JButton submit, reset, cancle, backButton;
    String strn = "";
    ManagerProfile(String str){
        super("User Profile");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        strn = str;

        // backButton = new JButton("Back");
        // backButton.setBounds(20, 20, 80, 30);
        // backButton.addActionListener(this);
        // add(backButton);

        //UserID lable
        JLabel lblUserId = new JLabel("ID");
        lblUserId.setBounds(150,20,50,20);
        add(lblUserId);

        //UserID field
        JLabel UserId = new JLabel("MGR12345");
        UserId.setBounds(250,20,200,20);
        add(UserId);

        //UserName lable
        JLabel lblusername = new JLabel("Name");
        lblusername.setBounds(150,60,50,20);
        add(lblusername);

        //UserName field
        JLabel userName = new JLabel("Manager Name");
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

        //UPI ID lable
        JLabel lbl_UPI = new JLabel("UPI ID");
        lbl_UPI.setBounds(150,140,50,20);
        add(lbl_UPI);

        //UPI ID field
        JLabel UPIid = new JLabel("abc@okbank.id");
        UPIid.setBounds(250,140,200,20);
        add(UPIid);

        //email lable 
        JLabel lblMail = new JLabel("Email");
        lblMail.setBounds(150,180,50,20);
        add(lblMail);

        //email field
        JLabel email = new JLabel("abc123@gmail.com");
        email.setBounds(250,180,200,20);
        add(email);

        //phone number lable
        JLabel lblphoNo = new JLabel("Phone No.");
        lblphoNo.setBounds(150,220,70,20);
        add(lblphoNo);

        //phone number field
        JLabel phoNo = new JLabel("012345679");
        phoNo.setBounds(250,220,70,20);
        add(phoNo);


        setBounds(500, 200, 500, 400);
        // setLocationRelativeTo(null);
        setVisible(true);

        backButton = new JButton("Back");
        backButton.setBounds(200, 300, 80, 30);
        backButton.addActionListener(this);
        add(backButton);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton && strn == "ClientHome") {
            setVisible(false);
            new ClientHome();
        }else if (ae.getSource() == backButton && strn == "ManagerPage") {
            setVisible(false);
            new ManagerPage();
        }
    }


    // public void actionPerformed(ActionEvent ee){
    //     if(ee.getSource() == submit){

    //     }else if(ee.getSource() == reset){

    //     }else if(ee.getSource() == cancle){
    //         setVisible(false);
    //     }
    // }

  

    public static void main(String args[]){
        new ManagerProfile("");
    }
}
