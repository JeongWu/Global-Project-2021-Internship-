package com.eximbay.okr.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "objective")
public class Objective {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int objNo;

    private String objName;

    private String level;

    private Integer year;

    private Integer quarter;

    private String status;

    private String regUserId;

    private LocalDateTime regDt;

    private String modUserId;

    private LocalDateTime modDt;

    //@Transient
    private Integer percentage;

    @ManyToOne
    @JoinColumn(name="member_id", referencedColumnName = "id", nullable=false)
    private Member member;

}