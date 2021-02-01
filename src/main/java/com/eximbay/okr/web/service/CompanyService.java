package com.eximbay.okr.web.service;

import java.util.List;

import com.eximbay.okr.persistence.entity.Company;

public interface CompanyService {
    
    List < Company > findAll();

	List<Company> findByLevelAndQuarterAndYear(String level, int quarter, int year);

}