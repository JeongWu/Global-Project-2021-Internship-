package com.eximbay.okr.service.Interface;

import com.eximbay.okr.dto.dictionary.DictionaryDto;
import com.eximbay.okr.entity.Dictionary;
import com.eximbay.okr.model.dictionary.DictionaryAddModel;

public interface IDictionaryService extends ISerivce<DictionaryDto, Integer> {

    DictionaryAddModel buildDictionaryAddModel();

    void addDictionary(DictionaryAddModel dictionaryAddModel);
    
}
