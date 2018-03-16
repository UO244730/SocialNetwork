package com.uniovi.entitites;

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
		return getPasswordConfirm();
	}
}
