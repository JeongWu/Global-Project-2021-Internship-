package com.eximbay.okr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import lombok.Data;


@Data
@Table(name = "division")
@Entity
public class Division {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DIVISION_SEQ", length = 11)
    private Integer divisionSeq;


    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    
}
