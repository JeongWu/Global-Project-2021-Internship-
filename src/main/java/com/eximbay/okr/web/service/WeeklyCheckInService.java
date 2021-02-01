package com.eximbay.okr.web.service;

import java.util.List;

import com.eximbay.okr.persistence.entity.WeeklyCheckIn;

public interface WeeklyCheckInService {
    
    List < WeeklyCheckIn > findAll();

    void save(WeeklyCheckIn wci);

    void saveAll(List<WeeklyCheckIn> wciList);

    WeeklyCheckIn findById(int id);

    List < WeeklyCheckIn > findByTypeAndWeekAndObjectiveId(String type, int week, int objectiveId);

}