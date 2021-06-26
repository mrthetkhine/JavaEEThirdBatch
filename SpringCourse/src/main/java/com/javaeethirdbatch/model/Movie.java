package com.javaeethirdbatch.model;

import java.util.List;
import javax.validation.constraints.NotNull; 
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class Movie {
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	
	@NotNull
	@Size(min=5, message="Director must be at least 5 characters long")
	private String director;
	
	@NotNull
	@Range(min=1990, max=2021, message="Year must be between 1990 2021")
	private Long year;
}