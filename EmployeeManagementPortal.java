import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// ---------- MODEL ----------
class Employee {
    private final String id, name, department;
    public Employee(String id, String name, String department) {
        this.id = id; this.name = name; this.department = department;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    @Override public String toString() { return id + " | " + name + " | " + department; }
}

class AuthModel {
    private final String username = "admin";
    private String password = "admin123";

    public boolean validate(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }
    public boolean checkOldPassword(String old) { return password.equals(old); }
    public void changePassword(String newPass) { this.password = newPass; }
}

class EmployeeModel {
    private final List<Employee> employees = new ArrayList<>();

    public boolean exists(String id) {
        for (Employee e : employees) if (e.getId().equals(id)) return true;
        return false;
    }
    public void add(Employee e) { employees.add(e); }
    public List<Employee> getAll() { return employees; }
}

// ---------- VIEW ----------
class LoginView extends JFrame {
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

class MainView extends JFrame {
    private JMenuItem addItem = new JMenuItem("Add Employee");
    private JMenuItem viewItem = new JMenuItem("View Employee");
    private JMenuItem changePwdItem = new JMenuItem("Change Password");
    private JMenuItem logoutItem = new JMenuItem("Logout");
    private JMenuItem exitItem = new JMenuItem("Exit Application");

    private CardLayout cards = new CardLayout();
    private JPanel content = new JPanel(cards);

    // Add Employee panel
    private JTextField idField = new JTextField(12), nameField = new JTextField(12), deptField = new JTextField(12);
    private JButton saveButton = new JButton("Save Employee");
    // View Employee panel
    private JTextArea listArea = new JTextArea();
    // Change Password panel
    private JPasswordField oldPass = new JPasswordField(12), newPass = new JPasswordField(12), confPass = new JPasswordField(12);
    private JButton changeButton = new JButton("Change Password");

    public MainView() {
        super("Employee Management Portal");
        JMenuBar bar = new JMenuBar();
        JMenu employee = new JMenu("Employee"); employee.add(addItem); employee.add(viewItem);
        JMenu tools = new JMenu("Tools"); tools.add(changePwdItem);
        JMenu exit = new JMenu("Exit"); exit.add(logoutItem); exit.add(exitItem);
        bar.add(employee); bar.add(tools); bar.add(exit);
        setJMenuBar(bar);

        JPanel welcome = new JPanel(new BorderLayout());
        welcome.add(new JLabel("Welcome, Admin! Choose an option from the menu.", SwingConstants.CENTER));

        JPanel addPanel = new JPanel(new GridLayout(4, 2, 5, 10));
        addPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        addPanel.add(new JLabel("Employee ID:")); addPanel.add(idField);
        addPanel.add(new JLabel("Employee Name:")); addPanel.add(nameField);
        addPanel.add(new JLabel("Department:")); addPanel.add(deptField);
        addPanel.add(new JLabel()); addPanel.add(saveButton);

        listArea.setEditable(false);
        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.add(new JScrollPane(listArea));

        JPanel pwdPanel = new JPanel(new GridLayout(4, 2, 5, 10));
        pwdPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pwdPanel.add(new JLabel("Old Password:")); pwdPanel.add(oldPass);
        pwdPanel.add(new JLabel("New Password:")); pwdPanel.add(newPass);
        pwdPanel.add(new JLabel("Confirm Password:")); pwdPanel.add(confPass);
        pwdPanel.add(new JLabel()); pwdPanel.add(changeButton);

        content.add(welcome, "welcome"); content.add(addPanel, "add");
        content.add(viewPanel, "view");  content.add(pwdPanel, "pwd");
        add(content);
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void show(String card) { cards.show(content, card); }

    public void addMenuListeners(ActionListener add, ActionListener view, ActionListener pwd,
                                 ActionListener logout, ActionListener exit) {
        addItem.addActionListener(add); viewItem.addActionListener(view);
        changePwdItem.addActionListener(pwd); logoutItem.addActionListener(logout); exitItem.addActionListener(exit);
    }
    public void addSaveListener(ActionListener l) { saveButton.addActionListener(l); }
    public void addChangePasswordListener(ActionListener l) { changeButton.addActionListener(l); }

    public String getId() { return idField.getText().trim(); }
    public String getEmpName() { return nameField.getText().trim(); }
    public String getDept() { return deptField.getText().trim(); }
    public void clearEmployeeForm() { idField.setText(""); nameField.setText(""); deptField.setText(""); }
    public void setEmployeeList(String text) { listArea.setText(text); }

    public String getOld() { return new String(oldPass.getPassword()); }
    public String getNew() { return new String(newPass.getPassword()); }
    public String getConfirm() { return new String(confPass.getPassword()); }
    public void clearPasswordForm() { oldPass.setText(""); newPass.setText(""); confPass.setText(""); }

    public void showMessage(String msg, String title, int type) { JOptionPane.showMessageDialog(this, msg, title, type); }
}

// ---------- CONTROLLER ----------
class AppController {
    private final AuthModel auth;
    private final EmployeeModel empModel;
    private final LoginView loginView;
    private MainView mainView;

