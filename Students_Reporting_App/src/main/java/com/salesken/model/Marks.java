package com.salesken.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Marks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private Integer sem1_sci;
	
	private Integer sem1_math;
	
	private Integer sem1_eng;
	
	
    private Integer sem2_sci;
	
	private Integer sem2_math;
	
	private Integer sem2_eng;
	
	
}
