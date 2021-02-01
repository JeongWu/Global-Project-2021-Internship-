package com.eximbay.okr.controller;

import java.util.List;

import com.eximbay.okr.entity.Company;
import com.eximbay.okr.web.entity.RequestEntity;
import com.eximbay.okr.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/api/datatables/company")
    @ResponseBody
    public List<Company> getCompany(RequestEntity rEntity){
        System.out.println("COMPANY ENTITY : "+rEntity);

        return companyService.findByLevelAndQuarterAndYear(rEntity.getLevel(), rEntity.getQuarter(), rEntity.getYear());
    } 
}