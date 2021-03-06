package com.etiya.northwindSpring.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","orders"})
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="employee_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="title")
	private String title;
	
	@OneToMany(mappedBy = "employee")
	private List<Order> orders;
	

}
