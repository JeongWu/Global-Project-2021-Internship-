package com.eximbay.okr.service.imp;

import java.util.List;

import com.eximbay.okr.entity.Member;
import com.eximbay.okr.repository.MemberRepository;
import com.eximbay.okr.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(int id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member findByUserId(String userId) {
        return memberRepository.findByUserId(userId);
    }

    @Override
    public List<Member> findByTeamId(int teamId) {
        return memberRepository.findByTeamId(teamId);
    }
    
}