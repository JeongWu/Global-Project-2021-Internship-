package com.eximbay.okr.entity;

import com.eximbay.okr.constant.FlagOption;
import com.eximbay.okr.listener.AbstractAuditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "objective_history")
@Entity
public class ObjectiveHistory extends AbstractAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HISTORY_SEQ", length = 11, nullable = false)
    private Integer historySeq;

    @ManyToOne
    @JoinColumn(name = "OBJECTIVE_SEQ", nullable = false)
    private Objective objectiveObject;

    @Column(name = "YEAR", length = 4)
    private Integer year;

    @Column(name = "QUARTER", length = 11)
    private Integer quarter;

    @Column(name = "BEGIN_DATE", length = 8)
    private String beginDate;

    @Column(name = "END_DATE", length = 8)
    private String endDate;

    @Column(name = "OBJECTIVE_TYPE", length = 10)
    private String objectiveType;

    @ManyToOne
    @JoinColumn(name = "COMPANY_SEQ")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "TEAM_SEQ")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "MEMBER_SEQ")
    private Member member;

    @Column(name = "OBJECTIVE")
    private String objective;

    @Column(name = "PRIORITY", length = 11)
    private Integer priority;

    @Column(name = "PROGRESS", length = 11)
    private Integer progress = 0;

    @Column(name = "LATEST_UPDATE_DT")
    private Instant lastUpdateDate;

    @Column(name = "CLOSE_FLAG", length = 1)
    private String closeFlag;

    @Column(name = "CLOSE_JUSTIFICATION")
    private String closeJustification;

    @Column(name = "CLOSE_DATE")
    private Instant closeDate;

    @Column(name = "JUSTIFICATION", nullable = false)
    private String justification;
}
