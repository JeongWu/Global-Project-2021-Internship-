package com.eximbay.okr.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "weekly_check_in")
public class WeeklyCheckIn {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;

    private Integer no;
    
    private String content;

    private int week;

    private String regUserId;

    private LocalDateTime regDt;

    private String modUserId;

    private LocalDateTime modDt;

    @ManyToOne
    @JoinColumn(name="objective_id", referencedColumnName = "id", nullable=false)
    private Objective objective;
    
}