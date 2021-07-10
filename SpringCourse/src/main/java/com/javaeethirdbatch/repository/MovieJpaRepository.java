package com.javaeethirdbatch.repository;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.javaeethirdbatch.model.Movie;
public interface MovieJpaRepository extends CrudRepository<Movie,Long> {

	List<Movie> findAll(Pageable pagable);
	List<Movie> findByName(String name);
	List<Movie> findByNameLike(String name);
	List<Movie> findByNameContaining(String name);
	List<Movie> findByYearGreaterThan(Long year);
	
	//SQL
	@Query(value="SELECT * FROM movie ORDER BY year DESC",
			nativeQuery=true)
	List<Movie> getAllMovie();
	
	//JPQL
	@Query(value="SELECT m FROM Movie m")
	List<Movie> getAllMovieByJPQL();
}
