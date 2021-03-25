package com.eximbay.okr.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Feedback.class)
public abstract class Feedback_ {

	public static volatile SingularAttribute<Feedback, Integer> sourceSeq;
	public static volatile SingularAttribute<Feedback, String> feedback;
	public static volatile SingularAttribute<Feedback, Integer> feedbackSeq;
	public static volatile SingularAttribute<Feedback, String> sourceTable;
	public static volatile SingularAttribute<Feedback, Instant> createdDate;
	public static volatile SingularAttribute<Feedback, Member> member;
	public static volatile SingularAttribute<Feedback, Instant> updatedDate;

	public static final String SOURCE_SEQ = "sourceSeq";
	public static final String FEEDBACK = "feedback";
	public static final String FEEDBACK_SEQ = "feedbackSeq";
	public static final String SOURCE_TABLE = "sourceTable";
	public static final String CREATED_DATE = "createdDate";
	public static final String MEMBER = "member";
	public static final String UPDATED_DATE = "updatedDate";

}

