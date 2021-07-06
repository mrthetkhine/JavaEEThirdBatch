package com.javaeethirdbatch.service;

import java.util.ArrayList;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaeethirdbatch.model.Movie;
import com.javaeethirdbatch.repository.MovieJpaRepository;

import lombok.extern.slf4j.Slf4j;

import com.javaeethirdbatch.controller.MovieController;
import com.javaeethirdbatch.dto.*;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieJpaRepository movieRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<MovieDto> getAllMovie() {
		// TODO Auto-generated method stub
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		Iterable<Movie> movies = this.movieRepository.findAll();
		for(Movie movie : movies)
		{
			///log.info("Class "+movie.getClass());
			MovieDto dto = mapper.map(movie, MovieDto.class);
			movieDtos.add(dto);
		}
		
		return movieDtos;
	}
	@Override
	public MovieDto getMovieById(Long id) {
		
		Movie movie = this.movieRepository.findById(id).get();
		MovieDto dto = mapper.map(movie, MovieDto.class);
		
		return dto;
		
	}
	@Override
	public MovieDto saveMovie(MovieDto dto) {
		// TODO Auto-generated method stub
		Movie movie = mapper.map(dto, Movie.class);
		movie = this.movieRepository.save(movie);
		
		return mapper.map(movie, MovieDto.class);
	}

	@Override
	public void deleteMovieById(Long movieId) {
		//Movie movie = mapper.map(dto, Movie.class);
		this.movieRepository.deleteById(movieId);
	}

	

}
