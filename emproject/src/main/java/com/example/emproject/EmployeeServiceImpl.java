// summerize: This code implements the EmployeeService interface to manage employee records in a Java application.
// It uses Spring's @Service annotation to indicate that this class is a service component.
// It interacts with the EmployeeRepository to perform CRUD operations on EmployeeEntity objects.
// The methods include creating a new employee, reading all employees, deleting an employee by ID,
// and updating an existing employee's details.
// The BeanUtils class is used to copy properties between Employee and EmployeeEntity objects.
// This implementation allows for the conversion between the Employee DTO and the EmployeeEntity JPA entity,
// facilitating the transfer of data between the service layer and the persistence layer.
// This class is annotated with @Service, making it a Spring-managed bean that can be injected into other components.
// It uses the EmployeeRepository to interact with the database and perform CRUD operations on EmployeeEntity objects.

package com.example.emproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createemployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Employee created successfully";
    }

    @Override
    public List<Employee> readEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity entity : employeeEntities) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(entity, employee);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public boolean  deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        employeeEntity.setName(employee.getName());
        employeeEntity.setPhone(employee.getPhone());  
        employeeEntity.setEmail(employee.getEmail());
        employeeRepository.save(employeeEntity);
        return "updated successfully";
    }
}
