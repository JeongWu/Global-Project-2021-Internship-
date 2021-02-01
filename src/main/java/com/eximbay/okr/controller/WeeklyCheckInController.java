package com.eximbay.okr.controller;

import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.eximbay.okr.entity.Objective;
import com.eximbay.okr.entity.WeeklyCheckIn;
import com.eximbay.okr.web.entity.RequestEntity;
import com.eximbay.okr.web.entity.ResponseEntity;
import com.eximbay.okr.service.QuarterlyOkrService;
import com.eximbay.okr.service.WeeklyCheckInService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WeeklyCheckInController {
    
    @Autowired
    private WeeklyCheckInService wciService;

    @Autowired
    private QuarterlyOkrService okrService;

    @RequestMapping("/weekly-check-in")
    public String weeklyCheckIn() {
        return "/pages/weekly-check-in/checkin.html";
    }

    @RequestMapping("/api/weekly/checkin")
    @ResponseBody
    public List<WeeklyCheckIn> getWeeklyCheckIns(RequestEntity reqEntity){
        System.out.println(reqEntity);

        List<WeeklyCheckIn> weeklyCheckIn = wciService.findByTypeAndWeekAndObjectiveId(reqEntity.getType(), reqEntity.getWeek(), reqEntity.getObjectiveId());
        
        return weeklyCheckIn;
    } 
    
    @RequestMapping("/api/weekly/checkin/add")
    @ResponseBody
    public ResponseEntity weeklyCheckInAdd(RequestEntity reqEntity) {
        ResponseEntity resEntity = new ResponseEntity();

        System.out.println("WEEKLY : "+reqEntity);
        try {
            int week = 1;

            Objective objective = okrService.findById(reqEntity.getObjectiveId());
            WeeklyCheckIn wci = new WeeklyCheckIn();
            wci.setNo(reqEntity.getNo()+1);
            wci.setContent(reqEntity.getContent());
            wci.setType(reqEntity.getType());
            wci.setWeek(week);
            wci.setObjective(objective);
            wci.setRegUserId("bayar");
            wci.setRegDt(LocalDateTime.now());
            wciService.save(wci);

            resEntity.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
            resEntity.setStatus("fail");
        }
        
        return resEntity;
    }

    @RequestMapping("/api/weekly/checkin/edit")
    @ResponseBody
    public ResponseEntity weeklyCheckInEdit(RequestEntity reqEntity) {
        ResponseEntity resEntity = new ResponseEntity();

        System.out.println("WEEKLY : "+reqEntity);
        try {
            WeeklyCheckIn wci = wciService.findById(reqEntity.getId());
            wci.setContent(reqEntity.getContent());
            wci.setType(reqEntity.getType());
            wci.setModUserId("bayar");
            wci.setModDt(LocalDateTime.now());
            wciService.save(wci);

            resEntity.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
            resEntity.setStatus("fail");
        }
        
        return resEntity;
    }

    @RequestMapping("/api/weekly/checkin/update")
    @ResponseBody
    public ResponseEntity weeklyCheckInUpdateToDone(@RequestBody String json) {
        ResponseEntity resEntity = new ResponseEntity();

        System.out.println("WEEKLY UPDATE TO DONE: "+json);
        try {

            String decodedJson = URLDecoder.decode(json, "UTF-8");

            System.out.println("Decoded json : "+decodedJson);

            //Jackson Json to Object Mapper
            ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //RequestEntity reqEntity = om.readValue(decodedJson, RequestEntity.class);

            JsonNode node = om.readTree(decodedJson);

            System.out.println(node.get("data").toString());

            List<RequestEntity> listRequestEntity = om.readValue(node.get("data").toString(), new TypeReference<List<RequestEntity>>(){}); 
            
            System.out.println("Object Mapped to RequestEntity : "+listRequestEntity);

            List<WeeklyCheckIn> wciList = new ArrayList<>();
            for (RequestEntity requestEntity : listRequestEntity) {
                WeeklyCheckIn wci = wciService.findById(requestEntity.getId());
                wci.setNo(requestEntity.getNo());
                wci.setType("DN");
                wci.setModUserId("bayar");
                wci.setModDt(LocalDateTime.now());
                wciList.add(wci);
            }
            wciService.saveAll(wciList);

             resEntity.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
            resEntity.setStatus("fail");
        }
        
        return resEntity;
    }
    
}