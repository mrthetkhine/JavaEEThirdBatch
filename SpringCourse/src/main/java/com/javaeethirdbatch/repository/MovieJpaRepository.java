package com.javaeethirdbatch.repository;
import org.springframework.data.repository.CrudRepository;

import com.javaeethirdbatch.model.Movie;
public interface MovieJpaRepository extends CrudRepository<Movie,Long> {

}
