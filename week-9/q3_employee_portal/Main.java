import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView login = new LoginView();
            new AppController(new AuthModel(), new EmployeeModel(), login);
            login.setVisible(true);
        });
    }
}
