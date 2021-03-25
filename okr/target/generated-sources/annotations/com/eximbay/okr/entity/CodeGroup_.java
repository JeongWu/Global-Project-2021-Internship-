package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CodeGroup.class)
public abstract class CodeGroup_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<CodeGroup, String> useFlag;
	public static volatile ListAttribute<CodeGroup, CodeList> codeLists;
	public static volatile SingularAttribute<CodeGroup, Integer> codeSize;
	public static volatile SingularAttribute<CodeGroup, String> groupCodeName;
	public static volatile SingularAttribute<CodeGroup, String> groupCode;

	public static final String USE_FLAG = "useFlag";
	public static final String CODE_LISTS = "codeLists";
	public static final String CODE_SIZE = "codeSize";
	public static final String GROUP_CODE_NAME = "groupCodeName";
	public static final String GROUP_CODE = "groupCode";

}

