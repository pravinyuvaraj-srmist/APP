class Patient {
    String patientName;
    double consultationFee;
    Patient(String patientName, double consultationFee) {
        this.patientName = patientName;
        this.consultationFee = consultationFee;
    }
    double calculateFinalAmount(double fee) {
        double discount;
        if (fee >= 2000) {
            discount = fee * 0.10;
        } else {
            discount = fee * 0.05;
        }
        return fee - discount;
    }
    void display() {
        double discount;
        if (consultationFee >= 2000) {
            discount = consultationFee * 0.10;
        } else {
            discount = consultationFee * 0.05;
        }
        double finalAmount = calculateFinalAmount(consultationFee);
        System.out.println("Patient Name          : " + patientName);
        System.out.println("Original Consultation : ₹" + consultationFee);
        System.out.println("Discount              : ₹" + discount);
        System.out.println("Final Amount          : ₹" + finalAmount);
        System.out.println("-----------------------------------");
    }
}
public class Main {
    public static void main(String[] args) {
        Patient[] patients = new Patient[5];
        patients[0] = new Patient("Arun", 2500);
        patients[1] = new Patient("Bala", 1800);
        patients[2] = new Patient("Charan", 3000);
        patients[3] = new Patient("David", 1500);
        patients[4] = new Patient("Ezhil", 2000);
        System.out.println("===== HOSPITAL CONSULTATION BILL =====");
        for (int i = 0; i < 5; i++) {
            patients[i].display();
        }
    }
}
