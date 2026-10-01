public class ServiceController {
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
