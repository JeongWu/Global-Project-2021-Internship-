package com.eximbay.okr.web.service;

import java.util.List;

import com.eximbay.okr.persistence.entity.KeyResult;

public interface KeyResultService {
    
    List < KeyResult > findAll();

    void save(KeyResult keyResult);

    KeyResult findById(int id);

	List<KeyResult> findByObjectiveId(int objectiveId);

}