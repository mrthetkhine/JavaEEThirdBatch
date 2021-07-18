package com.javaeethirdbatch.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull; 
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.javaeethirdbatch.model.Genres;

import lombok.Data;


@Data
public class MovieDto {
	
	public MovieDto()
	{
		
	}
	public MovieDto(Long id, String name, String director,Genres genre,Long year)
	{
		this.id = id;
		this.name = name;
		this.director = director;
		this.genre = genre;
		this.year = year;
	}
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
	
	private Long howOld;
	
	private MovieDetailDto movieDetail;
}