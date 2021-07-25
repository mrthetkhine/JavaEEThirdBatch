package com.javaeethirdbatch.repository;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javaeethirdbatch.dto.MovieIdActorCount;
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
	
	//JPQL>HQL
	//@Query(value="SELECT movie FROM Movie movie WHERE movie.name IS NOT NULL")
	@Query(value="SELECT movie FROM Movie movie WHERE movie.name IS NOT NULL "
			+ "AND movie.genre IN ('Action','Horror')")
	List<Movie> getAllMovieByJPQL();
	
	@Query(value="SELECT movie FROM Movie movie where director=?1")
	List<Movie> getMovieByDirector(String director);
	
	//Explicit
	/*
	@Query(value="SELECT distinct m FROM Movie m JOIN m.actors act"
				+" WHERE act.fullName=:actorName")*/
	@Query(value="SELECT distinct m FROM Movie m JOIN m.actors act "
			+ "WHERE EXISTS("
			+ "SELECT a FROM Actor a WHERE a.fullName=:actorName"
			+ ")")
	
	List<Movie> getMovieWithActor(@Param("actorName") String actorName);
	
	
	//Implicit Join
	@Query(value="SELECT distinct m FROM Movie m "
			+" WHERE m.movieDetail.description like %:text%")
	List<Movie> getMovieThatContainDescription(@Param("text") String text);
	
	
	@Query(value="SELECT m.id as movieId,count(act) as actorCount FROM Movie m JOIN m.actors act "
			+ "group by m")
	List<Object[]> getMovieWithActorCount();
	
	//@Query(value="SELECT m.id as movieId,count(act) as actorCount FROM Movie m JOIN m.actors act group by m")
	@Query(value="SELECT m.id as movieId,size(m.actors) as actorCount FROM Movie m JOIN m.actors act")
	List<MovieIdActorCount> getMovieWithActorCountWithDtoProjection();
	
	@Modifying
	@Query(value="DELETE FROM Movie m WHERE m.id =:id")
	void deleteMovieByIdJPQL(@Param("id")Long id);
	
	@Modifying
	@Query(value="UPDATE Movie m SET m.name=:name WHERE m.id =:id")
	void updateMovieNameById(@Param("id")Long id,@Param("name")String name);
}
