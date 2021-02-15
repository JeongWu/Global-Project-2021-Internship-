package com.eximbay.okr.repository;

import java.util.List;
import java.util.Optional;

import com.eximbay.okr.dto.TeamDto;
import com.eximbay.okr.dto.TeamUpdateModel;
import com.eximbay.okr.entity.Team2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Team2Repository extends JpaRepository<Team2,Integer>{

    // List<Team2> findAll();

    Team2 findByTeamSeq(Integer teamSeq);
    Team2 findById(int id);
    // Optional<Team2> findByTeamType(int id);

    

    // List<Team2> findById(int id);

    // List<Team2> findByName(String name);
    
    
}
