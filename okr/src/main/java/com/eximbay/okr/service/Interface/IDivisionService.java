package com.eximbay.okr.service.Interface;

import com.eximbay.okr.dto.DivisionDto;
import com.eximbay.okr.dto.DivisionMemberDto;
import com.eximbay.okr.model.DivisionChangeMembersModel;
import com.eximbay.okr.entity.Division;
import com.eximbay.okr.model.DivisionUpdateFormModel;
import com.eximbay.okr.model.DivisionsModel;
import com.eximbay.okr.model.EditDivisionModel;
import com.eximbay.okr.model.division.DivisionAddModel;

import java.util.List;

public interface IDivisionService extends ISerivce<DivisionDto, Integer> {

    DivisionsModel buildDivisionsModel();
    List<DivisionMemberDto> findCurrentlyValid(List<DivisionMemberDto> divisionMemberDtos);
    EditDivisionModel buildEditDivisionModel(Integer id);
    void updateFormModel(DivisionUpdateFormModel updateFormModel);
    DivisionChangeMembersModel buildDivisionChangeMembersModel(Integer id);
    DivisionAddModel buildDefaultDivisionAddModel();
    Division addDivision(DivisionAddModel divisionAddModel);
}
