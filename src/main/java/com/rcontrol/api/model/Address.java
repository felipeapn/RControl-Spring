package com.rcontrol.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
	@NotEmpty
    private String name;
	
	@NotEmpty
    private int number;
	
	@NotEmpty
    private String street;
	
	@NotEmpty
    private String city;
	
	@NotEmpty
    private String state;
	
	@NotEmpty
    private String zipCode;
	
	@NotEmpty
	@Column(name = "id_user")
	private Long idUser;

}
