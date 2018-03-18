package com.uniovi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	String name;
	String email;
	String password;
	String role;
	@Transient
	String passwordConfirm;
	
	public User(Long id, String name, String email) {
		super();
		this.id=id;
		this.name=name;
		this.email=email;
	}
	public User() {}
	
	public String toString() {
		return "Nombre: "+name+" Email: "+email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		// TODO Auto-generated method stub
		return passwordConfirm;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
