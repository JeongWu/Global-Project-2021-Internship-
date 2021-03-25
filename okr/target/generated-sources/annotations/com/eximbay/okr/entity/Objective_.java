package com.eximbay.okr.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Objective.class)
public abstract class Objective_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<Objective, Integer> year;
	public static volatile SingularAttribute<Objective, String> endDate;
	public static volatile SingularAttribute<Objective, Instant> lastUpdateDate;
	public static volatile SingularAttribute<Objective, Team> team;
	public static volatile SingularAttribute<Objective, Integer> priority;
	public static volatile SingularAttribute<Objective, String> objective;
	public static volatile SingularAttribute<Objective, Instant> closeDate;
	public static volatile SingularAttribute<Objective, String> beginDate;
	public static volatile SingularAttribute<Objective, String> closeFlag;
	public static volatile SingularAttribute<Objective, String> closeJustification;
	public static volatile SingularAttribute<Objective, Member> member;
	public static volatile SingularAttribute<Objective, Integer> progress;
	public static volatile SingularAttribute<Objective, Company> company;
	public static volatile SingularAttribute<Objective, Integer> objectiveSeq;
	public static volatile SingularAttribute<Objective, String> objectiveLevel;
	public static volatile SingularAttribute<Objective, Integer> quarter;

	public static final String YEAR = "year";
	public static final String END_DATE = "endDate";
	public static final String LAST_UPDATE_DATE = "lastUpdateDate";
	public static final String TEAM = "team";
	public static final String PRIORITY = "priority";
	public static final String OBJECTIVE = "objective";
	public static final String CLOSE_DATE = "closeDate";
	public static final String BEGIN_DATE = "beginDate";
	public static final String CLOSE_FLAG = "closeFlag";
	public static final String CLOSE_JUSTIFICATION = "closeJustification";
	public static final String MEMBER = "member";
	public static final String PROGRESS = "progress";
	public static final String COMPANY = "company";
	public static final String OBJECTIVE_SEQ = "objectiveSeq";
	public static final String OBJECTIVE_LEVEL = "objectiveLevel";
	public static final String QUARTER = "quarter";

}

