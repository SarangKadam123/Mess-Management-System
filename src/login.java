import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class login extends JFrame implements ActionListener {

    JButton login, signup, cancel;
    JTextField username;
    JPasswordField password;

    // String url = "jdbc:mysql://localhost:3306/messdb";
    // String u = "root", p = "2115";
    Choice loggingin ;

    public login() {
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // UserName text 
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        usernamePanel.setPreferredSize(new Dimension(640, 50));
        JLabel lblusername = new JLabel("Username");
        username = new JTextField(15);
        usernamePanel.add(lblusername);
        usernamePanel.add(username);

        // Password text
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        passwordPanel.setPreferredSize(new Dimension(640, 50));
        JLabel lblpassword = new JLabel("Password");
        password = new JPasswordField(15);

        ImageIcon eye1 = new ImageIcon(ClassLoader.getSystemResource("icons/eyeClosed.png"));
        Image eyeClosed = eye1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon eye3 = new ImageIcon(ClassLoader.getSystemResource("icons/eyeOpen.png"));
        Image eye4 = eye3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);

        // JToggleButton showPasswordButton = new JToggleButton(new ImageIcon(eyeClosed));
        // showPasswordButton.setBorderPainted(false);
        // showPasswordButton.setBounds(375, 220, 10, 10);

        JLabel showPasswordButton = new JLabel(new ImageIcon(eyeClosed));

        
        showPasswordButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (password.getEchoChar() != 0) {
                    password.setEchoChar((char) 0);
                    showPasswordButton.setIcon(new ImageIcon(eye4)); // Show password
                } else {
                    password.setEchoChar('\u2022');
                    showPasswordButton.setIcon(new ImageIcon(eyeClosed)); // Hide password
                }
            }
        });

        passwordPanel.add(lblpassword);
        passwordPanel.add(password);
        passwordPanel.add(showPasswordButton);

        // Logging in as
        JPanel loginAsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel logginginas = new JLabel("Logging in as");
        loginAsPanel.setPreferredSize(new Dimension(640, 50));
        loggingin = new Choice();
        loggingin.add("Client");
        loggingin.add("Manager");
        loginAsPanel.add(logginginas);
        loginAsPanel.add(loggingin);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        login = new JButton("Login");
        login.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        buttonPanel.add(login);
        buttonPanel.add(cancel);

        // Sign Up
        JPanel signUpPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel txt = new JLabel("Don't have account ? ");
        JLabel signupLabel = new JLabel("Sign Up");
        signupLabel.setForeground(Color.BLUE);
        signupLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signupLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                signUp signUpPage = new signUp();
                setVisible(false);
                signUpPage.setVisible(true);
            }
        });
        signUpPanel.add(txt);
        signUpPanel.add(signupLabel);

        centerPanel.add(usernamePanel);
        centerPanel.add(passwordPanel);
        centerPanel.add(loginAsPanel);
        centerPanel.add(buttonPanel);
        centerPanel.add(signUpPanel);

        add(centerPanel, BorderLayout.CENTER);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/UserLogo.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        add(image, BorderLayout.WEST);

         // Add mainPanel to the center of the JFrame
         add(mainPanel, BorderLayout.CENTER);

        //  // Adjust size of mainPanel to fill available space
        mainPanel.setPreferredSize(new Dimension(400, 300));
        mainPanel.add(centerPanel);
        add(mainPanel);
        setBounds(400, 200, 640, 300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login ) {
            if (loggingin.getSelectedItem() == "Client") {
                // String userid = username.getText();
                // char[] chars = password.getPassword();
                // String pass = new String(chars);
                // String query = "SELECT * FROM Client WHERE username=? AND password=?";

                // try (Connection connection = DriverManager.getConnection(url, u, p);
                //         PreparedStatement ps = connection.prepareStatement(query)) {
                //     ps.setString(1, userid);
                //     ps.setString(2, pass);

                //     ResultSet resultSet = ps.executeQuery();

                //     if (resultSet.next()) {
                //         JOptionPane.showMessageDialog(this, "Login Successful!");
                        new ClientHome();
                        setVisible(false);
                //     } else {
                //         JOptionPane.showMessageDialog(this, "Invalid username or password.\nPlease try again.");
                //     }
                // } catch (SQLException e) {
                //     e.printStackTrace();
                // }

            }else  if(loggingin.getSelectedItem()=="Manager"){
                new ManagerPage();
                setVisible(false);
            }
            
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
