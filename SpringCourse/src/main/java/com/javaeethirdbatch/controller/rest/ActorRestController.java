package com.javaeethirdbatch.controller.rest;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaeethirdbatch.dto.MovieDto;
import com.javaeethirdbatch.model.Actor;
import com.javaeethirdbatch.repository.ActorJpaRepository;

import io.swagger.v3.oas.annotations.Parameter;

@RequestMapping("/api/actors")
@RestController
public class ActorRestController {

	@Autowired
	ActorJpaRepository actorRepo;
	
	@GetMapping
	Iterable<Actor> all() {
		return actorRepo.findAll();
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Actor> getActor(
			@Parameter(description="Id of the actor.", 
            required=true)
			@PathVariable Long id) throws Exception {
		Optional<Actor> result = this.actorRepo.findById(id);
		
		if(result.isPresent())
		{
			return ResponseEntity.ok().body(result.get());
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(null);
		}
		
		
		
	}
}
