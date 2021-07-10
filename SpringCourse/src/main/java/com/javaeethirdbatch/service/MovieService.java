package com.javaeethirdbatch.service;

import java.util.List;

import com.javaeethirdbatch.dto.MovieDto;


public interface MovieService {
	List<MovieDto> getAllMovieByPage(int pageNo, int size);
	List<MovieDto> getAllMovie();
	List<MovieDto> getMovieByName(String name);
	List<MovieDto> getMovieByNameLike(String name);
	List<MovieDto> getMovieByNameContain(String name);
	List<MovieDto> getMovieByYearGreaterThan(Long year);
	MovieDto getMovieById(Long id);
	MovieDto saveMovie(MovieDto movie);
	void deleteMovieById(Long movieId);
}
