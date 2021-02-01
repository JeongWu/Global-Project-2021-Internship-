package com.eximbay.okr.repository;

import java.util.List;

import com.eximbay.okr.entity.KeyResult;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyResultRepository extends JpaRepository<KeyResult, Integer> {
    KeyResult findById(int id);

	List<KeyResult> findByObjectiveId(int objectiveId);
}