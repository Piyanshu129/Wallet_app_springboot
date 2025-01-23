package com.icsd.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="dept")
public class DeptModel {

	@Id
	private int deptno;
	
	private String deptName;
	
	private String loc;
	
	
}

