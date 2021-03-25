package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TeamMemberId.class)
public abstract class TeamMemberId_ {

	public static volatile SingularAttribute<TeamMemberId, String> applyBeginDate;
	public static volatile SingularAttribute<TeamMemberId, Member> member;
	public static volatile SingularAttribute<TeamMemberId, Team> team;

	public static final String APPLY_BEGIN_DATE = "applyBeginDate";
	public static final String MEMBER = "member";
	public static final String TEAM = "team";

}

