package com.eximbay.okr.entity;

import com.eximbay.okr.enumeration.CheckListType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CheckList.class)
public abstract class CheckList_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<CheckList, Integer> checkListSeq;
	public static volatile SingularAttribute<CheckList, String> question;
	public static volatile SingularAttribute<CheckList, String> useFlag;
	public static volatile SingularAttribute<CheckList, CheckListType> type;

	public static final String CHECK_LIST_SEQ = "checkListSeq";
	public static final String QUESTION = "question";
	public static final String USE_FLAG = "useFlag";
	public static final String TYPE = "type";

}

