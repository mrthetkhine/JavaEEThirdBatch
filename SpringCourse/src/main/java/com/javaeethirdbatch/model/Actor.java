package com.javaeethirdbatch.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@Slf4j
public class Actor extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "firstName")
	String firstName;

	@NotNull
	@Column(name = "lastName")
	String lastName;

	@Formula("concat(first_name,\" \",last_name)")
	String fullName;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	Gender gender;

	Address address;

	@ToString.Exclude
	@ManyToMany(fetch = FetchType.LAZY, 
				cascade = CascadeType.ALL, 
				mappedBy = "actors")
	private List<Movie> movies;

}
