import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// ---------- MODEL ----------
class ServiceModel {
    public static final int GENERAL = 1000, OIL = 800, BRAKE = 1200, BATTERY = 500;

    private String regNo, vehicleType;
    private boolean general, oil, brake, battery;

    public void setDetails(String regNo, String vehicleType,
                           boolean general, boolean oil, boolean brake, boolean battery) {
        this.regNo = regNo; this.vehicleType = vehicleType;
        this.general = general; this.oil = oil; this.brake = brake; this.battery = battery;
    }
    public String getRegNo() { return regNo; }
    public String getVehicleType() { return vehicleType; }
    public int calculateCost() {
        int total = 0;
        if (general) total += GENERAL;
        if (oil)     total += OIL;
        if (brake)   total += BRAKE;
        if (battery) total += BATTERY;
        return total;
    }
}

// ---------- VIEW ----------
class ServiceView extends JFrame {
    private JTextField regField = new JTextField(12);
    private JRadioButton twoWheeler = new JRadioButton("Two Wheeler", true);
    private JRadioButton car = new JRadioButton("Car");
    private JCheckBox general = new JCheckBox("General Service - \u20B91,000");
    private JCheckBox oil = new JCheckBox("Oil Change - \u20B9800");
    private JCheckBox brake = new JCheckBox("Brake Service - \u20B91,200");
    private JCheckBox battery = new JCheckBox("Battery Check - \u20B9500");
    private JButton calcButton = new JButton("Calculate Cost");
    private JLabel resultLabel = new JLabel("Total Cost: \u20B90");

    public ServiceView() {
        super("Vehicle Service Cost Estimator");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        ButtonGroup g = new ButtonGroup(); g.add(twoWheeler); g.add(car);

        JPanel p1 = new JPanel(); p1.add(new JLabel("Registration No:")); p1.add(regField);
        JPanel p2 = new JPanel(); p2.add(new JLabel("Vehicle Type:")); p2.add(twoWheeler); p2.add(car);
        JPanel p3 = new JPanel(new GridLayout(4, 1));
        p3.setBorder(BorderFactory.createTitledBorder("Select Services"));
        p3.add(general); p3.add(oil); p3.add(brake); p3.add(battery);
        JPanel p4 = new JPanel(); p4.add(calcButton);
        JPanel p5 = new JPanel(); resultLabel.setFont(new Font("SansSerif", Font.BOLD, 14)); p5.add(resultLabel);

        add(p1); add(p2); add(p3); add(p4); add(p5);
        setSize(380, 340);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public String getRegNo() { return regField.getText().trim(); }
    public String getVehicleType() { return twoWheeler.isSelected() ? "Two Wheeler" : "Car"; }
    public boolean isGeneral() { return general.isSelected(); }
    public boolean isOil() { return oil.isSelected(); }
    public boolean isBrake() { return brake.isSelected(); }
    public boolean isBattery() { return battery.isSelected(); }
    public void addCalculateListener(ActionListener l) { calcButton.addActionListener(l); }
    public void showResult(String text) { resultLabel.setText(text); }
    public void showError(String msg) { JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE); }
}

// ---------- CONTROLLER ----------
class ServiceController {
    private final ServiceModel model;
    private final ServiceView view;

    public ServiceController(ServiceModel model, ServiceView view) {
        this.model = model;
        this.view = view;
        view.addCalculateListener(e -> calculate());
    }

    private void calculate() {
        if (view.getRegNo().isEmpty()) { view.showError("Enter the vehicle registration number."); return; }
        model.setDetails(view.getRegNo(), view.getVehicleType(),
                view.isGeneral(), view.isOil(), view.isBrake(), view.isBattery());
        int cost = model.calculateCost();
        view.showResult(model.getRegNo() + " (" + model.getVehicleType() + ") - Total Cost: \u20B9" + cost);
    }
}

// ---------- MAIN ----------
public class VehicleServiceEstimator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ServiceView view = new ServiceView();
            new ServiceController(new ServiceModel(), view);
            view.setVisible(true);
        });
    }
}
