package com.eximbay.okr.service;

import java.util.List;

import com.eximbay.okr.entity.Team;

public interface TeamService {
    
    void save(Team team);

    Team findById(int id);

    List < Team > findByQuarterAndYear(int quarter, int year);
    
    List < Team > findAll();
}