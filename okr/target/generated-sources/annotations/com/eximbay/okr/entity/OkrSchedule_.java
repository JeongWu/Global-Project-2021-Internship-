package com.eximbay.okr.entity;

import com.eximbay.okr.enumeration.ScheduleType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OkrSchedule.class)
public abstract class OkrSchedule_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<OkrSchedule, String> remindTime;
	public static volatile SingularAttribute<OkrSchedule, ScheduleType> scheduleType;
	public static volatile SingularAttribute<OkrSchedule, String> remindBeforeDays;
	public static volatile SingularAttribute<OkrSchedule, Integer> beginDay;
	public static volatile SingularAttribute<OkrSchedule, Integer> scheduleSeq;
	public static volatile SingularAttribute<OkrSchedule, Integer> endDay;
	public static volatile SingularAttribute<OkrSchedule, Integer> closeAfterDays;

	public static final String REMIND_TIME = "remindTime";
	public static final String SCHEDULE_TYPE = "scheduleType";
	public static final String REMIND_BEFORE_DAYS = "remindBeforeDays";
	public static final String BEGIN_DAY = "beginDay";
	public static final String SCHEDULE_SEQ = "scheduleSeq";
	public static final String END_DAY = "endDay";
	public static final String CLOSE_AFTER_DAYS = "closeAfterDays";

}

