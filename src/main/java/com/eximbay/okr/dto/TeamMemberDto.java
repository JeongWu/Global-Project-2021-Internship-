package com.eximbay.okr.dto;

import lombok.Data;

@Data
public class TeamMemberDto {
    private TeamDto team;
    private MemberDto member;
    private String applyBeginDate;
    // private String teamLeadFlag;
    private String teamManagerFlag;
    // private String applyEndDate;
    // private String justification;
}
