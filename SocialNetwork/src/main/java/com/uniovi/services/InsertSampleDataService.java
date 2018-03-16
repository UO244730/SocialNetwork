package com.uniovi.services;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import com.uniovi.entitites.User;

@Service
public class InsertSampleDataService {
	@Autowired
	private UsersService usersService;

	@PostConstruct
	public void init() {
		User user1 = new User(1L,"Iván","UO244730@uniovi.es");
		user1.setPassword("123456");
		User user2 = new User(2L,"Jaime","UO374684@uniovi.es");
		user2.setPassword("123456");
		
		usersService.addUser(user1);
		usersService.addUser(user2);
	}
}
