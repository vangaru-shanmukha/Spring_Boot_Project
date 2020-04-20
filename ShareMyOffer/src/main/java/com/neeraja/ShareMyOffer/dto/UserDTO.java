package com.neeraja.ShareMyOffer.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String dateOfBirth;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String mobileNumber;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String email;
	
	@NotNull(message = "is required")
	private int rating;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String houseNumber;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String landMark;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String street;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String city;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String state;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String country;
	
	@NotNull(message = "is required")
	private int pincode;

}
