package com.example.project.assignment.config;

import java.util.List;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.assignment.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser implements HttpSessionBindingListener {

	private String userName;
	
	private List<Role> roles;
	
	@Autowired
	private ActiveUser activeUser;
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		
		String user = activeUser.getUserName();
		LoggedUser loggedUser = (LoggedUser) event.getValue();
		if(user == null) {
			activeUser.setUserName(loggedUser.getUserName());
			activeUser.setRoles(roles);
		}
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		String user = activeUser.getUserName();
		LoggedUser loggedUser = (LoggedUser) event.getValue();
		if(user != null && user.equals(loggedUser.getUserName())) {
			activeUser.setUserName(null);
			activeUser.setRoles(null);
		}
	}
}
