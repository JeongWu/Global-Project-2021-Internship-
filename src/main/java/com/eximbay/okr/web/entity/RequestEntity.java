package com.eximbay.okr.web.entity;

import lombok.Data;

@Data
public class RequestEntity{
    
    private int id;
    private int teamId;
    private int memberId;
    private int objectiveId;
    private int no;
    private int percentage;
    private int quarter;
    private int year;
    private int week;
    private String name;
    private String userId;
    private String email;
    private String password;
    private String level;
    private String type;
    private String content;
    
}
