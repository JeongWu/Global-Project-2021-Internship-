package com.eximbay.okr.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(KeyResultCollaborator.class)
public abstract class KeyResultCollaborator_ extends com.eximbay.okr.listener.AbstractAuditable_ {

	public static volatile SingularAttribute<KeyResultCollaborator, Integer> cbSeq;
	public static volatile SingularAttribute<KeyResultCollaborator, String> useFlag;
	public static volatile SingularAttribute<KeyResultCollaborator, String> collaboration;
	public static volatile SingularAttribute<KeyResultCollaborator, KeyResult> keyResult;
	public static volatile SingularAttribute<KeyResultCollaborator, KeyResult> relatedKeyResult;
	public static volatile SingularAttribute<KeyResultCollaborator, Member> collaborator;

	public static final String CB_SEQ = "cbSeq";
	public static final String USE_FLAG = "useFlag";
	public static final String COLLABORATION = "collaboration";
	public static final String KEY_RESULT = "keyResult";
	public static final String RELATED_KEY_RESULT = "relatedKeyResult";
	public static final String COLLABORATOR = "collaborator";

}

