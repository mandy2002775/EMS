package service;

import model.Employee;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public boolean removeEmployeeById(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }

    public Employee searchById(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Employee> sortBySalary() {
        List<Employee> sorted = new ArrayList<>(employees);
        sorted.sort(Comparator.comparingDouble(Employee::getSalary));
        return sorted;
    }
}
