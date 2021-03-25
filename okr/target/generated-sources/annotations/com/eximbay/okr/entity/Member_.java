package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Member.class)
public abstract class Member_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<Member, String> image;
	public static volatile SingularAttribute<Member, String> adminAccessIp;
	public static volatile SingularAttribute<Member, Integer> career;
	public static volatile SingularAttribute<Member, String> retirementDate;
	public static volatile SingularAttribute<Member, Integer> memberSeq;
	public static volatile SingularAttribute<Member, Integer> level;
	public static volatile SingularAttribute<Member, String> editCompanyOkrFlag;
	public static volatile SingularAttribute<Member, String> joiningDate;
	public static volatile ListAttribute<Member, TeamMember> teamMembers;
	public static volatile SingularAttribute<Member, String> localName;
	public static volatile SingularAttribute<Member, String> useFlag;
	public static volatile SingularAttribute<Member, String> name;
	public static volatile SingularAttribute<Member, String> position;
	public static volatile SingularAttribute<Member, String> contactPhone;
	public static volatile SingularAttribute<Member, String> adminFlag;
	public static volatile SingularAttribute<Member, String> email;
	public static volatile SingularAttribute<Member, String> introduction;
	public static volatile SingularAttribute<Member, String> memberId;

	public static final String IMAGE = "image";
	public static final String ADMIN_ACCESS_IP = "adminAccessIp";
	public static final String CAREER = "career";
	public static final String RETIREMENT_DATE = "retirementDate";
	public static final String MEMBER_SEQ = "memberSeq";
	public static final String LEVEL = "level";
	public static final String EDIT_COMPANY_OKR_FLAG = "editCompanyOkrFlag";
	public static final String JOINING_DATE = "joiningDate";
	public static final String TEAM_MEMBERS = "teamMembers";
	public static final String LOCAL_NAME = "localName";
	public static final String USE_FLAG = "useFlag";
	public static final String NAME = "name";
	public static final String POSITION = "position";
	public static final String CONTACT_PHONE = "contactPhone";
	public static final String ADMIN_FLAG = "adminFlag";
	public static final String EMAIL = "email";
	public static final String INTRODUCTION = "introduction";
	public static final String MEMBER_ID = "memberId";

}

