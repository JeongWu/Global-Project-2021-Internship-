package com.eximbay.okr.controller.advice;

import com.eximbay.okr.service.MemberService;
import com.eximbay.okr.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MenuAdvisor {
    
    @Autowired
    private MemberService memberService;

    @Autowired
    private TeamService teamService;

    @ModelAttribute
	public void menuAttribute(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.out.println("Logged user : "+currentUserName);
            model.addAttribute("member", memberService.findByUserId(currentUserName));
            model.addAttribute("teams", teamService.findAll());
        }
	}
}
