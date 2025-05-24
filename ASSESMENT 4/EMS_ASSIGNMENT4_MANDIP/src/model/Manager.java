package model;

/**
 * Manager class represents an employee with a managerial role.
 * Inherits properties from the Employee base class.
 */
public class Manager extends Employee {
    
    // Constructor
    public Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    // Additional Manager-specific methods can go here in the future
}
