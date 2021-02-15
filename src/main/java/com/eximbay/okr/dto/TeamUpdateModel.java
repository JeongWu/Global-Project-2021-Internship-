
package com.eximbay.okr.dto;

import lombok.Data;
import lombok.NonNull;

import com.eximbay.okr.constant.TeamType;
import com.eximbay.okr.dto.DivisionDto;
import com.eximbay.okr.entity.Division;

@Data
public class TeamUpdateModel {

    private Integer teamSeq;

    private String name;

    private String localName;

    
    // //need to be fixed
    private DivisionDto division;
    // @NotNull
    private TeamType teamType;
    
    private String image;

    private String introduction;
    // @NotNull
    // private boolean useFlag;
    // @NotBlank
    // private String justification;
}