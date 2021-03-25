package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Company.class)
public abstract class Company_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<Company, String> localName;
	public static volatile SingularAttribute<Company, String> googleClientSecretKey;
	public static volatile SingularAttribute<Company, String> domain;
	public static volatile SingularAttribute<Company, String> name;
	public static volatile SingularAttribute<Company, String> logo;
	public static volatile SingularAttribute<Company, String> googleSignIn;
	public static volatile SingularAttribute<Company, Integer> companySeq;
	public static volatile SingularAttribute<Company, String> googleClientId;
	public static volatile ListAttribute<Company, Division> divisions;

	public static final String LOCAL_NAME = "localName";
	public static final String GOOGLE_CLIENT_SECRET_KEY = "googleClientSecretKey";
	public static final String DOMAIN = "domain";
	public static final String NAME = "name";
	public static final String LOGO = "logo";
	public static final String GOOGLE_SIGN_IN = "googleSignIn";
	public static final String COMPANY_SEQ = "companySeq";
	public static final String GOOGLE_CLIENT_ID = "googleClientId";
	public static final String DIVISIONS = "divisions";

}

