package com.eximbay.okr.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import com.eximbay.okr.entity.Team;
import com.eximbay.okr.web.entity.RequestEntity;
import com.eximbay.okr.web.entity.ResponseEntity;
import com.eximbay.okr.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeamController {
    
    @Autowired
    private TeamService teamService;

    @RequestMapping("/teams")
    public String teams(Model model, Principal principal, RequestEntity reqEntity) {
        System.out.println(principal.getName());
        //System.out.println(reqEntity);

        //model.addAttribute("teams", teamService.findAll());

        return "/pages/team/team.html";
    }

    @RequestMapping("/team/{id}")
    public String team(Model model, @PathVariable int id) {
        //model.addAttribute("teams", teamService.findAll());

        return "/pages/team/team.html";
    }

    @RequestMapping("/api/datatables/teams")
    @ResponseBody
    public List<Team> getAllTeams(RequestEntity rEntity){

        List<Team> teams = teamService.findByQuarterAndYear(rEntity.getQuarter(), rEntity.getYear());

        return teams;
    } 

    @RequestMapping("/api/datatables/team/{id}")
    @ResponseBody
    public Team getTeam(@PathVariable int id){

        System.out.println("id : "+id);

        return teamService.findById(id);
    } 
    
    @RequestMapping("/api/team/add")
    @ResponseBody
    public ResponseEntity teamAdd( RequestEntity reqEntity) {
        
        ResponseEntity resEntity = new ResponseEntity();

        System.out.println("TEAM : "+reqEntity.getName());
        try {
            Team team = new Team();
            team.setName(reqEntity.getName());
            team.setRegUserId("bayar");
            team.setRegDt(LocalDateTime.now());
            teamService.save(team);

            resEntity.setStatus("success");
        } catch (Exception e) {
            System.out.println("Exception : "+e);
            resEntity.setStatus("fail");
        }
        
        return resEntity;
    }

    @RequestMapping("/api/team/edit")
    @ResponseBody
    public ResponseEntity teamEdit( RequestEntity reqEntity) {
        
        ResponseEntity resEntity = new ResponseEntity();

        try {
            System.out.println("TEAM : "+reqEntity.getId());
            Team team = teamService.findById(reqEntity.getId());
            team.setName(reqEntity.getName());
            team.setModUserId("bayar");
            team.setModDt(LocalDateTime.now());
            teamService.save(team);

            resEntity.setStatus("success");
        } catch (Exception e) {
            System.out.println("Exception : "+e);
            resEntity.setStatus("fail");
        }

        return resEntity;
    }
}