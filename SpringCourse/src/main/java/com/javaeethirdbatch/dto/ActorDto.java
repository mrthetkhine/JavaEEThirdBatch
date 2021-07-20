package com.javaeethirdbatch.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;

import com.javaeethirdbatch.model.Address;
import com.javaeethirdbatch.model.Gender;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ActorDto {
	Long id;
	
	String firstName;

	String lastName;

	String fullName;

	Gender gender;

	Address address;
}
