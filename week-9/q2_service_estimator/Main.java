import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ServiceView view = new ServiceView();
            new ServiceController(new ServiceModel(), view);
            view.setVisible(true);
        });
    }
}
