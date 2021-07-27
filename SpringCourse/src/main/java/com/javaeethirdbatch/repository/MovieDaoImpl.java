package com.javaeethirdbatch.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.javaeethirdbatch.controller.rest.MovieRestController;
import com.javaeethirdbatch.model.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MovieDaoImpl extends AbstractJpaDAO<Movie> implements MovieDAO{

	
	@Override
	public List<Movie> findAll() {
		return super.findAll();
	}

	ArrayList<Predicate> getListOfPredicate(HashMap<String,Object> fields,
							CriteriaBuilder cb,Root<Movie>movie)
	{
		ArrayList<Predicate> predicates = new ArrayList<Predicate>();
		
		for(String key : fields.keySet())
		{
			Object value = fields.get(key);
			if(value !=null)
			{
				Predicate condition = cb.equal(movie.get(key), value);
				predicates.add(condition);
			}
		}
		return predicates;
	}
	@Override
	public List<Movie> searchMovie(String movieName, String directorName, Long year)
	{
		log.info("Search Movie DAO Impl");
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = cb.createQuery(Movie.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		
		HashMap<String,Object> fields = new HashMap<String,Object>();
		
		fields.put("name", movieName);
		fields.put("director", directorName);
		fields.put("year", year);
		
		ArrayList<Predicate> predicates = new ArrayList<Predicate>();
		
		/*
		if(movieName != null)
		{
			Predicate nameCondition = cb.equal(movie.get("name"), movieName);
			predicates.add(nameCondition);
		}
			
		if(directorName !=null)
		{
			Predicate directorCondition = cb.equal(movie.get("director"), directorName);
			predicates.add(directorCondition);
		}
		if( year != null)
		{
			Predicate yearCondition = cb.equal(movie.get("year"), year);
			predicates.add(yearCondition);
		}
		*/
		predicates = this.getListOfPredicate(fields, cb, movie);
		if(predicates.size() >0)
		{
			/*
			Predicate or = cb.or(predicates.toArray(new Predicate[] {}));
			criteriaQuery.where(or);
			*/
			Predicate and = cb.and(predicates.toArray(new Predicate[] {}));
			criteriaQuery.where(and);
			
			//Predicate not = cb.not(or);
			//Predicate and = cb.and(not)
		}	
		
		return this.entityManager.createQuery(criteriaQuery).getResultList();
		
	}
	
	@Override
	public List<Movie> searchMovieByYear(Long year)
	{
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = cb.createQuery(Movie.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		criteriaQuery.where(cb.equal(movie.get("year"), cb.parameter(Long.class,"year")));
		
		Query query =  (Query) this.entityManager.createQuery(criteriaQuery);
		query.setParameter("year", year);
		
		return query.getResultList();
		
	}
	@Override
	public List<Movie> searchByActor(String actor)
	{
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = cb.createQuery(Movie.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		Join actors = movie.join("actors"); 
		criteriaQuery.distinct(true).where(cb.equal(actors.get("fullName"), actor));
		Query query =  (Query) this.entityManager.createQuery(criteriaQuery);
	
		return query.getResultList();
	}
	
	
}
