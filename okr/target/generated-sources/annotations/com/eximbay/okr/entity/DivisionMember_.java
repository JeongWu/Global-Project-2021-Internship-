package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DivisionMember.class)
public abstract class DivisionMember_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<DivisionMember, DivisionMemberId> divisionMemberId;
	public static volatile SingularAttribute<DivisionMember, String> applyEndDate;
	public static volatile SingularAttribute<DivisionMember, String> justification;

	public static final String DIVISION_MEMBER_ID = "divisionMemberId";
	public static final String APPLY_END_DATE = "applyEndDate";
	public static final String JUSTIFICATION = "justification";

}

