package ui;

import model.*;
import service.EmployeeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUIInterface {
    private EmployeeManager manager;

    // Components
    private JFrame frame;
    private JTextField idField, nameField, salaryField, searchIdField, deleteIdField;
    private JComboBox<String> roleComboBox;
    private JTextArea outputArea;

    public GUIInterface(EmployeeManager manager) {
        this.manager = manager;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Employee Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Employee"));

        idField = new JTextField();
        nameField = new JTextField();
        salaryField = new JTextField();
        roleComboBox = new JComboBox<>(new String[]{"Manager", "Intern", "Regular"});

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Salary:"));
        inputPanel.add(salaryField);
        inputPanel.add(new JLabel("Role:"));
        inputPanel.add(roleComboBox);

        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(this::addEmployee);
        inputPanel.add(addButton);

        JButton displayButton = new JButton("Display All");
        displayButton.addActionListener(this::displayAllEmployees);
        inputPanel.add(displayButton);

        // Search & Delete Panel
        JPanel searchDeletePanel = new JPanel(new GridLayout(2, 3, 5, 5));
        searchDeletePanel.setBorder(BorderFactory.createTitledBorder("Search / Delete"));

        searchIdField = new JTextField();
        JButton searchButton = new JButton("Search by ID");
        searchButton.addActionListener(this::searchEmployee);

        deleteIdField = new JTextField();
        JButton deleteButton = new JButton("Delete by ID");
        deleteButton.addActionListener(this::deleteEmployee);

        searchDeletePanel.add(new JLabel("Search ID:"));
        searchDeletePanel.add(searchIdField);
        searchDeletePanel.add(searchButton);

        searchDeletePanel.add(new JLabel("Delete ID:"));
        searchDeletePanel.add(deleteIdField);
        searchDeletePanel.add(deleteButton);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(searchDeletePanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addEmployee(ActionEvent e) {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            double salary = Double.parseDouble(salaryField.getText().trim());
            String role = (String) roleComboBox.getSelectedItem();

            Employee emp;
            switch (role.toLowerCase()) {
                case "manager":
                    emp = new Manager(id, name, salary);
                    break;
                case "intern":
                    emp = new Intern(id, name, salary);
                    break;
                default:
                    emp = new RegularEmployee(id, name, salary);
            }

            manager.addEmployee(emp);
            outputArea.setText("✅ Employee added successfully.");
            clearInputFields();
        } catch (Exception ex) {
            outputArea.setText("❌ Error: Invalid input.");
        }
    }

    private void searchEmployee(ActionEvent e) {
        try {
            int id = Integer.parseInt(searchIdField.getText().trim());
            Employee emp = manager.searchById(id);
            outputArea.setText(emp != null ? emp.toString() : "❌ Employee not found.");
        } catch (Exception ex) {
            outputArea.setText("❌ Invalid ID format.");
        }
    }

    private void deleteEmployee(ActionEvent e) {
        try {
            int id = Integer.parseInt(deleteIdField.getText().trim());
            boolean removed = manager.removeEmployeeById(id);
            outputArea.setText(removed ? "✅ Employee deleted." : "❌ Employee not found.");
        } catch (Exception ex) {
            outputArea.setText("❌ Invalid ID format.");
        }
    }

    private void displayAllEmployees(ActionEvent e) {
        StringBuilder sb = new StringBuilder("📋 All Employees:\n");
        for (Employee emp : manager.getAllEmployees()) {
            sb.append(emp).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    private void clearInputFields() {
        idField.setText("");
        nameField.setText("");
        salaryField.setText("");
    }
}
