package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DivisionMemberId.class)
public abstract class DivisionMemberId_ {

	public static volatile SingularAttribute<DivisionMemberId, Division> division;
	public static volatile SingularAttribute<DivisionMemberId, String> applyBeginDate;
	public static volatile SingularAttribute<DivisionMemberId, Member> member;

	public static final String DIVISION = "division";
	public static final String APPLY_BEGIN_DATE = "applyBeginDate";
	public static final String MEMBER = "member";

}

