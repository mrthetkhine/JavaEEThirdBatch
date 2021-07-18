package com.javaeethirdbatch.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Data
@Slf4j
public class MovieDetailDto {
		
	String description;

	
}
