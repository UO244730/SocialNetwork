package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniovi.entitites.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
}