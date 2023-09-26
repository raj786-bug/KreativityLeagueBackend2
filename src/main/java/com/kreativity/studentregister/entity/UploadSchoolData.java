package com.kreativity.studentregister.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity

@Table(name="UploadSchoolStudentData")
public class UploadSchoolData {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="Student Name")
    private String studentName;
    @Column(name="Date of Birth(MM/DD/YYYY)")
    private LocalDateTime dob; // Assuming you want to store date and time
    @Column(name="Email Id")
    private String email;
    @Column(name="Parent's Name")
    private String parentName;
    @Column(name="Relationship with parents")
    private String relationship;
    @Column(name="Name of the school")
    private String schoolName;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="PinCode")
    private String pinCode;
    @Column(name="Whatsapp Number of Parent")
    private String whatsappNumber;
    @Column(name="Teacher Coordinator")
    private String teacherCoordinator;
    @Column(name="Registration Fee")
    private String registrationFee;
	public UploadSchoolData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getWhatsappNumber() {
		return whatsappNumber;
	}
	public void setWhatsappNumber(String whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}
	public String getTeacherCoordinator() {
		return teacherCoordinator;
	}
	public void setTeacherCoordinator(String teacherCoordinator) {
		this.teacherCoordinator = teacherCoordinator;
	}
	public String getRegistrationFee() {
		return registrationFee;
	}
	public void setRegistrationFee(String registrationFee) {
		this.registrationFee = registrationFee;
	}
	@Override
	public String toString() {
		return "UploadSchoolData [id=" + id + ", studentName=" + studentName + ", dob=" + dob + ", email=" + email
				+ ", parentName=" + parentName + ", relationship=" + relationship + ", schoolName=" + schoolName
				+ ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + ", whatsappNumber=" + whatsappNumber
				+ ", teacherCoordinator=" + teacherCoordinator + ", registrationFee=" + registrationFee + "]";
	}
	
}