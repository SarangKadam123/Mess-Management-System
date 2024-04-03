import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class setMenu extends JFrame implements ActionListener {
    JButton submit, add, reset, backButton, removeButton;
    JTextField itemNameField, priceField;
    DefaultTableModel model;
    JTable table;

    setMenu() {
        super("Set Menu");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        model = new DefaultTableModel();
        model.addColumn("Item");
        model.addColumn("Price");
        model.addRow(new Object[]{"Roti", 10});
        model.addRow(new Object[]{"Rice", 20});

        table = new JTable(model);
        table.setBorder(null);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 50, 500, 400);
        add(scrollPane);

        JLabel itemNameLabel = new JLabel("Item:");
        itemNameLabel.setBounds(10, 10, 80, 30);
        add(itemNameLabel);

        itemNameField = new JTextField();
        itemNameField.setBounds(100, 10, 150, 30);
        add(itemNameField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(270, 10, 80, 30);
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(350, 10, 100, 30);
        add(priceField);

        add = new JButton("Add");
        add.setBounds(100, 500, 80, 30);
        add.addActionListener(this);
        add(add);

        removeButton = new JButton("Remove");
        removeButton.setBounds(200, 500, 100, 30);
        removeButton.addActionListener(this);
        add(removeButton);

        backButton = new JButton("Back");
        backButton.setBounds(320, 500, 80, 30);
        backButton.addActionListener(this);
        add(backButton);

        setBounds(500, 200, 500, 600);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            setVisible(false);
            new ManagerPage();
        } else if (ae.getSource() == add) {
            String itemName = itemNameField.getText();
            String price = priceField.getText();
            model.addRow(new Object[]{itemName, price});
            itemNameField.setText("");
            priceField.setText("");
        } else if (ae.getSource() == removeButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to remove.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String args[]) {
        new setMenu();
    }
}
