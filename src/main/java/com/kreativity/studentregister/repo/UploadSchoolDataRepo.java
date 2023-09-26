package com.kreativity.studentregister.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kreativity.studentregister.entity.Student;
import com.kreativity.studentregister.entity.UploadSchoolData;

public interface UploadSchoolDataRepo extends JpaRepository<UploadSchoolData,Long>{
	Optional<UploadSchoolData> findByStudentNameAndEmailAndWhatsappNumber(String studentName, String email, String whatsappNumber);
}
