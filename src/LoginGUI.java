import javax.swing.*;
import java.sql.*;

/**
 * Login interface for the hotel system.
 */
public class LoginGUI {

    /**
     * Creates the login window.
     */
    public LoginGUI() {

        LoginService service = new LoginService();

        JFrame frame = new JFrame("Hotel Login");
        frame.setSize(350, 250);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(30, 30, 100, 25);
        frame.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(130, 30, 150, 25);
        frame.add(userField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(30, 70, 100, 25);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(130, 70, 150, 25);
        frame.add(passField);

        JButton login = new JButton("Login");
        login.setBounds(110, 120, 100, 30);
        frame.add(login);

        login.addActionListener(e -> {

            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (service.login(username, password)) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Login Successful"
                );

                frame.dispose();

                new HotelGUI();

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Username or Password"
                );
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
