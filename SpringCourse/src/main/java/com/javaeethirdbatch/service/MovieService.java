package com.javaeethirdbatch.service;

import java.util.List;

import com.javaeethirdbatch.dto.MovieDto;
import com.javaeethirdbatch.model.Movie;

public interface MovieService {
	List<MovieDto> getAllMovie();
	MovieDto saveMovie(MovieDto movie);
}
