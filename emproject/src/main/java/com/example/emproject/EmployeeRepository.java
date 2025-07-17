//summerize: This code defines a repository interface for managing EmployeeEntity objects in a Spring application.
// It extends JpaRepository, which provides methods for CRUD operations and query execution.
// The @Repository annotation indicates that this interface is a Spring Data repository.
package com.example.emproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmployeeRepository  extends JpaRepository<EmployeeEntity, Long>{

    //void save(EmployeeEntity employeeEntity);
   // List<EmployeeEntity> findByName(String name);
    
}
