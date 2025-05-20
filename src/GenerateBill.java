import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class GenerateBill extends JFrame {
    JTextField tfMeter, tfName, tfMonth, tfUnits;
    JButton btnSubmit;

    public GenerateBill() {
        setTitle("Generate Bill");
        setSize(350, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        add(new JLabel("Meter No:")).setBounds(20, 30, 100, 25);
        tfMeter = new JTextField(); tfMeter.setBounds(120, 30, 150, 25); add(tfMeter);

        add(new JLabel("Customer Name:")).setBounds(20, 70, 100, 25);
        tfName = new JTextField(); tfName.setBounds(120, 70, 150, 25); add(tfName);

        add(new JLabel("Month:")).setBounds(20, 110, 100, 25);
        tfMonth = new JTextField(); tfMonth.setBounds(120, 110, 150, 25); add(tfMonth);

        add(new JLabel("Units Used:")).setBounds(20, 150, 100, 25);
        tfUnits = new JTextField(); tfUnits.setBounds(120, 150, 150, 25); add(tfUnits);

        btnSubmit = new JButton("Submit"); btnSubmit.setBounds(100, 200, 100, 30);
        btnSubmit.addActionListener(e -> insertBill());

        add(btnSubmit);
        setVisible(true);
    }

    void insertBill() {
        String meter = tfMeter.getText();
        String name = tfName.getText();
        String month = tfMonth.getText();
        int units = Integer.parseInt(tfUnits.getText());
        double amount = units * 7.5;

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO bills (meter_no, customer_name, month, units, amount) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, meter);
            ps.setString(2, name);
            ps.setString(3, month);
            ps.setInt(4, units);
            ps.setDouble(5, amount);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Bill Added Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}