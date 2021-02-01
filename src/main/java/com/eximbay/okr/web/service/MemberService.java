package com.eximbay.okr.web.service;

import java.util.List;

import com.eximbay.okr.persistence.entity.Member;

public interface MemberService {
    
    List < Member > findAll();

    List < Member > findByTeamId(int teamId);

    void save(Member member);

    Member findById(int id);

    Member findByUserId(String userId);

}