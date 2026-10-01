public class ServiceModel {
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
