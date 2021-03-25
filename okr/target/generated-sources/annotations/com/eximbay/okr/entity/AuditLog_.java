package com.eximbay.okr.entity;

import com.eximbay.okr.enumeration.LogType;
import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuditLog.class)
public abstract class AuditLog_ {

	public static volatile SingularAttribute<AuditLog, LogType> logType;
	public static volatile SingularAttribute<AuditLog, Instant> createdDate;
	public static volatile SingularAttribute<AuditLog, String> accessIp;
	public static volatile SingularAttribute<AuditLog, String> parameter;
	public static volatile SingularAttribute<AuditLog, String> name;
	public static volatile SingularAttribute<AuditLog, String> comment;
	public static volatile SingularAttribute<AuditLog, Integer> logSeq;
	public static volatile SingularAttribute<AuditLog, String> email;
	public static volatile SingularAttribute<AuditLog, String> target;

	public static final String LOG_TYPE = "logType";
	public static final String CREATED_DATE = "createdDate";
	public static final String ACCESS_IP = "accessIp";
	public static final String PARAMETER = "parameter";
	public static final String NAME = "name";
	public static final String COMMENT = "comment";
	public static final String LOG_SEQ = "logSeq";
	public static final String EMAIL = "email";
	public static final String TARGET = "target";

}

