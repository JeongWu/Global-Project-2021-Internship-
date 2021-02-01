package com.eximbay.okr;

import java.time.LocalDateTime;

import com.eximbay.okr.entity.Member;
import com.eximbay.okr.entity.Team;
import com.eximbay.okr.service.MemberService;
import com.eximbay.okr.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private TeamService teamService;

    @Autowired
    private MemberService memberService;

    @Override
    public void run(String... args) throws Exception {
        Team team = new Team();
        team.setName("TEAM 1");
        team.setRegUserId("bayar");
        team.setRegDt(LocalDateTime.now());
        teamService.save(team);

        Member member = new Member();
        member.setName("Admin");
        member.setUserId("admin");
        member.setEmail("admin@eximbay.com");
        member.setPassword(new BCryptPasswordEncoder().encode("123"));
        member.setLevel("C");
        member.setTeam(team);
        member.setRegUserId("bayar");
        member.setRegDt(LocalDateTime.now());
        memberService.save(member);
    }
}    

