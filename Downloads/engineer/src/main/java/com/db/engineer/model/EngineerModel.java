package com.db.engineer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="engg_tb")
public class EngineerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long engId;
	@Column(name = "eng_name")
	private String engName;
	@Column(name = "eng_age")
	private String engAge;
	
	
	public Long getEngId() {
		return engId;
	}
	public void setEngId(Long engId) {
		this.engId = engId;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getEngAge() {
		return engAge;
	}
	public void setEngAge(String engAge) {
		this.engAge = engAge;
	}
	
	

}
