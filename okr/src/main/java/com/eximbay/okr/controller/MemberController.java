package com.eximbay.okr.controller;

import com.eximbay.okr.dto.MemberDto;
import com.eximbay.okr.dto.MemberHistoryDto;
import com.eximbay.okr.dto.TeamMemberDto;
import com.eximbay.okr.entity.Member;
import com.eximbay.okr.entity.Team;
import com.eximbay.okr.model.AllLevelModel;
import com.eximbay.okr.model.AllTeamNameModel;
import com.eximbay.okr.model.MemberHistoryModel;
import com.eximbay.okr.repository.MemberRepository;
import com.eximbay.okr.repository.TeamRepository;
import com.eximbay.okr.service.MemberHistoryServiceImpl;
import com.eximbay.okr.service.MemberServiceImpl;
import com.eximbay.okr.service.TeamMemberServiceImpl;
import com.eximbay.okr.utils.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@AllArgsConstructor
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private MemberHistoryServiceImpl memberHistoryService;

    @Autowired
    private TeamMemberServiceImpl teamMemberService;

    @RequestMapping("/member-list")
    public String memberList(Model model){

        //To count Total member
        List<Member> members = memberRepository.findAll();
        long totalCount= members.size();

        //To get team name for team search option
        List<Team> teams = teamRepository.findAll();
        List<AllTeamNameModel> teamName = MapperUtil.mapList(teams, AllTeamNameModel.class);

        //To get level for level search option
        List<AllLevelModel> level = MapperUtil.mapList(members, AllLevelModel.class);
        

        model.addAttribute("teamName", teamName);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("level", level);
        return "pages/members/member_list";
    }


    @ResponseBody
    @RequestMapping("get-member-data")
    public List<MemberDto> getMemberData() {
        List<Member> members = memberRepository.findAll();
        List<MemberDto> teamMember = MapperUtil.mapList(members, MemberDto.class);
        return teamMember;
        }


        @RequestMapping("/add_member")
        public String addMember(){
            return "pages/members/member_add";
        }
    

        @PostMapping("/member/save")
        public String memberSave(MemberDto dto, @RequestParam("picture") MultipartFile files) {
            dto.createMemberDto(dto.getJoiningDate(), dto.getRetirementDate(),dto.getEditCompanyOkrFlag(),dto.getUseFlag(), dto.getAdminFlag(), dto.getEmail(), files);  
            memberService.save(dto);
            return "redirect:/member-list";
        }
    

        @PostMapping("/save/again")
        public String save1(MemberDto dto, @RequestParam("picture") MultipartFile files) {	
            dto.createMemberDto(dto.getJoiningDate(), dto.getRetirementDate(),dto.getEditCompanyOkrFlag(),dto.getUseFlag(), dto.getAdminFlag(), dto.getEmail(), files);     
            memberService.save(dto);
            return "redirect: /add_member";
            }
        
        @RequestMapping("/edit-details/{memberSeq}")
        public String editdetails(Model model, @PathVariable("memberSeq") int id){
            MemberDto dto = memberService.findById(id)
            .orElseThrow(()-> new NullPointerException("Null"));
            model.addAttribute("member", dto);
            model.addAttribute("team", teamMemberService.findSearchBelong(dto));
            return "pages/members/member_edit";
        }

        @RequestMapping("/get-edit")
        @ResponseBody
        public List<TeamMemberDto> editdetailsss(Model model){
            MemberDto dto = memberService.findById(1)
            .orElseThrow(()-> new NullPointerException("Null"));
            List<TeamMemberDto> teams = teamMemberService.findSearchBelong(dto);
            return teams;
        }
   
        @PostMapping("/member/update/{memberSeq}")
        public String memberUpdate(MemberDto req, @RequestParam("picture") MultipartFile files,
            @PathVariable("memberSeq") int id) { 
            MemberDto dto = memberService.findById(id)
                    .orElseThrow(()-> new NullPointerException("Null"));
                    
            dto.setName(req.getName());
            dto.setLocalName(req.getLocalName());
            dto.setEmail(req.getEmail());
            dto.setContactPhone(req.getContactPhone());
            dto.setRetirementDate(req.getRetirementDate());
            dto.setJoiningDate(req.getJoiningDate());
            dto.setCareer(req.getCareer());
            dto.setLevel(req.getLevel());
            dto.setIntroduction(req.getIntroduction());
            dto.setJustification(req.getJustification());
            dto.setPosition(req.getPosition());
            dto.createMemberDto(req.getJoiningDate(), req.getRetirementDate(), req.getEditCompanyOkrFlag(),req.getUseFlag(), req.getAdminFlag(), req.getEmail(), files); 
            
            MemberHistoryDto history = new  MemberHistoryDto();
            history.setName(dto.getName());
            history.setMember(dto);
            history.setLocalName(dto.getLocalName());
            history.setEmail(dto.getEmail());
            history.setContactPhone(dto.getContactPhone());
            history.setJoiningDate(dto.getJoiningDate());
            history.setRetirementDate(dto.getRetirementDate());
            history.setCareer(dto.getCareer());
            history.setLevel(dto.getLevel());
            history.setIntroduction(dto.getIntroduction());
            history.setJustification(dto.getJustification());
            history.setPosition(dto.getPosition());

            history.createMemberHistoryDto(req.getJoiningDate(), req.getRetirementDate(), req.getEditCompanyOkrFlag(),req.getUseFlag(), req.getAdminFlag(), req.getEmail(), files);
            
            memberService.save(dto);
            memberHistoryService.save(history);
            return "redirect:/member-list";     
        } 
        
        @RequestMapping("/belong/{memberSeq}")
        public String viewBelong(Model model, @PathVariable("memberSeq") Integer memberSeq){
            MemberHistoryModel historyModel = new MemberHistoryModel();
            model.addAttribute("model", historyModel);
            model.addAttribute("memberSeq", memberSeq);
            return "pages/members/member_belong";
            }
            
        @ResponseBody
        @RequestMapping("/belong/get-data/{memberSeq}")
        public List<TeamMemberDto> getMemberData1(@PathVariable("memberSeq") Integer memberSeq){
            MemberDto dto = memberService.findById(memberSeq)
                    .orElseThrow(()-> new NullPointerException("Null"));
            List<TeamMemberDto> teams = teamMemberService.findSearchBelong(dto);
            
            return teams;
        }

        @RequestMapping("/teamember/update")
        @ResponseBody
        public MemberDto useFlagUpate(String memberSeq){
            String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyMMdd"));
            MemberDto dto = memberService.findById(Integer.parseInt(memberSeq))
            .orElseThrow(()-> new NullPointerException("Null"));
            List<TeamMemberDto> teams = teamMemberService.findSearchBelong(dto);
            for (TeamMemberDto item : teams){
                item.setApplyEndDate(today);
                item.setJustification("Inactive");
                teamMemberService.save(item);
            }
        return dto;
    }

}
