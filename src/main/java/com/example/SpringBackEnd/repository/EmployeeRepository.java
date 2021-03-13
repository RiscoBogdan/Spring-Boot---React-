package com.example.SpringBackEnd.repository;

import com.example.SpringBackEnd.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//exposes DataBase methods
//find by id, find or delete by id, delete etc methods

//<Jpa Entity, the type of the PrimaryKey>
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
