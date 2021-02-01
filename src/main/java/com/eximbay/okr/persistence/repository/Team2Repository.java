package com.eximbay.okr.persistence.repository;

import java.util.List;

import com.eximbay.okr.persistence.entity.Team2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Team2Repository extends JpaRepository<Team2,Integer>{

    List<Team2> findAll();

    // List<Team2> findById(int id);

    // List<Team2> findByName(String name);
    
    
}
