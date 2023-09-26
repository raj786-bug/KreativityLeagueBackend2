package com.kreativity.studentregister.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ExcelGeneratorService {

    public byte[] generateExcelBytes() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Student Data");

        // Create header row
        Row headerRow = sheet.createRow(0);
        List<String> headers = Arrays.asList(
            "StudentEmailId", "StudentName", "Date of birth", "Teacher Email ID",
            "Name of school", "city", "state", "pincode", "Teacher Coordinator",
            "Parent's Name", "Relationship", "Parent's Mobile"
        );

        for (int i = 0; i < headers.size(); i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(headers.get(i));
        }

        // Create a cell style for date and time format
        CellStyle dateCellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));

        // Sample date and time value (you can replace this with your actual data)
        Date sampleDate = new Date();

        // Create a data row with a date and time value
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue("john.doe@example.com"); // StudentEmailId
        dataRow.createCell(1).setCellValue("John Doe"); // StudentName
        Cell dobCell = dataRow.createCell(2);
        dobCell.setCellValue(sampleDate); // Date of birth
        dobCell.setCellStyle(dateCellStyle); // Apply date and time format
        dataRow.createCell(3).setCellValue("teacher@example.com"); // Teacher Email ID
        dataRow.createCell(4).setCellValue("ABC School"); // Name of school
        dataRow.createCell(5).setCellValue("City"); // city
        dataRow.createCell(6).setCellValue("State"); // state
        dataRow.createCell(7).setCellValue("12345"); // pincode
        dataRow.createCell(8).setCellValue("Teacher Coordinator Name"); // Teacher Coordinator
        dataRow.createCell(9).setCellValue("Parent's Name"); // Parent's Name
        dataRow.createCell(10).setCellValue("Relationship"); // Relationship
        dataRow.createCell(11).setCellValue("9876543210"); // Parent's Mobile

        // ... Add any further data as needed ...

        // Write the workbook to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }
}
