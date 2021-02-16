package com.eximbay.okr.controller;

import com.eximbay.okr.service.Interface.ITeamService;

import java.util.List;

import com.eximbay.okr.model.AllTeamUpdateModel;
import com.eximbay.okr.model.TeamListTableModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RestApIController {

    private final ITeamService teamService;
    
    //to make KTDatatable
    @RequestMapping("/api/datatables/team")
    @ResponseBody
    public List<TeamListTableModel> getTeam() {
        List<TeamListTableModel> teamListViewModels = teamService.buildListTableModel();
        return teamListViewModels;
    }

    @RequestMapping(value = "/post-edit-team", method = RequestMethod.POST)
    public String update(@Validated AllTeamUpdateModel req, BindingResult error) {

        if (error.hasErrors())
            return "redirect:/teams/view/edit/" + req.getTeamSeq();
            
        teamService.updateForViewAllTeamModel(req);
        return "redirect:/teams";
    }
}
