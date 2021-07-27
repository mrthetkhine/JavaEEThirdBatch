package com.javaeethirdbatch.service;

import java.util.List;

import com.javaeethirdbatch.dto.MovieDto;
import com.javaeethirdbatch.dto.MovieIdActorCount;


public interface MovieService {
	List<MovieDto> getAllMovieByPage(int pageNo, int size);
	List<MovieDto> getAllMovie();
	
	List<MovieDto> searchMovie(String movieName, String directorName, Long year);
	List<MovieDto> searchMovieByYear(Long year);
	List<MovieDto> searchByActor(String actor);
	
	List<MovieDto> getMovieByName(String name);
	List<MovieDto> getMovieByNameLike(String name);
	List<MovieDto> getMovieByNameContain(String name);
	List<MovieDto> getMovieByYearGreaterThan(Long year);
	
	List<MovieDto> getMovieByDirectorName(String director);
	List<MovieDto> getMovieWithActorName(String actorName);
	List<MovieDto> getMovieWithDetailText(String text);
	List<Object[]> getMovieWithActorCount();
	List<MovieIdActorCount> getMovieWithActorCountWithDtoProjection();
	
	MovieDto getMovieById(Long id);
	MovieDto saveMovie(MovieDto movie);
	void deleteMovieById(Long movieId);
}
