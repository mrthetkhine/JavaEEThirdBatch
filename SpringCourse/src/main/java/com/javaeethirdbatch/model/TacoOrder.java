package com.javaeethirdbatch.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TacoOrder {

	private String deliveryName;
	private String deliveryStreet;
	private String deliveryCity;
	private String deliveryState;
	private String deliveryZip;
	private String ccNumber;
	private String ccExpiration;
	private String ccCVV;
	private List<Movie> tacos = new ArrayList<>();

	public void addTaco(Movie taco) {
		this.tacos.add(taco);
	}
}