package com.eximbay.okr.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.eximbay.okr.persistence.entity.Member;
import com.eximbay.okr.persistence.entity.Team;
import com.eximbay.okr.web.entity.RequestEntity;
import com.eximbay.okr.web.entity.ResponseEntity;
import com.eximbay.okr.web.service.MemberService;
import com.eximbay.okr.web.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @Autowired
    private TeamService teamService;

    @RequestMapping("/member")
    public String member(Model model) {
        //model.addAttribute("teams", teamService.findAll());

        return "/pages/member/member.html";
    }

    @RequestMapping("/api/member/add")
    @ResponseBody
    public ResponseEntity memberAdd(RequestEntity reqEntity) {
        ResponseEntity resEntity = new ResponseEntity();

        System.out.println("Member : "+reqEntity);
        try {
            Team team = teamService.findById(reqEntity.getTeamId());
            Member member = new Member();
            member.setName(reqEntity.getName());
            member.setUserId(reqEntity.getUserId());
            member.setEmail(reqEntity.getEmail());
            member.setPassword(reqEntity.getPassword());
            member.setLevel(reqEntity.getLevel());
            member.setTeam(team);
            member.setRegUserId("bayar");
            member.setRegDt(LocalDateTime.now());
            memberService.save(member);

            resEntity.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
            resEntity.setStatus("fail");
        }
        
        return resEntity;
    }

    @RequestMapping("/api/member/edit")
    @ResponseBody
    public ResponseEntity memberEdit(RequestEntity reqEntity) {
        ResponseEntity resEntity = new ResponseEntity();

        System.out.println("Member : "+reqEntity);
        try {
            Member member = memberService.findById(reqEntity.getId());
            member.setName(reqEntity.getName());
            member.setUserId(reqEntity.getUserId());
            member.setEmail(reqEntity.getEmail());
            if(reqEntity.getPassword() != null)
                member.setPassword(reqEntity.getPassword());
            member.setLevel(reqEntity.getLevel());
            member.setModUserId("bayar");
            member.setModDt(LocalDateTime.now());
            memberService.save(member);

            resEntity.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
            resEntity.setStatus("fail");
        }
        
        return resEntity;
    }
    
    @RequestMapping("/api/datatables/members")
    @ResponseBody
    public List<Member> getMembers(RequestEntity rEntity){
        System.out.println(rEntity);

        return memberService.findAll();
    }

    @RequestMapping("/api/datatables/team/members")
    @ResponseBody
    public List<Member> getTeamMembers(RequestEntity rEntity){
        System.out.println(rEntity);

        return memberService.findByTeamId(rEntity.getTeamId());
    }

    @RequestMapping("/api/datatables/member")
    @ResponseBody
    public Member getTeamMember(RequestEntity rEntity){
        System.out.println(rEntity);

        return memberService.findById(rEntity.getMemberId());
    }
}