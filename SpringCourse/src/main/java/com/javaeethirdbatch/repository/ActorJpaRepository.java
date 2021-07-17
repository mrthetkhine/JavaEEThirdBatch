package com.javaeethirdbatch.repository;

import org.springframework.data.repository.CrudRepository;

import com.javaeethirdbatch.model.Actor;
import com.javaeethirdbatch.model.Movie;

public interface ActorJpaRepository extends CrudRepository<Actor,Long> {

}
