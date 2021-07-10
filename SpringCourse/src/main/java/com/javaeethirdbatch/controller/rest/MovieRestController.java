package com.javaeethirdbatch.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaeethirdbatch.dto.MovieDto;
import com.javaeethirdbatch.service.MovieService;

@RequestMapping("/api/movies")
@RestController
public class MovieRestController {
	@Autowired
	MovieService movieService;

	@GetMapping
	List<MovieDto> all() {
		return movieService.getAllMovie();
	}
}
