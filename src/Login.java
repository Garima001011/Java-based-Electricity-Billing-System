import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {
    JTextField tfUser;
    JPasswordField pfPass;
    JButton btnLogin;

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tfUser = new JTextField();
        pfPass = new JPasswordField();
        btnLogin = new JButton("Login");

        setLayout(null);
        add(new JLabel("Username:")).setBounds(20, 30, 80, 25);
        add(tfUser).setBounds(100, 30, 150, 25);
        add(new JLabel("Password:")).setBounds(20, 70, 80, 25);
        add(pfPass).setBounds(100, 70, 150, 25);
        add(btnLogin).setBounds(100, 110, 80, 30);

        btnLogin.addActionListener(e -> login());

        setVisible(true);
    }

    void login() {
        String user = tfUser.getText();
        String pass = new String(pfPass.getPassword());

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dispose();
                new Dashboard();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}