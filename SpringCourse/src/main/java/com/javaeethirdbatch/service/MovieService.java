package com.javaeethirdbatch.service;

import java.util.List;

import com.javaeethirdbatch.dto.MovieDto;


public interface MovieService {
	List<MovieDto> getAllMovie();
	MovieDto saveMovie(MovieDto movie);
	void deleteMovie(MovieDto movie);
}
