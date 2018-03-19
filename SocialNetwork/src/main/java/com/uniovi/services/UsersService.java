package com.uniovi.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uniovi.entities.User;
import com.uniovi.repositories.UsersRepository;

@Service
public class UsersService {
	private List<User> usersList = new LinkedList<User>();
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostConstruct
	public void init() {
		User user1 = new User(1L, "Iván Suárez", "UO244730");
		user1.setPassword("123456");
		usersList.add(user1);
		User user2 = new User(2L,"Jaime","UO437824");
		user2.setPassword("123456");
		usersList.add(user2);
	}
	
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		usersRepository.findAll().forEach(users::add);
		return users;
	}
	
	public User getUser(long id) {
		return usersList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
		//return usersRepository.findByEmail(email);
	}
	public void addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usersRepository.save(user);
	}
	
	public User getUserByEmail(String email) {
		//return usersList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
		return usersRepository.findByEmail(email);
	}
	
	
	public List<User> searchUsersByEmailAndName (String searchText){
		List<User> users = new ArrayList<User>();
		users = usersRepository.searchByEmailandName(searchText);
		return users;
		}
}
