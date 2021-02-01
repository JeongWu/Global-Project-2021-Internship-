package com.eximbay.okr.service.imp;

import java.util.List;

import com.eximbay.okr.entity.Team;
import com.eximbay.okr.repository.TeamRepository;
import com.eximbay.okr.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImp implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }

    @Override
    public Team findById(int id) {
        return teamRepository.findById(id);
    }

    @Override
    public List<Team> findByQuarterAndYear(int quarter, int year) {

        System.out.println("TEAM ENTITY quarter: "+quarter+" year: "+year);

        List<Team> teams = teamRepository.findByLevelAndQuarterAndYear("T", quarter, year);

        
        for (Team team : teams) {
            System.out.println("TEAM : "+team.getId() +" : "+team.getName()+" : "/* +team.getPercentage() */);
        }


        return teams;
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}