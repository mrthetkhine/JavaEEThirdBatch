package com.javaeethirdbatch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Formula;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
//@Table(name="movie")
@Data
@Slf4j
public class Actor extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="firstName")
	String firstName;
	
	@Column(name="lastName")
	String lastName;
	
	
	@Formula("concat(first_name,\" \",last_name)")
	String fullName;
	
	@Enumerated(EnumType.ORDINAL)
	Gender gender;

}