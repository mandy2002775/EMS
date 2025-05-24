package model;

/**
 * RegularEmployee class represents a full-time regular employee.
 * Inherits properties from the Employee base class.
 */
public class RegularEmployee extends Employee {
    
    // Constructor
    public RegularEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    // Additional RegularEmployee-specific methods can go here in the future
}
