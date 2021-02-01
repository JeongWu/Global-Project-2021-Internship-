package com.eximbay.okr.dto;

import com.eximbay.okr.constant.TeamType;
import com.eximbay.okr.entity.Division;

import lombok.Data;

@Data
public class TeamDto {

    private Integer teamSeq;
    private Division division;
    private String name;
    private String localName;
    private TeamType teamType;
    private String introduction;
    private String image;
    private String useFlag;
    
}

