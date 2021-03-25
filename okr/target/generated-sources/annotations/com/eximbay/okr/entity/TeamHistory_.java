package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TeamHistory.class)
public abstract class TeamHistory_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<TeamHistory, Division> division;
	public static volatile SingularAttribute<TeamHistory, Integer> historySeq;
	public static volatile SingularAttribute<TeamHistory, String> localName;
	public static volatile SingularAttribute<TeamHistory, String> image;
	public static volatile SingularAttribute<TeamHistory, String> useFlag;
	public static volatile SingularAttribute<TeamHistory, String> name;
	public static volatile SingularAttribute<TeamHistory, Team> team;
	public static volatile SingularAttribute<TeamHistory, String> justification;
	public static volatile SingularAttribute<TeamHistory, String> teamType;
	public static volatile SingularAttribute<TeamHistory, String> introduction;

	public static final String DIVISION = "division";
	public static final String HISTORY_SEQ = "historySeq";
	public static final String LOCAL_NAME = "localName";
	public static final String IMAGE = "image";
	public static final String USE_FLAG = "useFlag";
	public static final String NAME = "name";
	public static final String TEAM = "team";
	public static final String JUSTIFICATION = "justification";
	public static final String TEAM_TYPE = "teamType";
	public static final String INTRODUCTION = "introduction";

}

