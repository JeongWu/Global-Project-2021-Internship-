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
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String level;

    private String userId;

    private String password;

    private String name;

    private String email;

    private LocalDateTime passwordModDt;

    private String prePassword;

    private String tempPasswordFlag;

    private LocalDateTime lastLoginDt;

    private Integer passwordErrorCount;

    private String useYn;

    private String regUserId;

    private LocalDateTime regDt;

    private String modUserId;

    private LocalDateTime modDt;

    @ManyToOne
    @JoinColumn(name="team_id", referencedColumnName = "id", nullable=false)
    private Team team;

}