package com.icsd.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp")
//@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpModel 
{

	@Id
	@Column(name="empno")
	public int empno;
	
	
	public String ename;
	public String job;
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	public int mgr;//to handle null values - as mgr is having null value 
	public LocalDate hiredate;
	
	public double sal;
	 
	
	public Double comm;//to handle null values - as comm is having null value
	
	
	@ManyToOne
	@JoinColumn(name ="deptno")
	public DeptModel deptModel;


}
