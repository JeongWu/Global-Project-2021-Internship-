package com.eximbay.okr.web.service.imp;

import java.util.List;

import com.eximbay.okr.persistence.entity.WeeklyCheckIn;
import com.eximbay.okr.persistence.repository.WeeklyCheckInRepository;
import com.eximbay.okr.web.service.WeeklyCheckInService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeeklyCheckInServiceImp implements WeeklyCheckInService {

    @Autowired
    private WeeklyCheckInRepository wciRepository;

    @Override
    public List<WeeklyCheckIn> findAll() {
        return wciRepository.findAll();
    }

    @Override
    public void save(WeeklyCheckIn wci) {
        wciRepository.save(wci);
    }

    @Override
    public WeeklyCheckIn findById(int id) {
        return wciRepository.findById(id);
    }

    @Override
    public List<WeeklyCheckIn> findByTypeAndWeekAndObjectiveId(String type, int week, int objectiveId) {
        return wciRepository.findByTypeAndWeekAndObjectiveId(type, week, objectiveId);
    }

    @Override
    public void saveAll(List<WeeklyCheckIn> wciList) {
        wciRepository.saveAll(wciList);
    }

}