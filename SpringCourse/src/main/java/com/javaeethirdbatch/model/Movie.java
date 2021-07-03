package com.javaeethirdbatch.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull; 
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Entity
@Data
public class Movie {
	
	@Id
	private Long id;
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	@Column(name="name")
	private String name;
	
	@NotNull
	@Size(min=5, message="Director must be at least 5 characters long")
	@Column(name="director")
	private String director;
	
	@NotNull
	@Range(min=1990, max=2021, message="Year must be between 1990 2021")
	private Long year;
	
	private Genres genre;
	
	private Date createAt = new Date();
	
	private Date updateAt = new Date();
}