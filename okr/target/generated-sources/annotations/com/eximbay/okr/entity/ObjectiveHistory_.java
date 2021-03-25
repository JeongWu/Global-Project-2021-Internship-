package com.eximbay.okr.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ObjectiveHistory.class)
public abstract class ObjectiveHistory_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<ObjectiveHistory, Integer> historySeq;
	public static volatile SingularAttribute<ObjectiveHistory, Integer> year;
	public static volatile SingularAttribute<ObjectiveHistory, String> endDate;
	public static volatile SingularAttribute<ObjectiveHistory, Instant> lastUpdateDate;
	public static volatile SingularAttribute<ObjectiveHistory, Objective> objectiveObject;
	public static volatile SingularAttribute<ObjectiveHistory, Team> team;
	public static volatile SingularAttribute<ObjectiveHistory, Integer> priority;
	public static volatile SingularAttribute<ObjectiveHistory, String> objectiveType;
	public static volatile SingularAttribute<ObjectiveHistory, String> objective;
	public static volatile SingularAttribute<ObjectiveHistory, Instant> closeDate;
	public static volatile SingularAttribute<ObjectiveHistory, String> beginDate;
	public static volatile SingularAttribute<ObjectiveHistory, String> closeFlag;
	public static volatile SingularAttribute<ObjectiveHistory, String> closeJustification;
	public static volatile SingularAttribute<ObjectiveHistory, Member> member;
	public static volatile SingularAttribute<ObjectiveHistory, Integer> progress;
	public static volatile SingularAttribute<ObjectiveHistory, Company> company;
	public static volatile SingularAttribute<ObjectiveHistory, String> justification;
	public static volatile SingularAttribute<ObjectiveHistory, Integer> quarter;

	public static final String HISTORY_SEQ = "historySeq";
	public static final String YEAR = "year";
	public static final String END_DATE = "endDate";
	public static final String LAST_UPDATE_DATE = "lastUpdateDate";
	public static final String OBJECTIVE_OBJECT = "objectiveObject";
	public static final String TEAM = "team";
	public static final String PRIORITY = "priority";
	public static final String OBJECTIVE_TYPE = "objectiveType";
	public static final String OBJECTIVE = "objective";
	public static final String CLOSE_DATE = "closeDate";
	public static final String BEGIN_DATE = "beginDate";
	public static final String CLOSE_FLAG = "closeFlag";
	public static final String CLOSE_JUSTIFICATION = "closeJustification";
	public static final String MEMBER = "member";
	public static final String PROGRESS = "progress";
	public static final String COMPANY = "company";
	public static final String JUSTIFICATION = "justification";
	public static final String QUARTER = "quarter";

}

