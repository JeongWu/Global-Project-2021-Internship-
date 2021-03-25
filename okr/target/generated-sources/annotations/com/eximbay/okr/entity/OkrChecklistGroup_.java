package com.eximbay.okr.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OkrChecklistGroup.class)
public abstract class OkrChecklistGroup_ {

	public static volatile SingularAttribute<OkrChecklistGroup, Integer> objectiveScore;
	public static volatile SingularAttribute<OkrChecklistGroup, Integer> keyResult2Score;
	public static volatile SingularAttribute<OkrChecklistGroup, Integer> keyResult4Score;
	public static volatile SingularAttribute<OkrChecklistGroup, String> sourceObjective;
	public static volatile SingularAttribute<OkrChecklistGroup, Instant> createdDate;
	public static volatile SingularAttribute<OkrChecklistGroup, Integer> keyResult1Score;
	public static volatile SingularAttribute<OkrChecklistGroup, Integer> keyResult5Score;
	public static volatile SingularAttribute<OkrChecklistGroup, String> createdBy;
	public static volatile SingularAttribute<OkrChecklistGroup, Integer> keyResult3Score;
	public static volatile SingularAttribute<OkrChecklistGroup, Integer> groupSeq;
	public static volatile SingularAttribute<OkrChecklistGroup, Objective> objective;

	public static final String OBJECTIVE_SCORE = "objectiveScore";
	public static final String KEY_RESULT2_SCORE = "keyResult2Score";
	public static final String KEY_RESULT4_SCORE = "keyResult4Score";
	public static final String SOURCE_OBJECTIVE = "sourceObjective";
	public static final String CREATED_DATE = "createdDate";
	public static final String KEY_RESULT1_SCORE = "keyResult1Score";
	public static final String KEY_RESULT5_SCORE = "keyResult5Score";
	public static final String CREATED_BY = "createdBy";
	public static final String KEY_RESULT3_SCORE = "keyResult3Score";
	public static final String GROUP_SEQ = "groupSeq";
	public static final String OBJECTIVE = "objective";

}

