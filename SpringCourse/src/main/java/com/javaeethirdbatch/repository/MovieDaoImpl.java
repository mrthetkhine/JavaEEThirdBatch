package com.javaeethirdbatch.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaeethirdbatch.model.Movie;

@Repository
public class MovieDaoImpl extends AbstractJpaDAO<Movie> implements MovieDAO{

	public MovieDaoImpl(){
	      setClazz(Movie.class );
	}
	@Override
	public List<Movie> findAll() {
		return super.findAll();
	}

}
