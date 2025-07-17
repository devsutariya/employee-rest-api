// summerize: This code defines an interface for employee services in a Java application.
// It declares methods for creating, reading, deleting, and updating employee records.
package com.example.emproject;

//import com.example.em_project.Employee;
import java.util.List;

public interface EmployeeService {
   String createemployee(Employee employee);
   List<Employee> readEmployee();
   boolean deleteEmployee(Long id);
   String updateEmployee(Long id,Employee employee);
}
