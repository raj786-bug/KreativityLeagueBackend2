package com.kreativity.studentregister.service;

import java.util.List;
import java.util.Optional;

import com.kreativity.studentregister.entity.SchoolData;


public interface SchoolDataService {
	SchoolData createSchoolData(SchoolData schoolData);

    List<SchoolData> getAllSchoolData();

    Optional<SchoolData> getSchoolDataById(Integer qId);

    SchoolData updateSchoolData(Integer qId, SchoolData updatedSchoolData);

    void deleteSchoolData(Integer qId);

}
