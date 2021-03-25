package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MemberHistory.class)
public abstract class MemberHistory_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<MemberHistory, Integer> historySeq;
	public static volatile SingularAttribute<MemberHistory, String> image;
	public static volatile SingularAttribute<MemberHistory, String> adminAccessIp;
	public static volatile SingularAttribute<MemberHistory, Integer> career;
	public static volatile SingularAttribute<MemberHistory, String> retirementDate;
	public static volatile SingularAttribute<MemberHistory, Integer> level;
	public static volatile SingularAttribute<MemberHistory, String> editCompanyOkrFlag;
	public static volatile SingularAttribute<MemberHistory, String> joiningDate;
	public static volatile SingularAttribute<MemberHistory, String> localName;
	public static volatile SingularAttribute<MemberHistory, String> useFlag;
	public static volatile SingularAttribute<MemberHistory, Member> member;
	public static volatile SingularAttribute<MemberHistory, String> name;
	public static volatile SingularAttribute<MemberHistory, String> position;
	public static volatile SingularAttribute<MemberHistory, String> justification;
	public static volatile SingularAttribute<MemberHistory, String> contactPhone;
	public static volatile SingularAttribute<MemberHistory, String> adminFlag;
	public static volatile SingularAttribute<MemberHistory, String> email;
	public static volatile SingularAttribute<MemberHistory, String> introduction;
	public static volatile SingularAttribute<MemberHistory, String> memberId;

	public static final String HISTORY_SEQ = "historySeq";
	public static final String IMAGE = "image";
	public static final String ADMIN_ACCESS_IP = "adminAccessIp";
	public static final String CAREER = "career";
	public static final String RETIREMENT_DATE = "retirementDate";
	public static final String LEVEL = "level";
	public static final String EDIT_COMPANY_OKR_FLAG = "editCompanyOkrFlag";
	public static final String JOINING_DATE = "joiningDate";
	public static final String LOCAL_NAME = "localName";
	public static final String USE_FLAG = "useFlag";
	public static final String MEMBER = "member";
	public static final String NAME = "name";
	public static final String POSITION = "position";
	public static final String JUSTIFICATION = "justification";
	public static final String CONTACT_PHONE = "contactPhone";
	public static final String ADMIN_FLAG = "adminFlag";
	public static final String EMAIL = "email";
	public static final String INTRODUCTION = "introduction";
	public static final String MEMBER_ID = "memberId";

}

