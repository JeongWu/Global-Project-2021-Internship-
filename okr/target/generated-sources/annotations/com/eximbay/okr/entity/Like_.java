package com.eximbay.okr.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Like.class)
public abstract class Like_ {

	public static volatile SingularAttribute<Like, Integer> sourceSeq;
	public static volatile SingularAttribute<Like, String> sourceTable;
	public static volatile SingularAttribute<Like, Instant> createdDate;
	public static volatile SingularAttribute<Like, Integer> likeSeq;
	public static volatile SingularAttribute<Like, Member> member;

	public static final String SOURCE_SEQ = "sourceSeq";
	public static final String SOURCE_TABLE = "sourceTable";
	public static final String CREATED_DATE = "createdDate";
	public static final String LIKE_SEQ = "likeSeq";
	public static final String MEMBER = "member";

}

