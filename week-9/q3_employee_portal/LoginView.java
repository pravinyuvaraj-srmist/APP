import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField userField = new JTextField(15);
    private JPasswordField passField = new JPasswordField(15);
    private JButton loginButton = new JButton("Login");

    public LoginView() {
        super("Employee Management Portal - Login");
        setLayout(new GridLayout(3, 2, 5, 10));
        add(new JLabel("  Username:")); add(userField);
        add(new JLabel("  Password:")); add(passField);
        add(new JLabel()); add(loginButton);
        setSize(340, 160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public String getUsername() { return userField.getText().trim(); }
    public String getPassword() { return new String(passField.getPassword()); }
    public void clearPassword() { passField.setText(""); }
    public void addLoginListener(ActionListener l) { loginButton.addActionListener(l); }
    public void showMessage(String msg, String title, int type) { JOptionPane.showMessageDialog(this, msg, title, type); }
}
