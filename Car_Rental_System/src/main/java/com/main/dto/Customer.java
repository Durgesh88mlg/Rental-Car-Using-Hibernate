package com.main.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "c_id")
	@SequenceGenerator(name ="c_id",  initialValue = 1000, allocationSize = 1)
	private int cid;
	private String name;
	private String emailId;
	private LocalDate registerDate;
	private LocalDate returnDate;
	
	@OneToOne
	private Car car;
	
}
