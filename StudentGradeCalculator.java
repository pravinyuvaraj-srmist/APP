import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// ---------- MODEL ----------
class StudentModel {
    private String name;
    private double m1, m2, m3;

    public void setStudent(String name, double m1, double m2, double m3) {
        this.name = name; this.m1 = m1; this.m2 = m2; this.m3 = m3;
    }
    public String getName()  { return name; }
    public double getTotal() { return m1 + m2 + m3; }
    public double getAverage() { return getTotal() / 3.0; }
    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }
}

// ---------- VIEW ----------
class GradeView extends JFrame {
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

// ---------- CONTROLLER ----------
class GradeController {
    private final StudentModel model;
    private final GradeView view;

    public GradeController(StudentModel model, GradeView view) {
        this.model = model;
        this.view = view;
        view.addCalculateListener(e -> calculate());
    }

    private void calculate() {
        try {
            String name = view.getNameInput();
            if (name.isEmpty()) { view.showError("Please enter the student name."); return; }
            double[] m = new double[3];
            for (int i = 0; i < 3; i++) {
                m[i] = Double.parseDouble(view.getMark(i));
                if (m[i] < 0 || m[i] > 100) { view.showError("Marks must be between 0 and 100."); return; }
            }
            model.setStudent(name, m[0], m[1], m[2]);
            view.showResult(model.getName(), model.getTotal(), model.getAverage(), model.getGrade());
        } catch (NumberFormatException ex) {
            view.showError("Please enter valid numeric marks.");
        }
    }
}

// ---------- MAIN ----------
public class StudentGradeCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeView view = new GradeView();
            new GradeController(new StudentModel(), view);
            view.setVisible(true);
        });
    }
}
