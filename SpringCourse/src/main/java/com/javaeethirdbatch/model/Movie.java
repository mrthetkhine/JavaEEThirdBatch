package com.javaeethirdbatch.model;

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

import lombok.Data;

@Entity
//@Table(name="movie")
@Data
public class Movie implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Movie()
	{
		
	}
	public Movie(Long id, String name, String director,Genres genre, Long year)
	{
		this.id = id;
		this.name = name;
		this.director = director;
		this.genre = genre;
		this.year = year;
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	
	private String name;
	
	private String director;
		
	private Long year;
	
	@Enumerated(EnumType.STRING)
	//@Column(name="genre")
	private Genres genre;
	
	@Column(name="createAt")
	private Date createAt = new Date();
	
	@Column(name="updateAt")
	private Date updateAt = new Date();
}