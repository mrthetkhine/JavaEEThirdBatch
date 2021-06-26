package com.javaeethirdbatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaeethirdbatch.model.Movie;
import com.javaeethirdbatch.model.ShoppingCart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/movie")
public class MovieController {

	ShoppingCart cart = new ShoppingCart();
	
	@GetMapping
	public String newMovie(Model model)
	{
		log.info("NewMovie controller");
		Movie movie = new Movie();
		movie.setName("Titanic");
		
		//taco.setIngredients(ingredients);
		model.addAttribute("movie", movie);
		model.addAttribute("message", "Welcome to Model");
		
		return "movie";
	}
	
	@PostMapping
	public String createMovie(Movie movie)
	{
		this.cart.addMovie(movie);
		log.info("Post controller "+movie.getName()+" Director "+movie.getDirector());
		
		log.info("No of movie in shopping cart "+ cart.getMovies().size());
		return "movie";
		//return "redirect:/";
	}
	@GetMapping("/new")
	public String emptyMovie(Model model)
	{
		Movie movie = new Movie();
		
		
		//taco.setIngredients(ingredients);
		model.addAttribute("movie", movie);
		return "movie";
	}
	
}
