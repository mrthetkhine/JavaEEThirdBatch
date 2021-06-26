package com.javaeethirdbatch.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ShoppingCart {

	
	private List<Movie> movies = new ArrayList<>();

	public void addMovie(Movie movie) {
		this.movies.add(movie);
	}
}
