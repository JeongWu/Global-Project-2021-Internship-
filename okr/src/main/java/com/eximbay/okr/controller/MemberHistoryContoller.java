package com.eximbay.okr.controller;

import com.eximbay.okr.dto.MemberDto;
import com.eximbay.okr.model.MemberHistoryModel;
import com.eximbay.okr.service.MemberServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/memberhistorys")
public class MemberHistoryContoller {

    private final MemberServiceImpl memberService;

    @GetMapping("/{memberSeq}")
    public String getModel(Model model, @PathVariable Integer memberSeq) {
        MemberHistoryModel historyModel = new MemberHistoryModel();
        MemberDto dto = memberService.findById(memberSeq)
        .orElseThrow(()-> new NullPointerException("Null"));
        model.addAttribute("model", historyModel);
        model.addAttribute("memberSeq", memberSeq);
        model.addAttribute("member", dto);
        return "pages/members/member_history";
    }    
}