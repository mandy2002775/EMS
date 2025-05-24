package ui;

import model.Employee;
import model.Intern;
import model.Manager;
import model.RegularEmployee;
import service.EmployeeManager;

import java.util.Scanner;

public class ConsoleInterface {
    private EmployeeManager manager;
    private Scanner scanner;

    public ConsoleInterface(EmployeeManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee by ID");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    displayEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private void addEmployee() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Role (Manager/Intern/Regular): ");
            String role = scanner.nextLine().toLowerCase();

            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Employee emp;
            switch (role) {
                case "manager":
                    emp = new Manager(id, name, salary);
                    break;
                case "intern":
                    emp = new Intern(id, name, salary);
                    break;
                default:
                    emp = new RegularEmployee(id, name, salary);
                    break;
            }

            manager.addEmployee(emp);
            System.out.println("Employee added successfully!");

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
        }
    }

    private void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            boolean removed = manager.removeEmployeeById(id);
            System.out.println(removed ? "Deleted successfully." : "Employee not found.");
        } catch (Exception e) {
            System.out.println("Invalid ID format.");
        }
    }

    private void searchEmployee() {
        System.out.print("Enter ID to search: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Employee emp = manager.searchById(id);
            System.out.println(emp != null ? emp : "Employee not found.");
        } catch (Exception e) {
            System.out.println("Invalid ID format.");
        }
    }

    private void displayEmployees() {
        System.out.println("All Employees:");
        for (Employee emp : manager.getAllEmployees()) {
            System.out.println(emp);
        }
    }
}
