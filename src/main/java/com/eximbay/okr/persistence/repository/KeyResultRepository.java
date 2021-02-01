package com.eximbay.okr.persistence.repository;

import java.util.List;

import com.eximbay.okr.persistence.entity.KeyResult;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyResultRepository extends JpaRepository<KeyResult, Integer> {
    KeyResult findById(int id);

	List<KeyResult> findByObjectiveId(int objectiveId);
}