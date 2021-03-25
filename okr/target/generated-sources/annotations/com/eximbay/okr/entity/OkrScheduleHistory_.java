package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OkrScheduleHistory.class)
public abstract class OkrScheduleHistory_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<OkrScheduleHistory, Integer> historySeq;
	public static volatile SingularAttribute<OkrScheduleHistory, String> remindTime;
	public static volatile SingularAttribute<OkrScheduleHistory, String> scheduleType;
	public static volatile SingularAttribute<OkrScheduleHistory, String> remindBeforeDays;
	public static volatile SingularAttribute<OkrScheduleHistory, Integer> beginDay;
	public static volatile SingularAttribute<OkrScheduleHistory, Integer> endDay;
	public static volatile SingularAttribute<OkrScheduleHistory, Integer> closeAfterDays;
	public static volatile SingularAttribute<OkrScheduleHistory, OkrSchedule> okrSchedule;
	public static volatile SingularAttribute<OkrScheduleHistory, String> justification;

	public static final String HISTORY_SEQ = "historySeq";
	public static final String REMIND_TIME = "remindTime";
	public static final String SCHEDULE_TYPE = "scheduleType";
	public static final String REMIND_BEFORE_DAYS = "remindBeforeDays";
	public static final String BEGIN_DAY = "beginDay";
	public static final String END_DAY = "endDay";
	public static final String CLOSE_AFTER_DAYS = "closeAfterDays";
	public static final String OKR_SCHEDULE = "okrSchedule";
	public static final String JUSTIFICATION = "justification";

}

