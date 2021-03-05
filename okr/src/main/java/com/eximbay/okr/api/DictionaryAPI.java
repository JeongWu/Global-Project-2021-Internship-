package com.eximbay.okr.api;


import com.eximbay.okr.dto.dictionary.DictionaryDto;
import com.eximbay.okr.entity.CodeList;

import com.eximbay.okr.entity.Dictionary;
import com.eximbay.okr.model.dictionary.DictionaryViewModel;
import com.eximbay.okr.model.dictionary.SelectTypeModel;
import com.eximbay.okr.repository.CodeListRepository;
import com.eximbay.okr.repository.DictionaryRepository;
import com.eximbay.okr.service.Interface.IDictionaryService;
import com.eximbay.okr.utils.MapperUtil;

import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/dictionary")
@AllArgsConstructor
public class DictionaryAPI {
    
    private final DictionaryRepository dictionaryRepository;
    private final CodeListRepository codeListRepository;
    private final IDictionaryService dictionaryService;
    private final MapperFacade mapper;

    @ResponseBody
    @RequestMapping("/datatables")
    public List<DictionaryDto> getDictionaryData() {
        List<Dictionary> dictionaries = dictionaryRepository.findAll();
        List<DictionaryDto> dictionaryList = MapperUtil.mapList(dictionaries, DictionaryDto.class);
        return dictionaryList;
    }

    @ResponseBody
    @RequestMapping("/keyResult/datatables")
    public List<DictionaryViewModel> getDictionaryOfKeyResult() {
        List<Dictionary> dictionaries = dictionaryRepository.findByDictionaryType("KEY_RESULT");
        List<DictionaryViewModel> viewModels=mapper.mapAsList(dictionaries, DictionaryViewModel.class);
        SelectTypeModel selectTypeModel = dictionaryService.buildSelectTypeModel();
        for(int i=0;i<viewModels.size();i++){
            String code1=viewModels.get(i).getJobType();
            Optional<CodeList> jobType=selectTypeModel.getJobType().stream().filter(d->d.getCodeListId().getCode().equals(code1)).findFirst();
            viewModels.get(i).setJobTypeCodeName(jobType.get().getCodeName());
            String code2=viewModels.get(i).getTaskType();
            Optional<CodeList> taskType=selectTypeModel.getTaskType().stream().filter(d->d.getCodeListId().getCode().equals(code2)).findFirst();
            viewModels.get(i).setTaskTypeCodeName(taskType.get().getCodeName());
            String code3=viewModels.get(i).getTaskMetric();
            Optional<CodeList> taskMetric=selectTypeModel.getTaskMetric().stream().filter(d->d.getCodeListId().getCode().equals(code3)).findFirst();
            viewModels.get(i).setTaskMetricCodeName(taskMetric.get().getCodeName());
            String code4=viewModels.get(i).getTaskIndicator();
            Optional<CodeList> taskIndicator=selectTypeModel.getTaskIndicator().stream().filter(d->d.getCodeListId().getCode().equals(code4)).findFirst();
            viewModels.get(i).setTaskIndicatorCodeName(taskIndicator.get().getCodeName());
        }

        return viewModels;
    }
}

