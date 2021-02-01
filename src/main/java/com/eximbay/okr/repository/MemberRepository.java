package com.eximbay.okr.repository;

import java.util.List;

import com.eximbay.okr.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findById(int id);

    Member findByUserId(String userId);

    List<Member> findByTeamId(int teamId);
}