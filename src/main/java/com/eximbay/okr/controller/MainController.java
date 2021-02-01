package com.eximbay.okr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.eximbay.okr.entity.Team2;
import com.eximbay.okr.repository.Team2Repository;

@Controller
public class MainController {

    @RequestMapping({ "/index", "/" })
    public String index() {
        return "/pages/index.html";
    }

  
}