package com.javaeethirdbatch.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.javaeethirdbatch.model.Movie;
import com.javaeethirdbatch.model.ShoppingCart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("cart")
@RequestMapping("/movie")
public class MovieController {

	//Create session attribute
	@ModelAttribute("cart")
	public ShoppingCart getCart() {
		log.info("Create new Shopping Cart");
		return new ShoppingCart();
	}
	
	@GetMapping
	public String newMovie(Model model)
	{
		log.info("NewMovie controller");
		Movie movie = new Movie();
		//movie.setName("Titanic");
		
		//taco.setIngredients(ingredients);
		model.addAttribute("movie", movie);
		model.addAttribute("message", "Welcome to Model");
		
		return "movie";
	}
	
	@PostMapping
	public String createMovie(@Valid Movie movie,Errors errors,
							  @SessionAttribute("cart")ShoppingCart cart)
	{
		if(errors.hasErrors())
		{
			log.error("Got error in create movie");
			return "movie";
		}
		else
		{
			cart.addMovie(movie);
			log.info("Post controller "+movie.getName()+" Director "+movie.getDirector());
			log.info("No of movie in shopping cart "+ cart.getMovies().size());
			return "movie-list";
		}
		
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
