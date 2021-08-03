package com.javaeethirdbatch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/login")
	String login(Model model,@RequestParam(value = "error",required = false) Boolean error){
		System.out.println("Login get");
		model.addAttribute("error", error);
		return "login";
	}
	@PostMapping("/login")
	String loginPost(Model model){
		System.out.println("Login post");

		
		return "login";
	}
	@GetMapping("/userAccountInfo")
	String page(Model model){
		
		
		return "userAccountInfo";
	}
	@GetMapping("/admin")
	String admin(Model model){
		
		System.out.println("Admin route");
		return "admin";
	}
	@GetMapping("/logoutSuccessful")
	String logoutSuccess(Model model)
	{
		System.out.println("You have been logout");
		return "logoutSuccessful";
	}
}
