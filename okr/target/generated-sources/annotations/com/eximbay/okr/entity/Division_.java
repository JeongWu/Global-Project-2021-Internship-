package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Division.class)
public abstract class Division_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<Division, String> localName;
	public static volatile ListAttribute<Division, DivisionMember> divisionMembers;
	public static volatile SingularAttribute<Division, String> useFlag;
	public static volatile ListAttribute<Division, Team> teams;
	public static volatile SingularAttribute<Division, Integer> divisionSeq;
	public static volatile SingularAttribute<Division, String> name;
	public static volatile SingularAttribute<Division, Company> company;

	public static final String LOCAL_NAME = "localName";
	public static final String DIVISION_MEMBERS = "divisionMembers";
	public static final String USE_FLAG = "useFlag";
	public static final String TEAMS = "teams";
	public static final String DIVISION_SEQ = "divisionSeq";
	public static final String NAME = "name";
	public static final String COMPANY = "company";

}

