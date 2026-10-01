public class StudentModel {
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
