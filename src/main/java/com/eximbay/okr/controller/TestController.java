package com.eximbay.okr.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.eximbay.okr.constant.FlagOption;
import com.eximbay.okr.constant.TeamType;
import com.eximbay.okr.dto.DivisionDto;
import com.eximbay.okr.dto.MemberDto;
import com.eximbay.okr.dto.TeamDto;
import com.eximbay.okr.dto.TeamMemberDto;
import com.eximbay.okr.dto.TeamUpdateModel;
import com.eximbay.okr.entity.Division;
import com.eximbay.okr.entity.Member2;
import com.eximbay.okr.entity.Team;
import com.eximbay.okr.entity.Team2;
import com.eximbay.okr.entity.TeamMember;
import com.eximbay.okr.entity.TeamMemberId;
import com.eximbay.okr.repository.DivisionRepository;
import com.eximbay.okr.repository.Team2Repository;
import com.eximbay.okr.repository.TeamMemberRepository;
import com.eximbay.okr.utility.MapperUtil;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {

    @Autowired
    Team2Repository team2Repository;

    @Autowired
    TeamMemberRepository teamMemberRepository;

    
    @Autowired
    DivisionRepository divisionRepository;

    // @Autowired
    // Member2Repository member2Repository;

    @Autowired
    TeamMemberRepository tmRepository;



    // test
    @RequestMapping("/team/list")
    public String getTeamListView(Model model) {
        long totalCount=team2Repository.count();
        model.addAttribute("totalCount", totalCount);

        // List<Division> divisionDtos=divisionRepository.findAll();
        // List<String> list = divisionDtos.stream().map(Division::getName).collect(Collectors.toList());
        
        model.addAttribute("teamType",TeamType.values());
        // model.addAttribute("divisionList", list);

        return "/pages/quarterly-okr/team-list2.html";
    }

    @RequestMapping("/team/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
    	
        ModelMapper modelMapper = new ModelMapper();

        Team2 team = team2Repository.findByTeamSeq(id);

        // TeamDto teamDto = modelMapper.map(team, TeamDto.class);
        // System.out.println(teamDto);
        TeamUpdateModel teamUpdateModel=modelMapper.map(team,TeamUpdateModel.class);
        System.out.println(teamUpdateModel);
        
    	model.addAttribute("dataModel",teamUpdateModel);
        return "/pages/quarterly-okr/team-edit.html";
    }

    
    @RequestMapping(value="/post-edit-team",method=RequestMethod.POST)
    public String update(TeamUpdateModel req) {
        System.out.println(req);

        ModelMapper modelMapper = new ModelMapper();

        Team2 team = team2Repository.findByTeamSeq(req.getTeamSeq());
        // TeamDto teamDto = modelMapper.map(team, TeamDto.class);

        
        // TeamUpdateModel teamUpdateModel=modelMapper.map(team,TeamUpdateModel.class);
       
        // teamUpdateModel.setIntroduction(req.getIntroduction());
        team.setIntroduction(req.getIntroduction());
        team.setImage(req.getImage());
        // teamUpdateModel.setImage(req.getImage());
        // System.out.println(teamUpdateModel);
        team2Repository.save(team);

        // Optional<Team> team = teamRepository.findById(updateFormModel.getTeamSeq());
    	// if(team.isEmpty()) throw new UserException(new NotFoundException("Not found Object with Id = "+ updateFormModel.getTeamSeq()));
    	// mapper.map(updateFormModel, team.get());
    	
    	// if(updateFormModel.isUseFlag()) team.get().setUseFlag(FlagOption.Y);
    	// else team.get().setUseFlag(FlagOption.N);
    	// TeamHistoryDto teamHistoryDto = mapper.map(team.get(), TeamHistoryDto.class);
    	// teamHistoryDto.setJustification(updateFormModel.getJustification());
    	// teamHistoryDto.setTeam(mapper.map(team.get(), TeamDto.class));
    	// teamHistoryService.save(teamHistoryDto);
    	// Team saveTeam = teamRepository.save(team.get());
        
       
        return "/pages/quarterly-okr/team-edit.html";
    }


    // @RequestMapping("/api/team/edit/{id}")
    // @ResponseBody
    // public String update(TeamUpdateModel req, @PathVariable Integer id) {

    //     ModelMapper modelMapper = new ModelMapper();

    //     Team2 team = team2Repository.findByTeamSeq(id);
    //     // TeamDto teamDto = modelMapper.map(team, TeamDto.class);
    //     System.out.println(team);
        
    //     TeamUpdateModel teamUpdateModel=modelMapper.map(team,TeamUpdateModel.class);
       
    //     teamUpdateModel.setIntroduction(req.getIntroduction());
    //     teamUpdateModel.setImage(req.getImage());
    //     System.out.println(teamUpdateModel);
    //     team2Repository.save(teamUpdateModel);
        
       
    //     return "/pages/quarterly-okr/team-list2.html";
    // }



    // test
    @RequestMapping("/api/datatables/team")
    @ResponseBody
    public List<Team2> getTeam() {
        // return "/pages/quarterly-okr/team-list.html";

        return team2Repository.findAll();
    }

    // @RequestMapping("/api/datatables/team-member")
    // @ResponseBody
    // public List<TeamMember> getTeamMember() {
    //     List<TeamMember> objectives = tmRepository.findAll();
    //     System.out.println(objectives);

    //     return objectives;
    // }

    @RequestMapping("get-team-data")
    @ResponseBody
    public List<TeamDto> getTeamList() {
        ModelMapper modelMapper = new ModelMapper();

        List<Team2> teams = team2Repository.findAll();
        List<TeamDto> teamDtos = MapperUtil.mapList(teams, TeamDto.class);
        // System.out.println(teamDtos);

        for (int i = 0; i < teamDtos.size(); i++) {

            List<TeamMemberDto> teamMemberDtos = MapperUtil.mapList(teams.get(i).getTeamMembers(), TeamMemberDto.class);
            // System.out.println(teamMemberDtos);

            MemberDto memberDto = modelMapper.map(teamMemberDtos.stream()
                    .filter(m -> m.getTeamManagerFlag().equals(FlagOption.Y)).map(TeamMemberDto::getMember).findFirst(),
                    MemberDto.class);

                    // System.out.println(memberDto);

            teamDtos.get(i).setTeamManager(memberDto);

           DivisionDto divisionDto=modelMapper.map(teams.get(i).getDivision(),DivisionDto.class);
        //    teamDtos.get(i).setDivisionName(divisionDto.getName());
           teamDtos.get(i).setDivisionName(divisionDto.getName());



            // teamMemberDtos.stream().filter(m->m.getTeamManagerFlag().equals(FlagOption.Y)).map(TeamMemberDto::getMember).findFirst();
            // Optional<MemberDto> memberDto=ModelMapper.map(member2,MemberDto.class);

        }

        // for(int i=0;i<teamDtos.size();i++){

        // List<TeamMemberDto>
        // teamMemberDtos=MapperUtil.mapList(teams.get(i).getTeamMember(),TeamMemberDto.class);
        // List<MemberDto> memberDtos=
        // teamDtos.get(i).setTeamMembers(teamMembers);
        // // List<MemberDto> memberDtos=teamMemberDtos.map(TeamMemberDto::getMember);

        // }

        // @Override
        // public WireframeModel buildWireframeModel() {
        // WireframeModel wireframeModel = new WireframeModel();
        // List<Team> teams = teamRepository.findByUseFlag(FlagOption.Y);
        // List<TeamForWireframeModel> teamForWireframeModels = mapper.mapAsList(teams,
        // TeamForWireframeModel.class);
        // for (int i = 0; i <teamForWireframeModels.size() ; i++) {
        // Optional<MemberDto> leaderOrManager =
        // teamMemberService.findTeamLeaderOrManager(mapper.mapAsList(teams.get(i).getTeamMembers(),
        // TeamMemberDto.class));
        // teamForWireframeModels.get(i).setLeaderOrManager(leaderOrManager.orElse(null));
        // }
        // wireframeModel.setTeams(teamForWireframeModels);
        // return wireframeModel;
        // }

        return teamDtos;
    }
    // @RequestMapping("get-member-data")
    // @ResponseBody
    // public List<MemberDto> getMemberList() {

    // List<Member2> member2s = member2Repository.findAll();
    // List<MemberDto> memberDtos = MapperUtil.mapList(member2s, MemberDto.class);
    // // for(int i=0;i<teamDtos.size();i++){

    // // List<TeamMemberDto>
    // teamMemberDtos=MapperUtil.mapList(teams.get(i).getTeamMember(),TeamMemberDto.class);
    // // List<MemberDto> memberDtos=
    // // teamDtos.get(i).setTeamMembers(teamMembers);
    // // // List<MemberDto>
    // memberDtos=teamMemberDtos.map(TeamMemberDto::getMember);

    // // }

    // return memberDtos;
    // }

}
