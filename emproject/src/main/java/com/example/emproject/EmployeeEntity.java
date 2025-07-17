package com.example.emproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
// The EmployeeEntity class represents the JPA entity for the Employee table in the database.
@Data // The @Data annotation is a part of Lombok, which reduces boilerplate code in Java
@Entity // The @Entity annotation indicates that this class is a JPA entity
@Table(name = "employees_db1") // The @Table annotation specifies the name of the database table to which this entity is mapped
public class EmployeeEntity {

    @Id // The @Id annotation specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // The @GeneratedValue annotation indicates that the primary key will be generated automatically
    private Long id;
    
    private String name;
    private String phone;
    private String email;
}
