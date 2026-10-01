import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GradeView extends JFrame {
    private JTextField nameField = new JTextField(15);
    private JTextField[] marks = { new JTextField(5), new JTextField(5), new JTextField(5) };
    private JButton calcButton = new JButton("Calculate Result");
    private JLabel totalLabel = new JLabel("Total: -");
    private JLabel avgLabel = new JLabel("Average: -");
    private JLabel gradeLabel = new JLabel("Grade: -");

    public GradeView() {
        super("Student Grade Calculator");
        setLayout(new GridLayout(8, 2, 5, 5));
        add(new JLabel("Student Name:")); add(nameField);
        for (int i = 0; i < 3; i++) { add(new JLabel("Subject " + (i + 1) + " Marks:")); add(marks[i]); }
        add(new JLabel()); add(calcButton);
        add(totalLabel); add(new JLabel());
        add(avgLabel);   add(new JLabel());
        add(gradeLabel); add(new JLabel());
        setSize(380, 330);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public String getNameInput() { return nameField.getText().trim(); }
    public String getMark(int i) { return marks[i].getText().trim(); }
    public void addCalculateListener(ActionListener l) { calcButton.addActionListener(l); }
    public void showResult(String name, double total, double avg, String grade) {
        totalLabel.setText("Total: " + total);
        avgLabel.setText(String.format("Average: %.2f", avg));
        gradeLabel.setText("Grade: " + grade + "  (" + name + ")");
    }
    public void showError(String msg) { JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE); }
}
