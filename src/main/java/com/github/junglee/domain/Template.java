package com.github.junglee.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
@Table( name = "template" )
@Entity
public class Template
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	protected long id;
	
	@Column(name = "type")
	@NotNull
	private int type;
	
	@Column(name = "format")
	@NotNull
	private int format;
	
	@Column(name = "size")
	@NotNull
	private int size;
	
	@Column(name = "entry_fee")
	@NotNull
	private int entryFee;

}
