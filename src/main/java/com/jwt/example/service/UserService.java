package com.jwt.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.example.model.User;

@Service
public class UserService {

	private List<User> store = new ArrayList<User>();

	public UserService() {
		store.add(new User(UUID.randomUUID().toString(),"admin", "admin@gmail.com", "1234567890"));
		store.add(new User(UUID.randomUUID().toString(),"user", "user@gmail.com", "1234567890"));
	}

	public List<User> getUsers() {
		return store;
	}
}
