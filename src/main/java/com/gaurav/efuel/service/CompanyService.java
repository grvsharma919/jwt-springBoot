package com.gaurav.efuel.service;

import com.gaurav.efuel.dao.entity.Company;
import com.gaurav.efuel.dao.repository.CompanyRepository;
import com.gaurav.efuel.exception.DAOException;
import com.gaurav.efuel.response.ResponseHandler;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.gaurav.efuel.constant.Messages.*;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ResponseEntity createCompany(Company company) {
        try {
            companyRepository.save(company);
            return ResponseHandler.generateResponse(HttpStatus.OK, true, SUCCESS,
                    null, null);

        }catch (Exception e){
            logger.info("Exception occurred::Create company ", e.getMessage());
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,false,USER_DETAIL_NOT_FOUND,null,null);
        }
    }

    public ResponseEntity getCompanyById(long id) {
        try {
            Optional<Company> company = companyRepository.findById(id);
            if (!company.isPresent()) {
                return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, USER_DETAIL_NOT_FOUND,
                        null, null);
            }
            return ResponseHandler.generateResponse(HttpStatus.OK, true, SUCCESS,
                    company.get(), null);
        }catch (Exception e){
            logger.info("Exception occurred::getCompanyById ", e.getMessage());
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR,false,ERROR,null,null);
        }
    }

    public ResponseEntity updateCompany(Company company){
        try {
            companyRepository.save(company);
            return ResponseHandler.generateResponse(HttpStatus.OK, true, SUCCESS,
                    null, null);

        }catch (Exception e){
            logger.info("Exception occurred::updateCompany ", e.getMessage());
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,false,USER_DETAIL_NOT_FOUND,null,null);
        }
    }

    public ResponseEntity deleteCompanyById(long id){
        try {
            companyRepository.deleteById(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, true, SUCCESS,
                    null, null);
        }catch (Exception e){
            logger.info("Exception occurred::deleteCompanyById ", e.getMessage());
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,false,ERROR,null,null);
        }
    }

    public ResponseEntity<?> listAllCompanies(int page, int size){
        try {
            Page<Company> companies = companyRepository.findAll(PageRequest.of(page-1, size, Sort.by("createdDate").descending()));
            Map<String, Object> map = new HashMap<>();
            map.put("count", companies.getTotalElements());
            map.put("data", companies.get().collect(Collectors.toList()));
            return ResponseHandler.generateResponse(HttpStatus.OK, true, SUCCESS, map, null);
        }catch (Exception e){
            logger.info("Exception occurred::listAllCompanies ", e.getMessage());
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,false,ERROR,null,null);
        }
    }


}
