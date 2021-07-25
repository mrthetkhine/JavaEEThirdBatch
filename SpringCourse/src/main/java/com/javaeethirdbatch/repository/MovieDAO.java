package com.javaeethirdbatch.repository;

import java.util.List;

import com.javaeethirdbatch.model.Movie;

public interface MovieDAO {
	List<Movie> findAll();
}
