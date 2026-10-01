import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeView view = new GradeView();
            new GradeController(new StudentModel(), view);
            view.setVisible(true);
        });
    }
}
