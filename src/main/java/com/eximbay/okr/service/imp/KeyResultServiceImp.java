package com.eximbay.okr.service.imp;

import java.util.List;

import com.eximbay.okr.entity.KeyResult;
import com.eximbay.okr.repository.KeyResultRepository;
import com.eximbay.okr.service.KeyResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyResultServiceImp implements KeyResultService {

    @Autowired
    private KeyResultRepository keyResultRepository;

    @Override
    public List<KeyResult> findAll() {
        return keyResultRepository.findAll();
    }

    @Override
    public void save(KeyResult member) {
        keyResultRepository.save(member);
    }

    @Override
    public KeyResult findById(int id) {
        return keyResultRepository.findById(id);
    }

    @Override
    public List<KeyResult> findByObjectiveId(int objectiveId) {
        return keyResultRepository.findByObjectiveId(objectiveId);
    }
    
}