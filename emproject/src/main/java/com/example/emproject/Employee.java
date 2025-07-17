package com.example.emproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//summerize: This class represents an Employee with fields for id, name, phone, and email.
//It uses Lombok annotations to generate boilerplate code like getters, setters, and constructors.
// The @Data annotation generates getters and setters for all fields, as well as equals, hashCode, and toString methods.
// The @NoArgsConstructor annotation generates a no-argument constructor, and the @AllArgsConstructor annotation generates a constructor with all fields as parameters.
// This class is used to transfer employee data between the client and server in a structured way.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String phone;
    private String email;
}
