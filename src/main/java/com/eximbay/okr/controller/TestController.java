package com.eximbay.okr.controller;

import java.util.List;

import com.eximbay.okr.dto.MemberDto;
import com.eximbay.okr.dto.TeamDto;
import com.eximbay.okr.dto.TeamMemberDto;
import com.eximbay.okr.entity.Member2;
import com.eximbay.okr.entity.Team;
import com.eximbay.okr.entity.Team2;
import com.eximbay.okr.entity.TeamMember;
import com.eximbay.okr.repository.Member2Repository;
import com.eximbay.okr.repository.Team2Repository;
import com.eximbay.okr.repository.TeamMemberRepository;
import com.eximbay.okr.utility.MapperUtil;

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
    Member2Repository member2Repository;

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

    @RequestMapping("get-team-data")
    @ResponseBody
    public List<TeamDto> getTeamList() {

        List<Team2> teams = team2Repository.findAll();
        List<TeamDto> teamDtos = MapperUtil.mapList(teams, TeamDto.class);
        // for(int i=0;i<teamDtos.size();i++){

        //     List<TeamMemberDto> teamMemberDtos=MapperUtil.mapList(teams.get(i).getTeamMember(),TeamMemberDto.class);
        //     List<MemberDto> memberDtos=
        //     teamDtos.get(i).setTeamMembers(teamMembers);
        //     // List<MemberDto> memberDtos=teamMemberDtos.map(TeamMemberDto::getMember);

        // }
        


        return teamDtos;
    }
    // @RequestMapping("get-member-data")
    // @ResponseBody
    // public List<MemberDto> getMemberList() {

    //     List<Member2> member2s = member2Repository.findAll();
    //     List<MemberDto> memberDtos = MapperUtil.mapList(member2s, MemberDto.class);
    //     // for(int i=0;i<teamDtos.size();i++){

    //     //     List<TeamMemberDto> teamMemberDtos=MapperUtil.mapList(teams.get(i).getTeamMember(),TeamMemberDto.class);
    //     //     List<MemberDto> memberDtos=
    //     //     teamDtos.get(i).setTeamMembers(teamMembers);
    //     //     // List<MemberDto> memberDtos=teamMemberDtos.map(TeamMemberDto::getMember);

    //     // }
        


    //     return memberDtos;
    // }

}
