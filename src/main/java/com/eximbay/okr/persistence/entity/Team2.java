package com.eximbay.okr.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

import lombok.ToString;


@Data
@Entity
@Table(name = "team2")
public class Team2 {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEAM_SEQ", length = 11)
    private Integer teamSeq;

    @OneToMany
    private List<TeamMember> teamMember;

    @ManyToOne
    @JoinColumn(name = "DIVISION_SEQ",  nullable = false)
    private Division division;
    

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "LOCAL_NAME", length = 50, nullable = false)
    private String localName;

    @Column(name = "TEAM_TYPE", length = 20, nullable = false)
    private String teamType;
    // private String teamType = TeamType.TEAM;

    @Column(name = "INTRODUCTION", length = 1000)
    private String introduction;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "USE_FLAG", length = 1, nullable = false)
    private String useFlag;
    // private String useFlag = FlagOption.N;

}
