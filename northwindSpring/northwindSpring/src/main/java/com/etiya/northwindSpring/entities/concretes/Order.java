package com.etiya.northwindSpring.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="order_id")
	private int id;
	
	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="ship_name")
	private String shipName;
	
	@Column(name="ship_city")
	private String shipCity;
	
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

}
