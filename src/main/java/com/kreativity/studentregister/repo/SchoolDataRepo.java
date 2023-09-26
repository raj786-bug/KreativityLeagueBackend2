package com.kreativity.studentregister.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kreativity.studentregister.entity.SchoolData;

public interface SchoolDataRepo extends JpaRepository<SchoolData,Integer>{

}
