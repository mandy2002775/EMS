# Employee Management System (EMS)

This project is a **Java-based Employee Management System** developed as part of an academic assignment. It allows users to manage different types of employees (Interns, Managers, and Regular Employees) through a console or GUI interface.

## 📁 Project Structure
EMS/
├── src/
│   ├── app/
│   │   └── MainApp.java
│   ├── employee/
│   │   ├── Employee.java
│   │   ├── Intern.java
│   │   ├── Manager.java
│   │   └── RegularEmployee.java
│   ├── manager/
│   │   └── EmployeeManager.java
│   ├── interface/
│   │   ├── ConsoleInterface.java
│   │   └── UIInterface.java

 **Features**

- ✅ Add new employees
- ✅ Remove employees by ID
- ✅ View list of all employees
- ✅ Sort employees (by name, ID, or salary)
- ✅ GUI and console interface options


## 💻 Technologies Used

- Java (JDK 8+)
- Eclipse IDE
- OOP principles (inheritance, polymorphism)
- Java Collections (ArrayList)
- Optional: Swing for GUI


##  How to Run the Project

### 🔧 Requirements

- Java JDK 8 or higher
- Eclipse IDE (or any Java IDE)

### ▶️ Steps

1. **Clone the repository:**

   ```bash
   git clone https://github.com/mandy2002775/EMS.git
````

2. **Open the project in Eclipse:**

   * Go to `File > Import > Existing Projects into Workspace`
   * Select the cloned EMS folder

3. **Run the application:**

   * Navigate to `app/MainApp.java`
   * Right-click and select `Run As > Java Application`

---

##  Usage

When you run the application:

* A menu will appear in the console or GUI (based on your implementation).
* You can perform operations like:

  * Adding an employee
  * Viewing all employees
  * Sorting employees
  * Exiting the program

---

## 🗃️ Classes Overview

| Class Name         | Description                                       |
| ------------------ | ------------------------------------------------- |
| `Employee`         | Abstract base class for all employees             |
| `Intern`           | Represents intern employees                       |
| `Manager`          | Represents manager-level employees                |
| `RegularEmployee`  | Represents standard full-time employees           |
| `EmployeeManager`  | Handles the list of employees (add, remove, sort) |
| `ConsoleInterface` | Manages user input/output through the console     |
| `UIInterface`      | Provides a graphical user interface (optional)    |
| `MainApp`          | Entry point of the application                    |

---

## 📷 Screenshots
> ![Console Menu](screenshots/menu.png)
![image](https://github.com/user-attachments/assets/e4f8d0c8-fe81-40db-8817-5b86acb95305)
GUI SCREENSHOT:
![image](https://github.com/user-attachments/assets/74801929-e41c-4f93-ad66-9794c7739c9b)

This project is for academic use only. No commercial use is allowed without permission.



## 🙋 Author

* **Name:** MANDIP THAPALIYA
* **GitHub:** [mandy2002775](https://github.com/mandy2002775)

