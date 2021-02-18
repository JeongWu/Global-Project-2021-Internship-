package com.eximbay.okr.controller;

import com.eximbay.okr.constant.Subheader;
import com.eximbay.okr.entity.Team;
import com.eximbay.okr.enumeration.TeamType;
import com.eximbay.okr.model.AllDetailsTeamModel;
import com.eximbay.okr.model.EditForViewAllTeamsModel;
import com.eximbay.okr.model.EditTeamModel;
import com.eximbay.okr.model.TeamListPageModel;
import com.eximbay.okr.model.TeamUpdateFormModel;
import com.eximbay.okr.model.team.TeamAddModel;
import com.eximbay.okr.service.Interface.ITeamService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/teams")
public class TeamController {
    private final ITeamService teamService;

    @GetMapping
    public String viewAllTeams(Model model, @PageableDefault Pageable pageable) {
        // AllDetailsTeamModel dataModel = teamService.buildAllDetailsTeamModel(pageable);
        // model.addAttribute("model", dataModel);
        // return "pages/teams/teams";
          // model.addAttribute("teamType",TeamType.values());
          TeamListPageModel pageModel = new TeamListPageModel();
          long totalCount = teamService.countAllTeam();
          pageModel.setSubheader("Team");
          pageModel.setMutedHeader(totalCount + " total");
          model.addAttribute("model", pageModel);
          model.addAttribute("teamType", TeamType.values());
          return "pages/teams/team-list";
    }
    
    @GetMapping("/view/edit/{id}")
	public String editFormForViewAllTeams(@PathVariable Integer id, Model model) {
		EditForViewAllTeamsModel viewModel = teamService.buildEditAllTeamsModel(id);

		model.addAttribute("model", viewModel);
		model.addAttribute("dataModel", viewModel.getModel());
		System.out.println( viewModel.getModel());
		return "pages/teams/edit-teams";
	}

    @RequestMapping("/list")
    public String viewTeamList(Model model) {
        // model.addAttribute("teamType",TeamType.values());
        TeamListPageModel pageModel = new TeamListPageModel();
        long totalCount = teamService.countAllTeam();
        pageModel.setSubheader("Team");
        pageModel.setMutedHeader(totalCount + " total");
        model.addAttribute("model", pageModel);
        model.addAttribute("teamType", TeamType.values());
        return "pages/teams/team-list";
    }
    
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Integer id, Model model) {
		EditTeamModel viewModel = teamService.buildEditTeamModel(id);
		model.addAttribute("model", viewModel);
		model.addAttribute("dataModel", viewModel.getModel());
		return "pages/teams/edit";
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String saveTeam(@Validated TeamUpdateFormModel updateFormModel, BindingResult error) {
		if (error.hasErrors())
			return "rediect:/teams/edit/" + updateFormModel.getTeamSeq();
		teamService.updateFormModel(updateFormModel);
		return "redirect:/";
	}

	@GetMapping("/add")
	public String addTeam(Model model) {
		model.addAttribute("subheader", Subheader.ADD_TEAM);
		
//		TeamAddModel teamAddModel = teamService.buildDefaultTeamAddModel();
		TeamAddModel teamAddModel = new TeamAddModel();
		model.addAttribute("dataModel", teamAddModel);
		return "pages/teams/add_team";
	}

	@PostMapping(value = "/add")
    public String addTeam(@ModelAttribute TeamAddModel teamAddModel) {
        Team team = teamService.addTeam(teamAddModel);
        switch (teamAddModel.getAction()) {
            case "saveAndAddNew":
                return "redirect:/teams/add";
            case "saveAndAddMember" :
                return "redirect:/teams/change-members/" + team.getTeamSeq();
            case "saveAndExit" :
                return "redirect:/teams";
            default:
                return "pages/teams/teams";
        }
    }
}
