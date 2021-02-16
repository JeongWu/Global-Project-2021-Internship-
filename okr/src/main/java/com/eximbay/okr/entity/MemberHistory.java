package com.eximbay.okr.entity;

import com.eximbay.okr.constant.CareerLevel;
import com.eximbay.okr.constant.FlagOption;
import com.eximbay.okr.constant.MemberLevel;
import com.eximbay.okr.listener.AbstractAuditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "member_history")
@Entity
public class MemberHistory extends AbstractAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HISTORY_SEQ", length = 11)
    private Integer historySeq;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "MEMBER_SEQ", nullable = false)
    private Member member;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "LOCAL_NAME", length = 50)
    private String localName;

    @Column(name = "MEMBER_ID", length = 50)
    private String memberId;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "CONTACT_PHONE", length = 20)
    private String contactPhone;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "INTRODUCTION")
    private String introduction;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "POSITION", length = 20)
    private String position;

    @Column(name = "LEVEL", length = 11)
    private int level;

    @Column(name = "JOINING_DATE", length = 8)
    private String joiningDate;

    @Column(name = "CAREER", length = 11)
    private int career;

    @Column(name = "RETIREMENT_DATE", length = 8)
    private String retirementDate;

    @Column(name = "PASSWORD_MOD_DT")
    private Instant lastPasswordChange;

    @Column(name = "PASSWORD_TEMP_FLAG",length = 1)
    private String passwordTempFlag = FlagOption.N;

    @Column(name = "PASSWORD_ERROR_COUNT", length = 11)
    private int passwordErrorCount = 0;

    @Column(name = "LATEST_LOGIN_DT")
    private Instant lassLoginDate;

    @Column(name = "ADMIN_FLAG",length = 1)
    private String adminFlag;

    @Column(name = "ADMIN_ACCESS_IP", length = 15)
    private String adminAccessIp;

    @Column(name = "USE_FLAG", length = 1)
    private String useFlag;

    @Column(name = "JUSTIFICATION", nullable = false)
    private String justification;
}
