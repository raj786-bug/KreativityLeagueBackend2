package com.kreativity.studentregister.controller;
import com.kreativity.studentregister.entity.UploadResponse;
import com.kreativity.studentregister.entity.UploadSchoolData;
import com.kreativity.studentregister.service.ExcelUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExcelUploadController {
    @Autowired
    private ExcelUploadService excelUploadService;

    @PostMapping("/excel")
    @CrossOrigin
    public ResponseEntity<UploadResponse> uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            excelUploadService.uploadExcelData(file);
            return ResponseEntity.ok(new UploadResponse("success", "File uploaded successfully."));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new UploadResponse("error", "Error occurred while uploading the file."));
        }
    }
    
    @GetMapping("/showexcel")
    @CrossOrigin
    public ResponseEntity<List<UploadSchoolData>> getExcelData() {
        try {
            // Call a service method to retrieve data from the Excel file
            List<UploadSchoolData> excelData = excelUploadService.getExcelData();

            // Check if data is retrieved successfully
            if (excelData != null && !excelData.isEmpty()) {
                return ResponseEntity.ok(excelData);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(null); // You can customize this response based on your requirements
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // You can customize this response based on your requirements
        }
    }
    @PostMapping("/schoolstudentlogin")
    @CrossOrigin
    public ResponseEntity<String> login(
            @RequestParam("studentName") String studentName,
            @RequestParam("email") String email,
            @RequestParam("whatsappNumber") String whatsappNumber) {
        try {
            // Check if the login is successful based on the provided credentials
            boolean loginSuccessful = excelUploadService.login(studentName, email, whatsappNumber);

            if (loginSuccessful) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Login failed. Invalid credentials.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during login.");
        }
    }
}

