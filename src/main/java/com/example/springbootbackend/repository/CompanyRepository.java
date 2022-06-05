package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
