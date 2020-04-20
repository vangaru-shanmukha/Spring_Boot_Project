package com.neeraja.ShareMyOffer.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@NotNull(message = "is required")
	@Column(name = "FirstName")
	private String firstName;
	
	@NotNull(message = "is required")
	@Column(name = "LastName")
	private String lastName;
	
	@NotNull(message = "is required")
	@Column(name = "DateOfBirth")
	private String dateOfBirth;
	
	@NotNull(message = "is required")
	@Column(name = "MobileNumber")
	private String mobileNumber;
	
	@NotNull(message = "is required")
	@Column(name = "EmailId")
	private String email;
	
	@NotNull(message = "is required")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AddressId")
	private Address address;
	
	@NotNull(message = "is required")
	@Column(name = "Rating")
	private int rating;
	
}
