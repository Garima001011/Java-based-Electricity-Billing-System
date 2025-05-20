import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {
    JButton btnGenerateBill;

    public Dashboard() {
        setTitle("Dashboard");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        btnGenerateBill = new JButton("Generate Bill");
        btnGenerateBill.setBounds(120, 50, 150, 40);

        btnGenerateBill.addActionListener(e -> new GenerateBill());

        add(btnGenerateBill);
        setVisible(true);
    }
}