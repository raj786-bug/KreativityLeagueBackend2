package com.kreativity.studentregister.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kreativity.studentregister.entity.SchoolData;
import com.kreativity.studentregister.service.SchoolDataService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school-data")
public class SchoolDataController {
    private final SchoolDataService service;

    @Autowired
    public SchoolDataController(SchoolDataService service) {
        this.service = service;
    }

    @PostMapping
    public SchoolData createSchoolData(@RequestBody SchoolData schoolData) {
        return service.createSchoolData(schoolData);
    }

    @GetMapping
    public List<SchoolData> getAllSchoolData() {
        return service.getAllSchoolData();
    }

    @GetMapping("/{qId}")
    public Optional<SchoolData> getSchoolDataById(@PathVariable Integer qId) {
        return service.getSchoolDataById(qId);
    }

    @PutMapping("/{qId}")
    public SchoolData updateSchoolData(@PathVariable Integer qId, @RequestBody SchoolData updatedSchoolData) {
        return service.updateSchoolData(qId, updatedSchoolData);
    }

    @DeleteMapping("/{qId}")
    public void deleteSchoolData(@PathVariable Integer qId) {
        service.deleteSchoolData(qId);
    }
}

