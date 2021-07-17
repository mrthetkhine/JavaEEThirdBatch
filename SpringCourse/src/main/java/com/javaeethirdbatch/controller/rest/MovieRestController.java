package com.javaeethirdbatch.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaeethirdbatch.dto.MovieDto;
import com.javaeethirdbatch.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/movies")
@RestController
@Tag(name = "movie", description = "the Movie API")
public class MovieRestController {
	
	@Autowired
	MovieService movieService;

	@Operation(summary = "Find all movie", description = "Get all movie", tags = { "movie" })
	@GetMapping
	List<MovieDto> all() {
		return movieService.getAllMovie();
	}
	
	@Operation(summary = "Get a movie", description = "Get movie by Id", tags = { "movie" })
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful fetch a movie"),
	        @ApiResponse(responseCode = "404", description = "movie not found")
	        })
	@GetMapping("/{id}")
	ResponseEntity<MovieDto> getMovie(
			@Parameter(description="Id of the movie.", 
            required=true)
			@PathVariable Long id) {
		MovieDto movie = this.movieService.getMovieById(id);
		if(movie.getId() != null)
		{
			return ResponseEntity.ok().body(movie);
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(movie);
		}
		
	}
	
	private ResponseEntity<Object> saveOrUpateMovie(MovieDto movie, BindingResult result) {
		if(!result.hasErrors())
		{
			MovieDto resultMovie = this.movieService.saveMovie(movie);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(resultMovie);
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(result.getAllErrors());
		}
	}
	@Operation(summary = "Save a Movie", description = "Save", tags = { "movie" })
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "successful create a movie",
	        		content = @Content(schema = @Schema(implementation = MovieDto.class))),
	        @ApiResponse(responseCode = "400", description = "Validation error")
	        })
	@PostMapping
	ResponseEntity<Object> saveMovie(@Valid @RequestBody MovieDto movie,
			BindingResult result) {
		return saveOrUpateMovie(movie, result);
	}

	
	@PutMapping("/{id}")
	ResponseEntity<Object> updateMovie(@PathVariable Long id,@Valid @RequestBody MovieDto movie,
			BindingResult result) {
		return saveOrUpateMovie(movie, result);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Object> deleteMovie(@PathVariable Long id) {
		MovieDto movie = this.movieService.getMovieById(id);
		if(movie.getId() != null)
		{
			this.movieService.deleteMovieById(movie.getId());
			return ResponseEntity.ok().body(movie);
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(movie);
		}
	}
}