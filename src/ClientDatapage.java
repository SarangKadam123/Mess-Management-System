import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;

public class ClientDatapage extends JFrame implements ActionListener{
    JButton submit, reset, cancle, backButton;
    ClientDatapage(){
        super("This Months Transactions");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Date");
        model.addColumn("Menu");
        model.addColumn("Amount");
        model.addRow(new Object[]{12,"Dal Rice Roti", 10});
        model.addRow(new Object[]{12,"Dal Rice Roti", 10});

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
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton ) {
            setVisible(false);
            new ClientHome();
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
        new ClientDatapage();
    }
}
