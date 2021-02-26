package com.eximbay.okr.api;

import com.eximbay.okr.dto.dictionary.DictionaryDto;
import com.eximbay.okr.entity.Dictionary;
import com.eximbay.okr.model.DivisionForDivisionsModel;
import com.eximbay.okr.model.MemberForDivisionChangeMembersModel;
import com.eximbay.okr.repository.DictionaryRepository;
import com.eximbay.okr.service.Interface.IDivisionService;
import com.eximbay.okr.utils.MapperUtil;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dictionary")
@AllArgsConstructor
public class DictionaryAPI {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @ResponseBody
    @RequestMapping("/datatables")
    public List<DictionaryDto> getDictionaryData() {
        List<Dictionary> dictionaries = dictionaryRepository.findAll();
        List<DictionaryDto> dictionaryList = MapperUtil.mapList(dictionaries, DictionaryDto.class);
        return dictionaryList;
    }
}
