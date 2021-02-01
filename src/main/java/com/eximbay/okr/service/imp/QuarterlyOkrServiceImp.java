package com.eximbay.okr.service.imp;

import java.util.List;

import com.eximbay.okr.entity.Objective;
import com.eximbay.okr.repository.OkrRepository;
import com.eximbay.okr.service.QuarterlyOkrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuarterlyOkrServiceImp implements QuarterlyOkrService {

    @Autowired
    private OkrRepository okrRepository;

    @Override
    public List<Objective> findAll() {
        return okrRepository.findAll();
    }

    @Override
    public void save(Objective member) {
        okrRepository.save(member);
    }

    @Override
    public Objective findById(int id) {
        return okrRepository.findById(id);
    }

    @Override
    public List<Objective> findByLevelAndQuarterAndYear(String level, int quarter, int year) {
        return okrRepository.findByLevelAndQuarterAndYear(level, quarter, year);
    }

    @Override
    public List<Objective> findByLevelAndQuarterAndYearAndMember_TeamId(String level, int quarter, int year,
            int teamId) {
        return okrRepository.findByLevelAndQuarterAndYearAndMember_TeamId(level, quarter, year, teamId);
    }

    @Override
    public List<Objective> findByLevelAndQuarterAndYearAndMemberId(String level, int quarter, int year, int memberId) {
        return okrRepository.findByLevelAndQuarterAndYearAndMemberId(level, quarter, year, memberId);
    }
    
}