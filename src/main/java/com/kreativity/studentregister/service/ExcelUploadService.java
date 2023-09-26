package com.kreativity.studentregister.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Optional;
import com.kreativity.studentregister.entity.UploadSchoolData;
import com.kreativity.studentregister.repo.UploadSchoolDataRepo;

import jakarta.transaction.Transactional;

@Service
public class ExcelUploadService {
	@Autowired
    private UploadSchoolDataRepo uploadRepository;
	
	@Transactional()
    public boolean login(String studentName, String email, String whatsappNumber) {
        // Query the database for a student with matching details
        java.util.Optional<UploadSchoolData> studentOptional = uploadRepository.findByStudentNameAndEmailAndWhatsappNumber(studentName, email, whatsappNumber);

        // If a matching student is found, allow login; otherwise, deny access
        return studentOptional.isPresent();
    }
	
	public void uploadExcelData(MultipartFile file) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                // Skip the header row
                continue;
            }

            UploadSchoolData upload = new UploadSchoolData();
            upload.setStudentName(row.getCell(0).getStringCellValue());
            upload.setDob(row.getCell(1).getLocalDateTimeCellValue());
            upload.setEmail(row.getCell(2).getStringCellValue());
            upload.setParentName(row.getCell(3).getStringCellValue());
            upload.setRelationship(row.getCell(4).getStringCellValue());
            upload.setSchoolName(row.getCell(5).getStringCellValue());
            upload.setCity(row.getCell(6).getStringCellValue());
            upload.setState(row.getCell(7).getStringCellValue());
            //upload.setPinCode(row.getCell(8).getStringCellValue());           
            upload.setTeacherCoordinator(row.getCell(10).getStringCellValue());
            double whatsappNumberNumeric = row.getCell(9).getNumericCellValue();
            double registrationFeeNumeric = row.getCell(11).getNumericCellValue();
            double pinCodeFreeNumeric = row.getCell(8).getNumericCellValue();

            // Convert them to strings
            String whatsappNumber = String.valueOf((long) whatsappNumberNumeric);
            String registrationFee = String.valueOf((long) registrationFeeNumeric);
            String pinCodeFree = String.valueOf((long) pinCodeFreeNumeric);
            upload.setWhatsappNumber(pinCodeFree);
            upload.setWhatsappNumber(whatsappNumber);
            upload.setRegistrationFee(registrationFee);


            

            uploadRepository.save(upload);
        }

        workbook.close();
    }
        catch (Exception e) {
            // Handle exceptions and log them
            e.printStackTrace();
            // You can also consider rolling back the transaction if necessary
        }
	}
	public List<UploadSchoolData> getExcelData() {
        try {
            // Call the repository method to fetch data from the database
            List<UploadSchoolData> excelData = uploadRepository.findAll();

            return excelData;
        } catch (Exception e) {
            // Handle exceptions and log them
            e.printStackTrace();
            // You can also throw a custom exception or return an empty list based on your requirements
            return null;
        }
    }
}
