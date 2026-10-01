public class Employee {
    private final String id, name, department;
    public Employee(String id, String name, String department) {
        this.id = id; this.name = name; this.department = department;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    @Override public String toString() { return id + " | " + name + " | " + department; }
}
