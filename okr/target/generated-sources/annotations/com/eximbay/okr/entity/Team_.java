package com.eximbay.okr.entity;

import com.eximbay.okr.enumeration.TeamType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Team.class)
public abstract class Team_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<Team, Division> division;
	public static volatile SingularAttribute<Team, String> localName;
	public static volatile SingularAttribute<Team, String> image;
	public static volatile SingularAttribute<Team, Integer> teamSeq;
	public static volatile SingularAttribute<Team, String> useFlag;
	public static volatile SingularAttribute<Team, String> name;
	public static volatile ListAttribute<Team, Objective> objectives;
	public static volatile SingularAttribute<Team, TeamType> teamType;
	public static volatile ListAttribute<Team, TeamMember> teamMembers;
	public static volatile SingularAttribute<Team, String> introduction;

	public static final String DIVISION = "division";
	public static final String LOCAL_NAME = "localName";
	public static final String IMAGE = "image";
	public static final String TEAM_SEQ = "teamSeq";
	public static final String USE_FLAG = "useFlag";
	public static final String NAME = "name";
	public static final String OBJECTIVES = "objectives";
	public static final String TEAM_TYPE = "teamType";
	public static final String TEAM_MEMBERS = "teamMembers";
	public static final String INTRODUCTION = "introduction";

}

