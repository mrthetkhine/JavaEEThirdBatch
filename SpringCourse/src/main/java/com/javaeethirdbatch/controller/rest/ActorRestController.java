package com.javaeethirdbatch.controller.rest;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

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
import com.javaeethirdbatch.model.Actor;
import com.javaeethirdbatch.repository.ActorJpaRepository;
import com.javaeethirdbatch.service.MovieServiceImpl;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	@PostMapping
	ResponseEntity<Object> saveActor(@Valid @RequestBody Actor actor,
									BindingResult result)
	{
		if(!result.hasErrors())
		{
			Actor newEntity = this.actorRepo.save(actor);
			log.info("new Entity ",newEntity);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(newEntity);
			
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(result.getAllErrors());
		}
		
	}
	@PutMapping("/{id}")
	ResponseEntity<Object> updateActor(@PathVariable Long id,@Valid @RequestBody Actor actor,
			BindingResult result) {
		if(!result.hasErrors())
		{
			Actor newEntity = this.actorRepo.save(actor);
			log.info("new Entity ",newEntity);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(newEntity);
			
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(result.getAllErrors());
		}
	}
	@DeleteMapping("/{id}")
	ResponseEntity<Object> deleteActor(@PathVariable Long id) {
		
		Optional<Actor> result = this.actorRepo.findById(id);
		if(result.isPresent())
		{
			this.actorRepo.deleteById(id);
			return ResponseEntity.ok().body(result.get());
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(result.get());
		}
	}
}
