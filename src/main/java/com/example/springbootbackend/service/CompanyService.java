package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Company;

import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);
    List<Company> getAllCompany();
    Company getCompanyById(long id);
    Company updateCompany(Company company, long id);
    void deleteCompany(long id);
}
