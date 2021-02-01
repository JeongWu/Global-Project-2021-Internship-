package com.eximbay.okr.service;

import java.util.List;

import com.eximbay.okr.entity.KeyResult;

public interface KeyResultService {
    
    List < KeyResult > findAll();

    void save(KeyResult keyResult);

    KeyResult findById(int id);

	List<KeyResult> findByObjectiveId(int objectiveId);

}