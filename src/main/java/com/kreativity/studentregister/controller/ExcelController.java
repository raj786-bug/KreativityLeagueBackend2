package com.kreativity.studentregister.controller;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExcelController {
    
    @GetMapping("/download-excel")
    @CrossOrigin
    public ResponseEntity<byte[]> downloadExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Student Data");

        // Create a font with bold style
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);

        // Create a CellStyle with the bold font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create headers with bold style
        XSSFRow headerRow = sheet.createRow(0);
        List<String> excelHeaders = Arrays.asList(
            "Student Name", "Date of Birth(MM/DD/YYYY)", "Email Id", "Parent's Name", "Relationship with parents",
            "Name of the School", "City", "State", "Pincode", "Whatsapp no of parents", "Teacher Coordinator",
            "Registration fee"
        );

        for (int colIndex = 0; colIndex < excelHeaders.size(); colIndex++) {
            XSSFCell cell = headerRow.createCell(colIndex);
            cell.setCellValue(excelHeaders.get(colIndex));
            cell.setCellStyle(headerCellStyle); // Set the bold style
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        byte[] excelBytes = outputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "KL_Student's_Registration.xlsx");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelBytes);
    }
}