    public AppController(AuthModel auth, EmployeeModel empModel, LoginView loginView) {
        this.auth = auth;
        this.empModel = empModel;
        this.loginView = loginView;
        loginView.addLoginListener(e -> login());
    }

    private void login() {
        if (auth.validate(loginView.getUsername(), loginView.getPassword())) {
            loginView.showMessage("Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loginView.setVisible(false);
            openMainWindow();
        } else {
            loginView.showMessage("Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            loginView.clearPassword();
        }
    }

    private void openMainWindow() {
        mainView = new MainView();
        mainView.addMenuListeners(
            e -> mainView.show("add"),
            e -> { showEmployees(); mainView.show("view"); },
            e -> mainView.show("pwd"),
            e -> logout(),
            e -> System.exit(0));
        mainView.addSaveListener(e -> saveEmployee());
        mainView.addChangePasswordListener(e -> changePassword());
        mainView.setVisible(true);
    }

    private void saveEmployee() {
        String id = mainView.getId(), name = mainView.getEmpName(), dept = mainView.getDept();
        if (id.isEmpty() || name.isEmpty() || dept.isEmpty()) {
            mainView.showMessage("All fields are required.", "Error", JOptionPane.ERROR_MESSAGE); return;
        }
        if (empModel.exists(id)) {
            mainView.showMessage("Employee ID already exists.", "Error", JOptionPane.ERROR_MESSAGE); return;
        }
        empModel.add(new Employee(id, name, dept));
        mainView.showMessage("Employee added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        mainView.clearEmployeeForm();
    }

    private void showEmployees() {
        StringBuilder sb = new StringBuilder("ID | Name | Department\n---------------------------\n");
        for (Employee e : empModel.getAll()) sb.append(e).append("\n");
        if (empModel.getAll().isEmpty()) sb.append("(no employees added yet)");
        mainView.setEmployeeList(sb.toString());
    }

    private void changePassword() {
        String o = mainView.getOld(), n = mainView.getNew(), c = mainView.getConfirm();
        if (!auth.checkOldPassword(o)) {
            mainView.showMessage("Old password is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (n.isEmpty()) {
            mainView.showMessage("New password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!n.equals(c)) {
            mainView.showMessage("New and Confirm passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            auth.changePassword(n);
            mainView.showMessage("Password changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            mainView.clearPasswordForm();
        }
    }

    private void logout() {
        mainView.dispose();
        loginView.clearPassword();
        loginView.setVisible(true);
    }
}

// ---------- MAIN ----------
public class EmployeeManagementPortal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView login = new LoginView();
            new AppController(new AuthModel(), new EmployeeModel(), login);
            login.setVisible(true);
        });
    }
}
