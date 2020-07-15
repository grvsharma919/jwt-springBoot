package com.gaurav.efuel.controller;
import com.gaurav.efuel.constant.ApiConstants;

import com.gaurav.efuel.dao.entity.Company;
import com.gaurav.efuel.response.AuthenticationDto;
import com.gaurav.efuel.service.CompanyService;
import com.gaurav.efuel.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiConstants.API_V1)
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "/company")
    public ResponseEntity createCompany(@RequestBody Company company){

        return companyService.createCompany(company);

    }

    @GetMapping(value = "/company/{id}")
    public ResponseEntity getCompanyById(@PathVariable long id){

        return companyService.getCompanyById(id);

    }

    @PatchMapping(value = "/company")
    public ResponseEntity updateCompany(@RequestBody Company company){

        return companyService.updateCompany(company);

    }

    @DeleteMapping(value = "/company/{id}")
    public ResponseEntity deleteCompanyById(@PathVariable long id){

        return companyService.deleteCompanyById(id);

    }

    @GetMapping(value = "/company")
    public ResponseEntity<?> listAllCompanies(@RequestParam int page, @RequestParam int size){
        return companyService.listAllCompanies(page,size);
    }

}
