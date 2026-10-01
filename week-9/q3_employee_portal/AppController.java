import javax.swing.JOptionPane;

public class AppController {
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
