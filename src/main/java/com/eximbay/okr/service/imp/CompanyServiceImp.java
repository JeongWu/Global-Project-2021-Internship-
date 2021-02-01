package com.eximbay.okr.service.imp;

import java.util.List;

import com.eximbay.okr.entity.Company;
import com.eximbay.okr.repository.CompanyRepository;
import com.eximbay.okr.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImp implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> findByLevelAndQuarterAndYear(String level, int quarter, int year) {
        List<Company> result = companyRepository.findByLevelAndQuarterAndYear(level, quarter, year);

        for (Company company : result) {
            System.out.println("company : "+company.getId() +" : "+company.getName()+" : "+company.getPercentage());
        }
        
        return result;
    }
}