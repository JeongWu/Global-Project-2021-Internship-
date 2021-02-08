package com.eximbay.okr.dto;

import java.util.List;
import java.util.Optional;

import com.eximbay.okr.constant.TeamType;
import com.eximbay.okr.entity.Division;

import lombok.Data;

@Data
public class TeamDto {

    private Integer teamSeq;
    private DivisionDto division;
    //test
    private String divisionName;
    // private Integer divisionSeq;

    private String name;
    private String localName;
    private TeamType teamType;
    private String introduction;
    private String image;
    private String useFlag;

    // private Optional<MemberDto> teamManager;
    private MemberDto teamManager;

    private List<MemberDto> teamMembers;

}
