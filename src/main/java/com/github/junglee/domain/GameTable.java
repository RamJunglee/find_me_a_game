package com.github.junglee.domain;

import java.util.Date;

import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class GameTable {
	@Id
	Integer id;

	Integer templateId;

	@CreationTimestamp
	Date createdAt;

	@UpdateTimestamp
	Date updatedAt;

	Integer joinedCount;

//	PrizeStructure prizeStruct;
}
