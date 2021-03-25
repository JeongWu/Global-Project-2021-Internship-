package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CodeList.class)
public abstract class CodeList_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<CodeList, String> useFlag;
	public static volatile SingularAttribute<CodeList, Integer> sortOrder;
	public static volatile SingularAttribute<CodeList, String> codeName;
	public static volatile SingularAttribute<CodeList, String> description;
	public static volatile SingularAttribute<CodeList, CodeListId> codeListId;

	public static final String USE_FLAG = "useFlag";
	public static final String SORT_ORDER = "sortOrder";
	public static final String CODE_NAME = "codeName";
	public static final String DESCRIPTION = "description";
	public static final String CODE_LIST_ID = "codeListId";

}

