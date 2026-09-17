import doctor.Doctor;
import patient.Patient;

public class HospitalManagement {
    public static void main(String[] args) {
        Doctor d1 = new Doctor(101, "Dr. Kumar", "Cardiologist", 1000);
        Doctor d2 = new Doctor(102, "Dr. Priya", "Dermatologist", 800);

        Patient p1 = new Patient(201, "Arun", "Heart Disease", 45);
        Patient p2 = new Patient(202, "Ravi", "Skin Allergy", 30);
        Patient p3 = new Patient(203, "Kiran", "Heart Disease", 50);

        System.out.println("===== PATIENT 1 =====");
        p1.display();
        System.out.println("\nTreating Doctor:");
        d1.display();

        System.out.println("\n===== PATIENT 2 =====");
        p2.display();
        System.out.println("\nTreating Doctor:");
        d2.display();

        System.out.println("\n===== PATIENT 3 =====");
        p3.display();
        System.out.println("\nTreating Doctor:");
        d1.display();

        double totalD1 = 2 * d1.getConsultationFee();
        double totalD2 = 1 * d2.getConsultationFee();

        System.out.println("\n===== CONSULTATION FEE =====");
        System.out.println(d1.getName() + " collected: Rs." + totalD1);
        System.out.println(d2.getName() + " collected: Rs." + totalD2);
    }
}
