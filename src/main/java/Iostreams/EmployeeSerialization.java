package Iostreams;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + '\'' + ", department='" + department + '\'' + ", salary=" + salary + '}';
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.dat";

    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error: Unable to serialize employees.");
            e.printStackTrace();
        }
    }

    public static List<Employee> loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No saved employees found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: Unable to deserialize employees.");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 60000));
        employees.add(new Employee(3, "Charlie", "Finance", 70000));

        saveEmployees(employees);

        List<Employee> loadedEmployees = loadEmployees();
        System.out.println("Deserialized Employees:");
        for (Employee emp : loadedEmployees) {
            System.out.println(emp);
        }
    }
}

