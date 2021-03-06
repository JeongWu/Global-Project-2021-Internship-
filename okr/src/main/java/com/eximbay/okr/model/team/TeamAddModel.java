package com.eximbay.okr.model.team;

import com.eximbay.okr.entity.Division;
import com.eximbay.okr.enumeration.TeamType;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TeamAddModel {
	private Integer teamSeq;
    @NotNull
    private String name;
    @NotNull
    private String localName;
    
    private Division division;

    private TeamType teamType;
    
    private String introduction;
    
    private String image;

    private MultipartFile imageFile;
    
    @NotNull
    private boolean useFlag;
    private String action;

}
