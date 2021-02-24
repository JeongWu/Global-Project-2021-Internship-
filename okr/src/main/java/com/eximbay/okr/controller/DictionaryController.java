package com.eximbay.okr.controller;

import java.util.List;
import java.util.Optional;

import com.eximbay.okr.dto.CodeGroupDto;
import com.eximbay.okr.entity.CodeList;
import com.eximbay.okr.entity.Dictionary;
import com.eximbay.okr.model.dictionary.DictionaryAddModel;
import com.eximbay.okr.model.dictionary.DictionaryUpdateModel;
import com.eximbay.okr.model.dictionary.SelectTypeModel;
import com.eximbay.okr.service.Interface.ICodeGroupService;
import com.eximbay.okr.service.Interface.IDictionaryService;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/dictionary")
public class DictionaryController {

    private final IDictionaryService dictionaryService;

    @GetMapping
    public String viewAllDictionary(Model model) {

        return null;
    }

    @GetMapping("/add")
    public String addDictionary(Model model) {
        model.addAttribute("subheader", "Add Dictionary");

        SelectTypeModel selectTypeModel = dictionaryService.buidSelectTypeModel();

        model.addAttribute("TypeModel", selectTypeModel);

        DictionaryAddModel dictionaryAddModel = new DictionaryAddModel();
        model.addAttribute("dataModel", dictionaryAddModel);
        return "pages/dictionary/add_dictionary";
    }

    @PostMapping(value = "/add")
    public String addDictionary(@ModelAttribute DictionaryAddModel dictionaryAddModel) {
        dictionaryService.addDictionary(dictionaryAddModel);
        switch (dictionaryAddModel.getAction()) {
            case "saveAndAddNew":
                return "redirect:/dictionary/add";
            case "saveAndExit":
                return "redirect:/teams";
            default:
                return "pages/dictionary/dictionary-list";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model){
        model.addAttribute("subheader", "Edit Dictionary");
        
        SelectTypeModel selectTypeModel = dictionaryService.buidSelectTypeModel();

        model.addAttribute("TypeModel", selectTypeModel);

        DictionaryUpdateModel dictionaryUpdateModel = dictionaryService.buildUpdateDictionaryModel(id);
        model.addAttribute("dataModel", dictionaryUpdateModel);
        return "pages/dictionary/edit_dictionary";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveDictionary(@Validated DictionaryUpdateModel updateFormModel, BindingResult error){
        if (error.hasErrors()) return "redirect:/dictionary/edit/"+ updateFormModel.getDictionarySeq();
        dictionaryService.updateFormModel(updateFormModel);
        // return "redirect:/dictionary";
        return "redirect:/dictionary/add";
    }

}
