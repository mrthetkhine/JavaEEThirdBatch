package com.javaeethirdbatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaeethirdbatch.model.Movie;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@GetMapping
	public String newMovie(Model model)
	{
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
		System.out.println("Post controller "+movie.getName()+" Director "+movie.getDirector());
		//return "movie";
		return "redirect:/";
	}
	
}
