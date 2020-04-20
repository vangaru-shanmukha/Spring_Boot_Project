package com.neeraja.ShareMyOffer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@NotNull(message = "is required")
	@Column(name = "HouseNumber")
	private String houseNumber;
	
	@NotNull(message = "is required")
	@Column(name = "LandMark")
	private String landMark;
	
	@NotNull(message = "is required")
	@Column(name = "Street")
	private String street;
	
	@NotNull(message = "is required")
	@Column(name = "City")
	private String city;
	
	@NotNull(message = "is required")
	@Column(name = "State")
	private String state;
	
	@NotNull(message = "is required")
	@Column(name = "Country")
	private String country;
	
	@NotNull(message = "is required")
	@Column(name = "Pincode")
	private int pinCode;
	
	@Column(name = "Latitude")
	private float latitude;
	
	@Column(name = "Longitude")
	private float longitude;

}
