package com.eximbay.okr.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

import com.eximbay.okr.entity.Member;
import com.eximbay.okr.entity.Objective;
import com.eximbay.okr.web.entity.RequestEntity;
import com.eximbay.okr.web.entity.ResponseEntity;
import com.eximbay.okr.service.MemberService;
import com.eximbay.okr.service.QuarterlyOkrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuarterlyOkrController {
    
    @Autowired
    private QuarterlyOkrService quarterlyOkrService;

    @Autowired
    private MemberService memberService;

    @RequestMapping("/okr")
    public String companyOkr(Model model){
        return "/pages/quarterly-okr/company.html";
    }

    @RequestMapping("/okr/{id}")
    public String teamOkr(Model model, @PathVariable int id) {
        System.out.println("ID : "+id);

        return "/pages/quarterly-okr/team.html";
    }

    @RequestMapping("/okr/{teamId}/{id}")
    public String memberOkr(Model model, @PathVariable int teamId, @PathVariable int id) {
        System.out.println("TeamID : "+teamId +" MemberID : "+id);

        return "/pages/quarterly-okr/member.html";
    }

    @RequestMapping("/objective/{id}")
    public String perOkr(Model model, @PathVariable int id) {
        System.out.println("ObjectiveID : "+id);
        model.addAttribute("objectiveId", id);

        return "/pages/quarterly-okr/objective.html";
    }

    @RequestMapping("/api/datatables/okrs")
    @ResponseBody
    public List<Objective> getQuarterlyOKRs(){
        List<Objective> objectives = quarterlyOkrService.findAll();
        
        return objectives;
    }

    @RequestMapping("/api/datatables/company/okrs")
    @ResponseBody
    public List<Objective> getCompanyOKRs(RequestEntity rEntity){
        List<Objective> objectives = quarterlyOkrService.findByLevelAndQuarterAndYear(rEntity.getLevel(), 
                                rEntity.getQuarter(), rEntity.getYear());
        
        return objectives;
    }

    @RequestMapping("/api/datatables/team/okrs")
    @ResponseBody
    public List<Objective> getTeamOKRs(RequestEntity rEntity){
        List<Objective> objectives = quarterlyOkrService.findByLevelAndQuarterAndYearAndMember_TeamId(rEntity.getLevel(), 
                                rEntity.getQuarter(), rEntity.getYear(), rEntity.getTeamId());
        
        return objectives;
    }

    @RequestMapping("/api/datatables/member/okrs")
    @ResponseBody
    public List<Objective> getMemberOKRs(RequestEntity rEntity){
        List<Objective> objectives = quarterlyOkrService.findByLevelAndQuarterAndYearAndMemberId(rEntity.getLevel(), 
                                rEntity.getQuarter(), rEntity.getYear(), rEntity.getMemberId());
        
        return objectives;
    }

    @RequestMapping("/api/datatables/okr")
    @ResponseBody
    public Objective getPerOKR(RequestEntity rEntity){
        return quarterlyOkrService.findById(rEntity.getId());
    }
    
    @RequestMapping("api/okr/add")
    @ResponseBody
    public ResponseEntity okrAdd(RequestEntity reqEntity) {
        ResponseEntity resEntity = new ResponseEntity();

        System.out.println("OKR : "+reqEntity);
        try {
            int year = Year.now().getValue();
            int month = LocalDate.now().getMonth().getValue();
            int quarter = getQuarter(month);

            Member member = memberService.findById(reqEntity.getMemberId());
            Objective obj = new Objective();
            obj.setObjNo(reqEntity.getNo()+1);
            obj.setObjName(reqEntity.getName());
            obj.setLevel(reqEntity.getLevel());
            obj.setYear(year);
            obj.setQuarter(quarter);
            obj.setMember(member);
            obj.setRegUserId("bayar");
            obj.setRegDt(LocalDateTime.now());
            quarterlyOkrService.save(obj);

            resEntity.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
            resEntity.setStatus("fail");
        }
        
        return resEntity;
    }

    @RequestMapping("api/okr/edit")
    @ResponseBody
    public ResponseEntity okrEdit(RequestEntity reqEntity) {
        ResponseEntity resEntity = new ResponseEntity();

        System.out.println("OKR : "+reqEntity);
        try {
            Objective obj = quarterlyOkrService.findById(reqEntity.getId());
            obj.setObjName(reqEntity.getName());
            obj.setModUserId("bayar");
            obj.setModDt(LocalDateTime.now());
            quarterlyOkrService.save(obj);

            resEntity.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
            resEntity.setStatus("fail");
        }
        
        return resEntity;
    }

    //get current quarter
    private static int getQuarter(int month){

        if(month > 0 && month < 4)
            return 1;
        else if(month >= 4 && month < 7)
            return 2;
        else if(month >= 7 && month < 10)
            return 3;
        else return 4;

    }
    
}