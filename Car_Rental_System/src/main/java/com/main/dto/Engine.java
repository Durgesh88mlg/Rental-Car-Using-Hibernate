package com.main.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Engine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "e_id")
	@SequenceGenerator(name = "e_id", initialValue = 100, allocationSize = 1)
	private int engineId;
	private String type;
	private double cc;
	
}
