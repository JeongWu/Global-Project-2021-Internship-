package com.eximbay.okr.service;

import java.util.List;

import com.eximbay.okr.entity.Objective;

public interface QuarterlyOkrService {
    
    List < Objective > findAll();

    void save(Objective member);

    Objective findById(int id);

    List < Objective > findByLevelAndQuarterAndYear(String level, int quarter, int year);

    List < Objective > findByLevelAndQuarterAndYearAndMember_TeamId(String level, int quarter, int year, int teamId);

    List < Objective > findByLevelAndQuarterAndYearAndMemberId(String level, int quarter, int year, int memberId);
    
}