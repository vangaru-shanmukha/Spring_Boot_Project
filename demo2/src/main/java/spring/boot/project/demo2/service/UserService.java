package spring.boot.project.demo2.service;

import java.util.List;

import spring.boot.project.demo2.entity.User;

public interface UserService {

	public List<User> findAll();

	public User findById(String userName);

	public void save(User theUser);

	public void deleteById(String userName);
}
