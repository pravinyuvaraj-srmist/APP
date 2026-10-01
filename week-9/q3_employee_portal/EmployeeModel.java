import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    private final List<Employee> employees = new ArrayList<>();

    public boolean exists(String id) {
        for (Employee e : employees) if (e.getId().equals(id)) return true;
        return false;
    }
    public void add(Employee e) { employees.add(e); }
    public List<Employee> getAll() { return employees; }
}
