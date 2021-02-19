package com.eximbay.okr.service;

import java.util.List;
import java.util.Optional;

import com.eximbay.okr.dto.dictionary.DictionaryDto;
import com.eximbay.okr.entity.Dictionary;
import com.eximbay.okr.model.dictionary.DictionaryAddModel;
import com.eximbay.okr.repository.dictionary.DictionaryRepository;
import com.eximbay.okr.service.Interface.IDictionaryService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@Service
@Transactional
@AllArgsConstructor
public class DictionaryService implements IDictionaryService {
    private final DictionaryRepository dictionaryRepository;
    private final MapperFacade mapper;

    @Override
    public List<DictionaryDto> findAll() {
        List<Dictionary> dictionaries= dictionaryRepository.findAll();
        return mapper.mapAsList(dictionaries, DictionaryDto.class);
    }

    @Override
    public Optional<DictionaryDto> findById(Integer id) {
        Optional<Dictionary> dictionary = dictionaryRepository.findById(id);
        return dictionary.map(m-> mapper.map(m, DictionaryDto.class));
    }

    @Override
    public void remove(DictionaryDto dictionaryDto) {
        Dictionary dictionary = mapper.map(dictionaryDto, Dictionary.class);
        dictionaryRepository.delete(dictionary);
    }

    @Override
    public DictionaryDto save(DictionaryDto dictionaryDto) {
        Dictionary dictionary = mapper.map(dictionaryDto, Dictionary.class);
        dictionary = dictionaryRepository.save(dictionary);
        return mapper.map(dictionary, DictionaryDto.class);
    }

    @Override
    public DictionaryAddModel buildDictionaryAddModel() {
        DictionaryAddModel divisionAddModel = new DictionaryAddModel();
        // divisionAddModel.setCompany(companyRepository.findById(1).orElse(null));
        return divisionAddModel;
    }

    @Override
    public void addDictionary(DictionaryAddModel dictionaryAddModel) {
    
        Dictionary dictionary = mapper.map(dictionaryAddModel, Dictionary.class);
        if (dictionaryAddModel.isUseFlag()) {
            dictionary.setUseFlag("Y");
        } else {
            dictionary.setUseFlag("N");
        }
        dictionaryRepository.save(dictionary);

    }
}
