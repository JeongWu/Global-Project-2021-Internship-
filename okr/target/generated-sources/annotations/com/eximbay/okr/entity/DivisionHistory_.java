package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DivisionHistory.class)
public abstract class DivisionHistory_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<DivisionHistory, Division> division;
	public static volatile SingularAttribute<DivisionHistory, Integer> historySeq;
	public static volatile SingularAttribute<DivisionHistory, String> localName;
	public static volatile SingularAttribute<DivisionHistory, String> useFlag;
	public static volatile SingularAttribute<DivisionHistory, String> name;
	public static volatile SingularAttribute<DivisionHistory, Company> company;
	public static volatile SingularAttribute<DivisionHistory, String> justification;

	public static final String DIVISION = "division";
	public static final String HISTORY_SEQ = "historySeq";
	public static final String LOCAL_NAME = "localName";
	public static final String USE_FLAG = "useFlag";
	public static final String NAME = "name";
	public static final String COMPANY = "company";
	public static final String JUSTIFICATION = "justification";

}

