/*package com.kreativity.studentregister.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="schoolInfo")
public class SchoolInfo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stdinfoid")
    private Long stdinfoid;
	@Column(name="studentName")
    private String studentName;
	@Column(name="dob")
    private LocalDate dob;
	@Column(name="email")
    private String email;
	@Column(name="schoolName")
    private String schoolName;
	@Column(name="whatsappNumber")
    private String whatsappNumber;
	public SchoolInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getStdinfoid() {
		return stdinfoid;
	}
	public void setStdinfoid(Long stdinfoid) {
		this.stdinfoid = stdinfoid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getWhatsappNumber() {
		return whatsappNumber;
	}
	public void setWhatsappNumber(String whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}
	@Override
	public String toString() {
		return "SchoolInfo [stdinfoid=" + stdinfoid + ", studentName=" + studentName + ", dob=" + dob + ", email="
				+ email + ", schoolName=" + schoolName + ", whatsappNumber=" + whatsappNumber + "]";
	}
	
    
	
	
	
	
	

}
*/
