package com.javaeethirdbatch.service.specification;

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
}
