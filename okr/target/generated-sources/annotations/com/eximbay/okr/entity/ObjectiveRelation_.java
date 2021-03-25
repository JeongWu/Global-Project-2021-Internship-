package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ObjectiveRelation.class)
public abstract class ObjectiveRelation_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<ObjectiveRelation, Objective> relatedObjective;
	public static volatile SingularAttribute<ObjectiveRelation, Integer> relationSeq;
	public static volatile SingularAttribute<ObjectiveRelation, String> useFlag;
	public static volatile SingularAttribute<ObjectiveRelation, KeyResult> topKeyResult;
	public static volatile SingularAttribute<ObjectiveRelation, Objective> objective;

	public static final String RELATED_OBJECTIVE = "relatedObjective";
	public static final String RELATION_SEQ = "relationSeq";
	public static final String USE_FLAG = "useFlag";
	public static final String TOP_KEY_RESULT = "topKeyResult";
	public static final String OBJECTIVE = "objective";

}

