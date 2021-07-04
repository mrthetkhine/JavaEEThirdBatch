package com.javaeethirdbatch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.javaeethirdbatch.model.Movie;
import com.javaeethirdbatch.model.ShoppingCart;
import com.javaeethirdbatch.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/")
	public String home()
	{
		log.info("Home Controller");
		//List<Movie> movies = this.movieRepository.findAll();
		//log.info("Movies "+ movies.get(0));
		//log.info("Size of movie "+movies.size());
		
		//Optional<Movie> movie = this.movieRepository.findById(1L);
		//log.info("Movie 1"+movie);
		//log.info("Shopping cart size at "+cart.getMovies().size());
		return "home";
	}
	
}
