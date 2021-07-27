package com.javaeethirdbatch.repository;

import java.util.List;

import com.javaeethirdbatch.model.Movie;

public interface MovieDAO {
	List<Movie> findAll();
	
	List<Movie> searchMovie(String movieName, String directorName, Long year);
	List<Movie> searchMovieByYear(Long year);
	List<Movie> searchByActor(String actor);
}
