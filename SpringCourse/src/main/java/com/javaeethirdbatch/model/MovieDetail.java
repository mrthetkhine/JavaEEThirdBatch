package com.javaeethirdbatch.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@Slf4j
public class MovieDetail extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String description;

	@ToString.Exclude
	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="movie_id")
	Movie movie;
	
}
