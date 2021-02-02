package com.eximbay.okr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "team_member")
@Entity
@IdClass(TeamMemberId.class)
public class TeamMember implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "TEAM_SEQ")
    private Team2 team2;

    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_SEQ")
    private Member2 member2;

    @Id
    @Column(name = "APPLY_BEGIN_DATE", length = 8, nullable = false)
    private String applyBeginDate;

    @Column(name = "TEAM_MANAGER_FLAG", length = 1)
    private String teamManagerFlag;

}
