package com.eximbay.okr.dto;

import java.util.Set;

import com.eximbay.okr.constant.FlagOption;

import lombok.Data;

@Data
public class DivisionDto {
    private Integer divisionSeq;
    private String name;
    private String localName;
    private String useFlag = FlagOption.Y;
    private Set<TeamDto> teams;
}
