package com.eximbay.okr.service.Interface;

import com.eximbay.okr.dto.dictionary.DictionaryDto;
import com.eximbay.okr.entity.Dictionary;
import com.eximbay.okr.model.dictionary.DictionaryAddModel;
import com.eximbay.okr.model.dictionary.SelectTypeModel;

public interface IDictionaryService extends ISerivce<DictionaryDto, Integer> {

    SelectTypeModel buidSelectTypeModel();

    void addDictionary(DictionaryAddModel dictionaryAddModel);

    
}
