/*package com.kreativity.studentregister.service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kreativity.studentregister.entity.SchoolInfo;
import com.kreativity.studentregister.repo.SchoolInfoRepo;

@Service
public class SchoolInfoService {
	@Autowired
	private SchoolInfoRepo schoolInfoRepo;

	public void importExcelData(InputStream inputStream) throws IOException {
		Workbook workbook;
		
		// If the file is encrypted, provide the password to decrypt it
		workbook = new HSSFWorkbook(inputStream);

		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		for (Row row : sheet) {
		    String studentName = row.getCell(0).getStringCellValue();
		    java.util.Date dateCellValue = row.getCell(1).getDateCellValue();
		    LocalDateTime dob = dateCellValue.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		    String email = row.getCell(2).getStringCellValue();
		    String schoolName = row.getCell(3).getStringCellValue();
		    String whatsappNumber = row.getCell(4).getStringCellValue();

		    SchoolInfo schoolInfo = new SchoolInfo();
		    schoolInfo.setStudentName(studentName);
		    schoolInfo.setDob(dob);  // Set the correct LocalDateTime value here
		    schoolInfo.setEmail(email);
		    schoolInfo.setSchoolName(schoolName);
		    schoolInfo.setWhatsappNumber(whatsappNumber);

		    schoolInfoRepo.save(schoolInfo);
		}


		workbook.close();
	}

}*/
