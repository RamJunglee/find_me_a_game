package com.github.junglee.domain;

import java.util.Date;

import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class GameTable {
	@Id
	Long id;

	Long templateId;

	@CreationTimestamp
	Date createdAt;

	@UpdateTimestamp
	Date updatedAt;

	Integer joinedCount;

//	PrizeStructure prizeStruct;
}
