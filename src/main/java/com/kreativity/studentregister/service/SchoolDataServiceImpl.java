package com.kreativity.studentregister.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kreativity.studentregister.entity.SchoolData;
import com.kreativity.studentregister.repo.SchoolDataRepo;

@Service
public class SchoolDataServiceImpl implements SchoolDataService{
	
	@Autowired
    private SchoolDataRepo schoolDataRepo;


	@Override
	public SchoolData createSchoolData(SchoolData schoolData) {
		// TODO Auto-generated method stub
		return schoolDataRepo.save(schoolData);
	}

	@Override
	public List<SchoolData> getAllSchoolData() {
		// TODO Auto-generated method stub
		return schoolDataRepo.findAll();
	}

	@Override
	public Optional<SchoolData> getSchoolDataById(Integer qId) {
		// TODO Auto-generated method stub
		return schoolDataRepo.findById(qId);
	}

	@Override
	public SchoolData updateSchoolData(Integer qId, SchoolData updatedSchoolData) {
		// TODO Auto-generated method stub
		if (schoolDataRepo.existsById(qId)) {
            updatedSchoolData.setqId(qId);
            return schoolDataRepo.save(updatedSchoolData);
        } else {
            throw new IllegalArgumentException("School Data with ID " + qId + " not found.");
        }
	}

	@Override
	public void deleteSchoolData(Integer qId) {
		// TODO Auto-generated method stub
		if (schoolDataRepo.existsById(qId)) {
			schoolDataRepo.deleteById(qId);
        } else {
            throw new IllegalArgumentException("School Data with ID " + qId + " not found.");
        }
		
	}
	

}
