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
import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull; 
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Range;

import com.javaeethirdbatch.service.MovieServiceImpl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
//@Table(name="movie")
@Data
@Slf4j
public class Movie extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Movie()
	{
		
	}
	public Movie(Long id, String name, String director,Genres genre, Long year)
	{
		this.setId(id);
		this.name = name;
		this.director = director;
		this.genre = genre;
		this.year = year;
	}
			
	private String name;
	
	private String director;
		
	private Long year;
	
	@Enumerated(EnumType.STRING)
	//@Column(name="genre")
	private Genres genre;
	
	@Formula("year(now()) -year")
	private Long howOld;
	
	@PostLoad
	private void postLoad()
	{
		log.info("PostLoad for entity "+this.getId());
	}
	@PreUpdate
    private void preUpdateFunction(){
        log.info("PreUpdate method called");
    }

    @PostUpdate
    private void postUpdateFunction(){
        log.info("PostUpdate method called");
    }
}