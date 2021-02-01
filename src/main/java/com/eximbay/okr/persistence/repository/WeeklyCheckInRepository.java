package com.eximbay.okr.persistence.repository;

import java.util.List;

import com.eximbay.okr.persistence.entity.WeeklyCheckIn;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyCheckInRepository extends JpaRepository<WeeklyCheckIn, Integer> {
    WeeklyCheckIn findById(int id);

	List<WeeklyCheckIn> findByTypeAndWeekAndObjectiveId(String type, int week, int objectiveId);
}