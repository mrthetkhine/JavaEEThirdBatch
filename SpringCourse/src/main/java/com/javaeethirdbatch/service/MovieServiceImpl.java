package com.javaeethirdbatch.service;

import java.lang.reflect.Type;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javaeethirdbatch.model.Comment;
import com.javaeethirdbatch.model.Movie;
import com.javaeethirdbatch.model.MovieDetail;
import com.javaeethirdbatch.repository.MovieDAO;
import com.javaeethirdbatch.repository.MovieJpaRepository;
import com.javaeethirdbatch.service.specification.MovieSpecification;

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
	
	@Autowired
	MovieDAO movieDao;
	
	@Override
	public List<MovieDto> getAllMovie() {
		// TODO Auto-generated method stub
		//Iterable<Movie> movies = this.movieRepository.findAll();
		//Iterable<Movie> movies = this.movieRepository.getAllMovie();
		//Iterable<Movie> movies= this.movieRepository.getAllMovieByJPQL();
		List<Movie> movies = this.movieDao.findAll();
		return entityListToDto(movies);
	}
	@Override
	public
	List<MovieDto> searchMovie(String movieName, String directorName, Long year)
	{
		//Used DAO Criteria API
		//List<Movie> movies = this.movieDao.searchMovie(movieName, directorName, year);
		
		//Use JPA Specification
		//List<Movie> movies = this.movieRepository.findAll(MovieSpecification.getAllMovie(movieName, directorName, year));
		
		//Use QBE
		Movie movie = new Movie();
		if(movieName !=null)
		{
			movie.setName(movieName);
		}
		if(directorName != null)
		{
			movie.setDirector(directorName);
		}
		if(year != null)
		{
			movie.setYear(year);
		}
		
		//Or
		ExampleMatcher matcher = ExampleMatcher.matchingAny();
		
		//And
		matcher = ExampleMatcher.matchingAll();
		Example<Movie> movieExample = Example.of(movie,matcher);
		
		
		log.info("Find Movie by director,movie, year with QBE");
		Iterable<Movie> movies = this.movieRepository.findAll(movieExample);
		return entityListToDto(movies);
		
	}
	@Override
	public List<MovieDto> searchMovieByYear(Long year) {
		List<Movie> movies = this.movieDao.searchMovieByYear( year);
		return entityListToDto(movies);
	}
	@Override
	public List<MovieDto> searchByActor(String actor){
		List<Movie> movies = this.movieDao.searchByActor( actor);
		return entityListToDto(movies);
	}
	@Override
	public List<MovieDto> getMovieByName(String name) {
		Iterable<Movie> movies = this.movieRepository.findByName(name);
		return entityListToDto(movies);
	}
	@Override
	public List<MovieDto> getMovieByNameLike(String name) {
		Iterable<Movie> movies = this.movieRepository.findByNameLike(name);
		
		return entityListToDto(movies);
	}
	@Override
	public List<MovieDto> getMovieByNameContain(String name) {
		Iterable<Movie> movies = this.movieRepository.findByNameContaining(name);
		
		return entityListToDto(movies);
	}
	@Override
	public List<MovieDto> getMovieByYearGreaterThan(Long year) {
		Iterable<Movie> movies = this.movieRepository.findByYearGreaterThan(year);
		
		return entityListToDto(movies);
	}
	@Override
	public List<MovieDto> getMovieByDirectorName(String director){
		//JPA repository
		//Iterable<Movie> movies = this.movieRepository.getMovieByDirector(director);
		
		//Use sepcification
		//Iterable<Movie> movies = this.movieRepository.findAll(MovieSpecification.getAllMovieByDirectorName(director));
		
		
		//Use query by example
		
		/*
		Movie movie = new Movie();
		movie.setDirector(director);
		
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase();
		//Example<Movie> movieExample = Example.of(movie);
	
		Example<Movie> movieExample = Example.of(movie,matcher);
		
		log.info("Find Movie by director with QBE");
		*/
		//Find moview with director name end with ron
		return getDirectorEndWith("ron");
	}
	private List<MovieDto> getDirectorEndWith(String suffix) {
		Movie movie = new Movie();
		movie.setDirector(suffix);
		
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withStringMatcher(ExampleMatcher.StringMatcher.ENDING);
		//Example<Movie> movieExample = Example.of(movie);
	
		Example<Movie> movieExample = Example.of(movie,matcher);
		
		log.info("Find Movie by director with QBE");
		Iterable<Movie> movies = this.movieRepository.findAll(movieExample);
		return entityListToDto(movies);
	}
	
	@Override
	public List<MovieDto> getMovieWithActorName(String actorName){
		Iterable<Movie> movies = this.movieRepository.getMovieWithActor(actorName);
		
		return entityListToDto(movies);
	}
	@Override
	public List<MovieDto> getMovieWithDetailText(String text)
	{
		Iterable<Movie> movies = this.movieRepository.getMovieThatContainDescription(text);
		
		return entityListToDto(movies);
	}
	@Override
	public List<Object[]> getMovieWithActorCount()
	{
		return this.movieRepository.getMovieWithActorCount();
	}
	
	@Override
	public List<MovieIdActorCount> getMovieWithActorCountWithDtoProjection()
	{
		return this.movieRepository.getMovieWithActorCountWithDtoProjection();
	}
	
	private List<MovieDto> entityListToDto(Iterable<Movie> movies) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
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
		
		Optional<Movie> movieOpt = this.movieRepository.findById(id);
		if(movieOpt.isPresent())
		{
			Movie movie = movieOpt.get();
			MovieDto dto = mapper.map(movie, MovieDto.class);
			log.info("Movie "+movie);
			return dto;
		}
		else
		{
			return new MovieDto();
		}
		
	}
	@Override
	public MovieDto saveMovie(MovieDto dto) {
		// TODO Auto-generated method stub
		Movie movie = mapMovieDtoToEntity(dto);
		
		movie = this.movieRepository.save(movie);
		
		log.info("Movie Service After saveMovie "+movie);
		return mapper.map(movie, MovieDto.class);
	}
	private Movie mapMovieDtoToEntity(MovieDto dto) {
		Movie movie = mapper.map(dto, Movie.class);
		
		log.info("Movie Service Before saveMovie "+movie);
		
		MovieDetail movieDetail = mapper.map(dto.getMovieDetail(), MovieDetail.class);
		
		movie.setMovieDetail(movieDetail);
		movieDetail.setMovie(movie);
		
		Type targetListType = new TypeToken<List<Comment>>() {}.getType();
		List<Comment> comments = mapper.map(dto.getComments(), targetListType);
		for(Comment comment : comments )
		{
			comment.setMovie(movie);
		}
		movie.setComments(comments);
		return movie;
	}

	@Transactional
	@Override
	public void deleteMovieById(Long movieId) {
		//Movie movie = mapper.map(dto, Movie.class);
		//this.movieRepository.deleteById(movieId);
		this.movieRepository.deleteMovieByIdJPQL(movieId);
	}
	@Override
	public List<MovieDto> getAllMovieByPage(int pageNo, int size) {
		Iterable<Movie> movies = this.movieRepository.findAll(PageRequest.of(pageNo, size,Sort.by(Sort.DEFAULT_DIRECTION.ASC,"name")));
		return entityListToDto(movies);
	}
	
	
	
	
	

}
