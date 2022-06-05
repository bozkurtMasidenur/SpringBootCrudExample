package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import com.example.springbootbackend.service.EmployeeService;

import com.example.springbootbackend.model.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        //Optional<Employee> employee= employeeRepository.findBy(id);
        //if(employee.isPresent()){
        //    return employee.get();
        //}else {
        //    throw new ResourceNotFoundException("Employee", "Id", "id");
        //}
        return employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee", "Id", "id"));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //we need to check whether employee with given id is exist in DB or not
        Employee existingEmployee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", "id"));
        existingEmployee.setFirstname(employee.getFirstname());
        existingEmployee.setLastname(employee.getLastname());
        existingEmployee.setFirmaId(employee.getId());
        existingEmployee.setEmail(employee.getEmail());
        //save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //check whether a employee exiist in a DB or not
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", "id"));

        employeeRepository.deleteById(id);
    }


}
