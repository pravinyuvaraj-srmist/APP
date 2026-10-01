public class GradeController {
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
