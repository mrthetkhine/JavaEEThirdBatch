package com.javaeethirdbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaeethirdbatch.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
	User findByName(String name);
}
