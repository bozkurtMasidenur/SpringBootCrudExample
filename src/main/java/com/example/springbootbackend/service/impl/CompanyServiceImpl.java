package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Company;

import com.example.springbootbackend.repository.CompanyRepository;

import com.example.springbootbackend.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        super();
        this.companyRepository = companyRepository;
    }

    @Override
    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Company", "Id", "id"));
    }

    @Override
    public Company updateCompany(Company company, long id) {
        //we need to check whether employee with given id is exist in DB or not
        Company existingCompany= companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company", "Id", "id"));
        existingCompany.setFirmaId(company.getFirmaId());
        existingCompany.setCompanyName(company.getCompanyName());
        existingCompany.setAddress(company.getAddress());
        //save existing employee to DB
        companyRepository.save(existingCompany);
        return existingCompany;
    }

    @Override
    public void deleteCompany(long id) {
        //check whether a employee exiist in a DB or not
        companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company", "Id", "id"));

        companyRepository.deleteById(id);
    }
}
