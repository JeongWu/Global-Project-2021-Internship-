package com.eximbay.okr.controller;

import java.util.List;
import java.util.Optional;

import com.eximbay.okr.dto.CodeGroupDto;
import com.eximbay.okr.entity.CodeList;
import com.eximbay.okr.entity.Dictionary;
import com.eximbay.okr.model.dictionary.DictionaryAddModel;
import com.eximbay.okr.model.dictionary.SelectTypeModel;
import com.eximbay.okr.service.Interface.ICodeGroupService;
import com.eximbay.okr.service.Interface.IDictionaryService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String addDivision(Model model) {
        model.addAttribute("subheader", "Add Dictionary");

        SelectTypeModel selectTypeModel = dictionaryService.buidSelectTypeModel();

        model.addAttribute("TypeModel", selectTypeModel);

        DictionaryAddModel dictionaryAddModel = new DictionaryAddModel();
        model.addAttribute("dataModel", dictionaryAddModel);
        return "pages/dictionary/add_dictionary";
    }

    @PostMapping(value = "/add")
    public String addDivision(@ModelAttribute DictionaryAddModel dictionaryAddModel) {
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

}
