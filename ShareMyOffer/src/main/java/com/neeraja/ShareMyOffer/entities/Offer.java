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
@Table(name = "Offer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@NotNull(message = "is required")
	@Column(name = "Name")
	private String name;
	
	@NotNull(message = "is required")
	@Column(name = "Description")
	private String description;
	
	@NotNull(message = "is required")
	@Column(name = "Date")
	private String date;
	
	@NotNull(message = "is required")
	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "AddressId")
	private Address address;
	
	@NotNull(message = "is required")
	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "UserId")
	private User user;
	
	@NotNull(message = "is required")
	@Column(name = "Status")
	private String status;
}
