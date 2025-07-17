package com.example.emproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestParam;


// sumerize: This controller handles HTTP requests related to Employee operations.
// It uses the EmployeeService to perform CRUD operations on Employee entities.
// It provides endpoints to create, read, update, and delete employees.
// The @RestController annotation indicates that this class is a controller where every method returns a domain object instead of a view.
// The @Autowired annotation is used to inject the EmployeeService dependency, allowing the controller to use its methods to interact with employee data.
// The @GetMapping, @PostMapping, @PutMapping, and @DeleteMapping annotations
// are used to map HTTP requests to specific methods in the controller, enabling the application to respond to GET, POST, PUT, and DELETE requests respectively.
// The @PathVariable annotation is used to extract values from the URI, allowing the controller to handle requests that include specific employee IDs.
// The @RequestBody annotation is used to bind the HTTP request body to a method parameter, allowing the controller to accept JSON data for creating or updating employees.

@RestController
public class EmpController {
    
    
    
    //EmployeeService employeeService = new EmployeeServiceImpl();
    //dependency injection

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployee();
    }

    @PostMapping("/employees")
    public String createemployee(@RequestBody Employee employee) {
        employeeService.createemployee(employee);
        return "save successfuly";
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if(employeeService.deleteEmployee(id))
            return "Deleted successfully";
        return "Employee not found";
       
    }

    @PutMapping("/employees/{id}")
    public String putMethodName(@PathVariable Long id,@RequestBody Employee employee) {
        return employeeService.updateEmployee(id,employee);
    }
    
}
