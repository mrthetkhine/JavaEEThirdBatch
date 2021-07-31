package com.javaeethirdbatch.service.specification;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.javaeethirdbatch.controller.rest.MovieRestController;
import com.javaeethirdbatch.model.Movie;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class MovieSpecification {

	public static Specification<Movie> getAllMovieByDirectorName(String directorName) {
		log.info("getAll Movie By Director Name Spec ");
		return new Specification<Movie>() {
			
			@Override
			public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate director = criteriaBuilder.equal(root.get("director"), directorName);
				return director;
			}

		};
	}
	public static Specification<Movie> getAllMovie(String movieName,String directorName,Long year) {
		log.info("getAll Movie By movie name, director name,year ");
		return new Specification<Movie>() {
			
			@Override
			public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				ArrayList<Predicate> predicates = new ArrayList<Predicate>();
				if(directorName!= null)
				{
					Predicate director = criteriaBuilder.equal(root.get("director"), directorName);
					predicates.add(director);
				}
				if(movieName != null)
				{
					Predicate nameCondition = criteriaBuilder.equal(root.get("name"), movieName);
					predicates.add(nameCondition);
				}
				if(year != null)
				{
					Predicate yearCondition = criteriaBuilder.equal(root.get("year"), year);
					predicates.add(yearCondition);
				}
				Predicate and = criteriaBuilder.and(predicates.toArray(new Predicate[] {}));
				query.where(and);
				return and;
			}

		};
	}
}
