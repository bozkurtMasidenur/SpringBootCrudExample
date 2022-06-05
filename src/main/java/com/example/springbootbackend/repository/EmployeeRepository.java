package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    @Query(value = "select e.id, e.firmaId, e.firstname, e.lastname, e.email from employees as e INNER JOIN companies as c on e.firmaId=c.firmaId", nativeQuery=true)
    List<Object[]> findEmployee();
}
