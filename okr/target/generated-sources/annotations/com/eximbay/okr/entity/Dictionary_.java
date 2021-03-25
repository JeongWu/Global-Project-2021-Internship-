package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Dictionary.class)
public abstract class Dictionary_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<Dictionary, String> sentence;
	public static volatile SingularAttribute<Dictionary, String> taskType;
	public static volatile SingularAttribute<Dictionary, Integer> dictionarySeq;
	public static volatile SingularAttribute<Dictionary, String> useFlag;
	public static volatile SingularAttribute<Dictionary, String> taskIndicator;
	public static volatile SingularAttribute<Dictionary, String> dictionaryType;
	public static volatile SingularAttribute<Dictionary, String> taskMetric;
	public static volatile SingularAttribute<Dictionary, String> description;
	public static volatile SingularAttribute<Dictionary, String> jobType;
	public static volatile SingularAttribute<Dictionary, String> category;
	public static volatile SingularAttribute<Dictionary, String> categoryGroup;

	public static final String SENTENCE = "sentence";
	public static final String TASK_TYPE = "taskType";
	public static final String DICTIONARY_SEQ = "dictionarySeq";
	public static final String USE_FLAG = "useFlag";
	public static final String TASK_INDICATOR = "taskIndicator";
	public static final String DICTIONARY_TYPE = "dictionaryType";
	public static final String TASK_METRIC = "taskMetric";
	public static final String DESCRIPTION = "description";
	public static final String JOB_TYPE = "jobType";
	public static final String CATEGORY = "category";
	public static final String CATEGORY_GROUP = "categoryGroup";

}

