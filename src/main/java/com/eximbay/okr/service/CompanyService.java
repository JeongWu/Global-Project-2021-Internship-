package com.eximbay.okr.service;

import java.util.List;

import com.eximbay.okr.entity.Company;

public interface CompanyService {
    
    List < Company > findAll();

	List<Company> findByLevelAndQuarterAndYear(String level, int quarter, int year);

}