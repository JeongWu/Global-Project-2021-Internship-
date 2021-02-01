package com.eximbay.okr.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class TeamMemberId implements Serializable {
    Team2 team2;
    Member2 member2;
    String applyBeginDate;
}
