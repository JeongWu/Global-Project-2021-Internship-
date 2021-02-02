package com.eximbay.okr.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "member2")
public class Member2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_SEQ", length = 11)
    private Integer memberSeq;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    // @OneToMany(mappedBy = "member2",cascade = CascadeType.PERSIST)
    // private List<TeamMember> teamMembers;
    
}
