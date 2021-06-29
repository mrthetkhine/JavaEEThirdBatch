package com.javaeethirdbatch.model;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull; 
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class Movie {
	
	private Long id;
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	
	@NotNull
	@Size(min=5, message="Director must be at least 5 characters long")
	private String director;
	
	@NotNull
	@Range(min=1990, max=2021, message="Year must be between 1990 2021")
	private Long year;
	
	private Genres genre;
	
	private Date createAt = new Date();
	
	private Date updateAt = new Date();
}