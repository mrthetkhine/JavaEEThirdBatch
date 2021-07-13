package com.javaeethirdbatch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.javaeethirdbatch.controller.rest.MovieRestController;
import com.javaeethirdbatch.dto.MovieDto;
import com.javaeethirdbatch.model.Genres;
import com.javaeethirdbatch.model.Movie;
import com.javaeethirdbatch.repository.MovieJpaRepository;

@WebMvcTest(MovieService.class)
public class MovieServiceTest {
	
	@Autowired
    MovieService movieService;
	
	@MockBean
	MovieJpaRepository movieRepository;
	
	Movie m1 = new Movie(1L,"Movie 1","Director 1",Genres.Action,2000L);
	Movie m2 = new Movie(2L,"Movie 2","Director 2",Genres.Action,2000L);
	Movie m3 = new Movie(3L,"Movie 3","Director 3",Genres.Action,2000L);
	
	@Test
	public void testGetAllMovie()
	{
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		//Iterable<Movie> records = movies;
		
		Mockito.when(movieRepository.getAllMovieByJPQL()).thenReturn(movies);
		List<MovieDto> movieDtos = this.movieService.getAllMovie();
		
		assertEquals(3, movieDtos.size());
		
		assertNotNull(movieDtos.get(0));
		assertEquals(movieDtos.get(0).getName(),"Movie 1");
		assertNotNull(movieDtos.get(1));
		assertNotNull(movieDtos.get(2));
	}
}
