import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;

public class SeeMenu extends JFrame implements ActionListener{
    JButton submit, reset, cancle, backButton;
    String strn = "";
    SeeMenu(String str){
        super("Today's Menu");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        strn = str;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Item");
        model.addColumn("Price");
        model.addRow(new Object[]{"Roti", 10});
        model.addRow(new Object[]{"Rice", 20});

        JTable table = new JTable(model);
        table.setBorder(null);

         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 50, 500, 400);
        add(scrollPane);
        
        backButton = new JButton("Back");
        backButton.setBounds(200, 500, 80, 30);
        backButton.addActionListener(this);
        add(backButton);

        setBounds(500, 200, 500, 600);
        setVisible(true);
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
        new SeeMenu("");
    }
}
