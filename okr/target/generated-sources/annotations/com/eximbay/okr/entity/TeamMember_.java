package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TeamMember.class)
public abstract class TeamMember_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<TeamMember, String> teamLeadFlag;
	public static volatile SingularAttribute<TeamMember, String> editTeamOkrFlag;
	public static volatile SingularAttribute<TeamMember, TeamMemberId> teamMemberId;
	public static volatile SingularAttribute<TeamMember, String> applyEndDate;
	public static volatile SingularAttribute<TeamMember, String> justification;
	public static volatile SingularAttribute<TeamMember, String> teamManagerFlag;

	public static final String TEAM_LEAD_FLAG = "teamLeadFlag";
	public static final String EDIT_TEAM_OKR_FLAG = "editTeamOkrFlag";
	public static final String TEAM_MEMBER_ID = "teamMemberId";
	public static final String APPLY_END_DATE = "applyEndDate";
	public static final String JUSTIFICATION = "justification";
	public static final String TEAM_MANAGER_FLAG = "teamManagerFlag";

}

