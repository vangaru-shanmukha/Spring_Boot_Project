package com.neeraja.ShareMyOffer.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "login")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Login {
	
	@Id
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "username")
	private String userName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "password")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH })
	@JoinTable(name = "login_roles", 
	joinColumns = @JoinColumn(name = "username"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

}
