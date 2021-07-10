package com.javaeethirdbatch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		MovieDto movie = new MovieDto();
		//movie.setName("Titanic");
		
		List<String> genres = this.getMovieGenres();
		//taco.setIngredients(ingredients);
		model.addAttribute("movie", movie);
		//model.addAttribute("genres", genres);
		//model.addAttribute("message", "Welcome to Model");
		
		return "movie";
	}
	
	@PostMapping
	public String createOrUpdateMovie(@Valid @ModelAttribute("movie")MovieDto movie,
								BindingResult errors
							  )
	{
		if(errors.hasErrors())
		{
			log.error("Got error in create movie count "+errors.getErrorCount());
			//model.addAttribute("movie", movie);
			return "movie";
		}
		else
		{
			this.movieService.saveMovie(movie);
			//cart.addMovie(movie);
			log.info("Post controller "+movie.getName()+" Director "+movie.getDirector());
			///log.info("No of movie in shopping cart "+ cart.getMovies().size());
			return "redirect:movie/movie-list";
		}
		
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
	@GetMapping("update/{movieId}")
	public String updateMovie(@PathVariable Long movieId,Model model)
	{
		log.info("Update Movie "+movieId);
		
		MovieDto movie = this.movieService.getMovieById(movieId);
		model.addAttribute("movie", movie);
		
		return "movie";
	}
	
	@GetMapping("delete/{movieId}")
	public String deleteMovie(@PathVariable Long movieId)
	{
		log.info("Delete Movie "+movieId);
		this.movieService.deleteMovieById(movieId);
		return "redirect:/movie/movie-list";
	}
	
	@GetMapping("search")
	public String findByName(Model model, @RequestParam String name)
	{ 
		log.info("Search Movie "+name);
		
		List<MovieDto> movies = this.movieService.getMovieByName(name);
		model.addAttribute("movieList", movies);
		
		return "movie-list";
	}
	@GetMapping("search-like")
	public String findNameLikeOne(Model model, @RequestParam String name)
	{ 
		log.info("Search Movie "+name);
		
		List<MovieDto> movies = this.movieService.getMovieByNameLike("%"+name+"%");
		model.addAttribute("movieList", movies);
		
		return "movie-list";
	}
	@GetMapping("search-like-contain")
	public String findNameLike(Model model, @RequestParam String name)
	{ 
		log.info("Search Movie "+name);
		
		List<MovieDto> movies = this.movieService.getMovieByNameContain(name);
		model.addAttribute("movieList", movies);
		
		return "movie-list";
	}
	@GetMapping("search-year-greater-than")
	public String searchYearGreaterThan(Model model, @RequestParam Long year)
	{ 
		log.info("Search Movie year greater than "+ year);
		
		List<MovieDto> movies = this.movieService.getMovieByYearGreaterThan(year);
		model.addAttribute("movieList", movies);
		
		return "movie-list";
	}
	@GetMapping("/movie-list-by-page")
	public String movieListByPage(Model model,@RequestParam int pageNo,@RequestParam int pageSize)
	{
		Iterable<MovieDto> movies = this.movieService.getAllMovieByPage(pageNo,pageSize);
		//taco.setIngredients(ingredients);
		model.addAttribute("movieList", movies);
		return "movie-list";
	}
}
