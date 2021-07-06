package com.javaeethirdbatch.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javaeethirdbatch.model.Movie;
public interface MovieJpaRepository extends CrudRepository<Movie,Long> {

	List<Movie> findByName(String name);
	List<Movie> findByNameContaining(String name);
}
