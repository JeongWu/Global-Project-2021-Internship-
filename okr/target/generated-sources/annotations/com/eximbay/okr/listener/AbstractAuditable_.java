package com.eximbay.okr.listener;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractAuditable.class)
public abstract class AbstractAuditable_ {

	public static volatile SingularAttribute<AbstractAuditable, String> updatedBy;
	public static volatile SingularAttribute<AbstractAuditable, Instant> createdDate;
	public static volatile SingularAttribute<AbstractAuditable, String> createdBy;
	public static volatile SingularAttribute<AbstractAuditable, Instant> updatedDate;

	public static final String UPDATED_BY = "updatedBy";
	public static final String CREATED_DATE = "createdDate";
	public static final String CREATED_BY = "createdBy";
	public static final String UPDATED_DATE = "updatedDate";

}

