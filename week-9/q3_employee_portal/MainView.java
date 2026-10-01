import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
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
