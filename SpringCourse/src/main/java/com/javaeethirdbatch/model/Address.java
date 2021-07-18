package com.javaeethirdbatch.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	
	public String street;
	public String township;
	public String city;


}