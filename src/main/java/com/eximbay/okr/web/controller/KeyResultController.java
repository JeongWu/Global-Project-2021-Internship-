package com.eximbay.okr.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.eximbay.okr.persistence.entity.KeyResult;
import com.eximbay.okr.persistence.entity.Objective;
import com.eximbay.okr.web.entity.RequestEntity;
import com.eximbay.okr.web.entity.ResponseEntity;
import com.eximbay.okr.web.service.KeyResultService;
import com.eximbay.okr.web.service.QuarterlyOkrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KeyResultController {
    
    @Autowired
    private KeyResultService krService;

    @Autowired
    private QuarterlyOkrService okrServive;

    @RequestMapping("/key-result")
    public String kr() {
        return "/pages/key-result/kr.html";
    }

    @RequestMapping("/api/datatables/objective/krs")
    @ResponseBody
    public List<KeyResult> getKeyResults(RequestEntity rEntity){
        List<KeyResult> keyResults = krService.findByObjectiveId(rEntity.getObjectiveId());
        
        return keyResults;
    }   
    
    @RequestMapping("/api/kr/add")
    @ResponseBody
    public ResponseEntity krAdd(RequestEntity reqEntity) {
        ResponseEntity resEntity = new ResponseEntity();

        System.out.println("KR : "+reqEntity);
        try {

            Objective objective = okrServive.findById(reqEntity.getObjectiveId());
            KeyResult kr = new KeyResult();
            kr.setKrNo(reqEntity.getNo()+1);
            kr.setKrName(reqEntity.getName());
            kr.setObjective(objective);
            kr.setPctOfKrComplete(0);
            kr.setRegUserId("bayar");
            kr.setRegDt(LocalDateTime.now());
            krService.save(kr);

            resEntity.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
            resEntity.setStatus("fail");
        }
        
        return resEntity;
    }

    @RequestMapping("/api/kr/edit")
    @ResponseBody
    public ResponseEntity krEdit(RequestEntity reqEntity) {
        ResponseEntity resEntity = new ResponseEntity();

        System.out.println("KR : "+reqEntity);
        try {
            KeyResult kr = krService.findById(reqEntity.getId());
            kr.setKrName(reqEntity.getName());
            kr.setPctOfKrComplete(reqEntity.getPercentage());
            kr.setModUserId("bayar");
            kr.setModDt(LocalDateTime.now());
            krService.save(kr);

            resEntity.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
            resEntity.setStatus("fail");
        }
        
        return resEntity;
    }
}