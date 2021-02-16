package com.eximbay.okr.model;

import lombok.Data;

import java.util.List;

import com.eximbay.okr.dto.DivisionDto;

@Data
public class EditTeamModel {
    private String subheader;
    private String mutedHeader;
    //need to be fixed
    private DivisionDto division;
    private TeamUpdateFormModel model;
} 
