package com.eximbay.okr.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OkrCheckListDetail.class)
public abstract class OkrCheckListDetail_ {

	public static volatile SingularAttribute<OkrCheckListDetail, String> answerCode;
	public static volatile SingularAttribute<OkrCheckListDetail, Instant> createdDate;
	public static volatile SingularAttribute<OkrCheckListDetail, OkrChecklistGroup> okrChecklistGroup;
	public static volatile SingularAttribute<OkrCheckListDetail, String> question;
	public static volatile SingularAttribute<OkrCheckListDetail, String> createdBy;
	public static volatile SingularAttribute<OkrCheckListDetail, CheckList> checkList;
	public static volatile SingularAttribute<OkrCheckListDetail, KeyResult> keyResult;
	public static volatile SingularAttribute<OkrCheckListDetail, Integer> detailSeq;
	public static volatile SingularAttribute<OkrCheckListDetail, String> sourceKeyResult;

	public static final String ANSWER_CODE = "answerCode";
	public static final String CREATED_DATE = "createdDate";
	public static final String OKR_CHECKLIST_GROUP = "okrChecklistGroup";
	public static final String QUESTION = "question";
	public static final String CREATED_BY = "createdBy";
	public static final String CHECK_LIST = "checkList";
	public static final String KEY_RESULT = "keyResult";
	public static final String DETAIL_SEQ = "detailSeq";
	public static final String SOURCE_KEY_RESULT = "sourceKeyResult";

}

