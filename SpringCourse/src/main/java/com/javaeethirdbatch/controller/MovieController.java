package com.javaeethirdbatch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.javaeethirdbatch.dto.MovieDto;
import com.javaeethirdbatch.model.Movie;
import com.javaeethirdbatch.model.ShoppingCart;
import com.javaeethirdbatch.repository.MovieJpaRepository;
import com.javaeethirdbatch.repository.MovieRepository;
import com.javaeethirdbatch.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("cart")
@RequestMapping("/movie")
public class MovieController {
	
	/*
	@Autowired
	//MovieRepository movieRepository;
	MovieJpaRepository movieRepository;
	*/
	@Autowired
	MovieService movieService;

	//Create session attribute
	@ModelAttribute("cart")
	public ShoppingCart getCart() {
		log.info("Create new Shopping Cart");
		return new ShoppingCart();
	}
	/*
	 * Just for example,
	 * In real world scenarios, we need to use service->dao
	 * */
	List<String> getMovieGenres()
	{
		List<String> genres = new ArrayList<String>();
		
		genres.add("Action");
		genres.add("Romance");
		genres.add("Horror");
		return genres;
	}
	@GetMapping
	public String newMovie(Model model)
	{
		log.info("NewMovie controller");
		Movie movie = new Movie();
		//movie.setName("Titanic");
		
		List<String> genres = this.getMovieGenres();
		//taco.setIngredients(ingredients);
		model.addAttribute("movie", movie);
		//model.addAttribute("genres", genres);
		model.addAttribute("message", "Welcome to Model");
		
		return "movie";
	}
	
	@PostMapping
	public String createMovie(@Valid MovieDto movie,Errors errors,
							  @SessionAttribute("cart")ShoppingCart cart)
	{
		if(errors.hasErrors())
		{
			log.error("Got error in create movie");
			return "movie";
		}
		else
		{
			this.movieService.saveMovie(movie);
			//cart.addMovie(movie);
			log.info("Post controller "+movie.getName()+" Director "+movie.getDirector());
			log.info("No of movie in shopping cart "+ cart.getMovies().size());
			return "redirect:movie/movie-list";
		}
		
		//return "redirect:/";
	}
	@GetMapping("/new")
	public String emptyMovie(Model model)
	{
		MovieDto movie = new MovieDto();
		
		
		//taco.setIngredients(ingredients);
		model.addAttribute("movie", movie);
		return "movie";
	}
	
	@GetMapping("/movie-list")
	public String movieList(Model model)
	{
		Iterable<MovieDto> movies = this.movieService.getAllMovie();
		//taco.setIngredients(ingredients);
		model.addAttribute("movieList", movies);
		return "movie-list";
	}
	
}
