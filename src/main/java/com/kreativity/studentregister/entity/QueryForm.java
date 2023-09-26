package com.kreativity.studentregister.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="QueryForm")
public class QueryForm {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qId;
	@Column(name="schoolName")
    private String schoolName;
	@Column(name="city")
    private String city;
	@Column(name="principalName")
    private String principalName;
	@Column(name="principalEmail")
    private String principalEmail;
	@Column(name="principalWhatsappNumber")
    private Long principalWhatsappNumber;
	@Column(name="enquiredPersonName")
    private String enquiredPersonName;
	@Column(name="enquiredPersonMobile")
    private Long enquiredPersonMobile;
	public QueryForm() {
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
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public String getPrincipalEmail() {
		return principalEmail;
	}
	public void setPrincipalEmail(String principalEmail) {
		this.principalEmail = principalEmail;
	}
	public Long getPrincipalWhatsappNumber() {
		return principalWhatsappNumber;
	}
	public void setPrincipalWhatsappNumber(Long principalWhatsappNumber) {
		this.principalWhatsappNumber = principalWhatsappNumber;
	}
	public String getEnquiredPersonName() {
		return enquiredPersonName;
	}
	public void setEnquiredPersonName(String enquiredPersonName) {
		this.enquiredPersonName = enquiredPersonName;
	}
	public Long getEnquiredPersonMobile() {
		return enquiredPersonMobile;
	}
	public void setEnquiredPersonMobile(Long enquiredPersonMobile) {
		this.enquiredPersonMobile = enquiredPersonMobile;
	}
	@Override
	public String toString() {
		return "QueryForm [qId=" + qId + ", schoolName=" + schoolName + ", city=" + city + ", principalName="
				+ principalName + ", principalEmail=" + principalEmail + ", principalWhatsappNumber="
				+ principalWhatsappNumber + ", enquiredPersonName=" + enquiredPersonName + ", enquiredPersonMobile="
				+ enquiredPersonMobile + "]";
	}
	
	
    

}
