package com.javaeethirdbatch.service;

import java.util.List;

import com.javaeethirdbatch.dto.MovieDto;


public interface MovieService {
	List<MovieDto> getAllMovie();
	List<MovieDto> getMovieByName(String name);
	List<MovieDto> getMovieByNameLike(String name);
	MovieDto getMovieById(Long id);
	MovieDto saveMovie(MovieDto movie);
	void deleteMovieById(Long movieId);
}
