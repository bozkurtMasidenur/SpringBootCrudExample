package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Company;
import com.example.springbootbackend.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        super();
        this.companyService = companyService;
    }

    //public CompanyController(CompanyService companyService) {
    //        super();
    //        this.companyService = companyService;
    //    }
    // build create company REST API
    @PostMapping()
    public ResponseEntity<Company> saveCompany(@RequestBody Company company){
        return new ResponseEntity<Company>(companyService.saveCompany(company), HttpStatus.CREATED);
    }

    //build get all company REST API
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        List<Company> allCompany= companyService.getAllCompany();
        return new ResponseEntity<List<Company>>(allCompany, HttpStatus.OK);
    }

    //build get company by ID REST API
    //http://localhost:8080/api/companies/1
    @GetMapping("{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") long companyId){
        return new ResponseEntity<Company>(companyService.getCompanyById(companyId),HttpStatus.OK);
    }

    //build update company REST API
    //http://localhost:8080/api/companies/1
    @PutMapping("{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id") long id,@RequestBody Company company){
        return new ResponseEntity<Company>(companyService.updateCompany(company, id), HttpStatus.OK);
    }

    //build delete company REST API
    //http://localhost:8080/api/companies/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") long id){
        //delete employee from DB
        companyService.deleteCompany(id);
        return new ResponseEntity<String>("Company deleted successfully!", HttpStatus.OK);
    }
}
