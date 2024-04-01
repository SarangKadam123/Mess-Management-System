import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class ManagerEdit extends JFrame implements ActionListener{
    JButton submit, reset, cancle;


    ManagerEdit(){
        super("ManagerEdit");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //UserID lable
        JLabel lblUserId = new JLabel("ID ");
        lblUserId.setBounds(170,20,50,20);
        add(lblUserId);

        //UserID field
        JLabel UserId = new JLabel("MGR12345");
        UserId.setBounds(270,20,200,20);
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

        
        //email lable 
        JLabel lbl_UPIid = new JLabel("UPI ID ");
        lbl_UPIid.setBounds(170,220,50,20);
        add(lbl_UPIid);

        //email field
        JTextField UPIid = new JTextField();
        UPIid.setBounds(270,220,200,20);
        add(UPIid);


        JButton ManagerEditButton = new JButton("Save");
        ManagerEditButton.setBounds(250,280,100,30);
        ManagerEditButton.setBackground(Color.YELLOW );
        Border bdr = BorderFactory.createEmptyBorder();;
        ManagerEditButton.setBorder(bdr);
        ManagerEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Edited Successfuly!");
                setVisible(false);
                new ManagerPage();
            }
        });
        add(ManagerEditButton);



        setBounds(450, 200, 600, 400);
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




    public static void main(String args[]){
        new ManagerEdit();
    }
}
