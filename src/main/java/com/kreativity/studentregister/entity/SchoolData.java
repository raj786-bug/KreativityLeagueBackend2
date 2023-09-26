package com.kreativity.studentregister.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SchoolData")
public class SchoolData {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qId;
	@Column(name="schoolName")
    private String schoolName;
	@Column(name="city")
    private String city;
	@Column(name="enquiredPersonName")
    private String enquiredPersonName;
	@Column(name="designation")
	private String designation;
	@Column(name="enquiredPersonMobile")
	private Long enquiredPersonMobile;
	public SchoolData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getqId() {
		return qId;
	}
	public void setqId(Integer qId) {
		this.qId = qId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEnquiredPersonName() {
		return enquiredPersonName;
	}
	public void setEnquiredPersonName(String enquiredPersonName) {
		this.enquiredPersonName = enquiredPersonName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Long getEnquiredPersonMobile() {
		return enquiredPersonMobile;
	}
	public void setEnquiredPersonMobile(Long enquiredPersonMobile) {
		this.enquiredPersonMobile = enquiredPersonMobile;
	}
	@Override
	public String toString() {
		return "SchoolData [qId=" + qId + ", schoolName=" + schoolName + ", city=" + city + ", enquiredPersonName="
				+ enquiredPersonName + ", designation=" + designation + ", enquiredPersonMobile=" + enquiredPersonMobile
				+ "]";
	}
	

}
