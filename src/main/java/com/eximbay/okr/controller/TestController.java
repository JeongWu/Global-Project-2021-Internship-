package com.eximbay.okr.controller;

import java.util.List;

import com.eximbay.okr.entity.Team2;
import com.eximbay.okr.entity.TeamMember;
import com.eximbay.okr.repository.Team2Repository;
import com.eximbay.okr.repository.TeamMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    Team2Repository team2Repository;

    @Autowired
    TeamMemberRepository tmRepository;

    // test
    // @ResponseBody
    @RequestMapping("/test")
    public String test(Model model) {

        return "/pages/quarterly-okr/team-list.html";

        // return team2Repository.findAll();
    }

    // test2
    // test
    @RequestMapping("/test2")
    public String ttest() {
        return "/pages/quarterly-okr/team-list2.html";
    }

    // test
    @RequestMapping("/api/datatables/team")
    @ResponseBody
    public List<Team2> getTeam() {
        // return "/pages/quarterly-okr/team-list.html";

        return team2Repository.findAll();
    }

    @RequestMapping("/api/datatables/team-member")
    @ResponseBody
    public List<TeamMember> getTeamMember() {
        List<TeamMember> objectives = tmRepository.findAll();
        System.out.println(objectives);

        return objectives;
    }
}
