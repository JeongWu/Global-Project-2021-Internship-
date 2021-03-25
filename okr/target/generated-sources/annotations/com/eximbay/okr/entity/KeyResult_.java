package com.eximbay.okr.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(KeyResult.class)
public abstract class KeyResult_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<KeyResult, Integer> proportion;
	public static volatile SingularAttribute<KeyResult, String> endDate;
	public static volatile SingularAttribute<KeyResult, String> keyResult;
	public static volatile SingularAttribute<KeyResult, Integer> keyResultSeq;
	public static volatile SingularAttribute<KeyResult, Objective> objective;
	public static volatile SingularAttribute<KeyResult, String> closeDate;
	public static volatile SingularAttribute<KeyResult, String> beginDate;
	public static volatile SingularAttribute<KeyResult, String> taskType;
	public static volatile SingularAttribute<KeyResult, Instant> lastUpdatedDate;
	public static volatile SingularAttribute<KeyResult, String> closeFlag;
	public static volatile SingularAttribute<KeyResult, String> taskIndicator;
	public static volatile SingularAttribute<KeyResult, String> taskMetric;
	public static volatile SingularAttribute<KeyResult, String> closeJustification;
	public static volatile SingularAttribute<KeyResult, Integer> progress;

	public static final String PROPORTION = "proportion";
	public static final String END_DATE = "endDate";
	public static final String KEY_RESULT = "keyResult";
	public static final String KEY_RESULT_SEQ = "keyResultSeq";
	public static final String OBJECTIVE = "objective";
	public static final String CLOSE_DATE = "closeDate";
	public static final String BEGIN_DATE = "beginDate";
	public static final String TASK_TYPE = "taskType";
	public static final String LAST_UPDATED_DATE = "lastUpdatedDate";
	public static final String CLOSE_FLAG = "closeFlag";
	public static final String TASK_INDICATOR = "taskIndicator";
	public static final String TASK_METRIC = "taskMetric";
	public static final String CLOSE_JUSTIFICATION = "closeJustification";
	public static final String PROGRESS = "progress";

}

