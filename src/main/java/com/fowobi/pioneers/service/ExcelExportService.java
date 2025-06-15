package com.fowobi.pioneers.service;

import com.fowobi.pioneers.model.Participant;
import com.fowobi.pioneers.repository.ParticipantRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {

    private final ParticipantRepository participantRepository;

    public ExcelExportService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }


    public ByteArrayInputStream exportUsersToExcel() throws IOException {
        List<Participant> participants = participantRepository.findAll();

        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("Participants");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Player Firstname");
            header.createCell(2).setCellValue("Player Lastname");
            header.createCell(3).setCellValue("Date of Birth");
            header.createCell(4).setCellValue("Gender");
            header.createCell(5).setCellValue("Medical Issue");
            header.createCell(6).setCellValue("Parent Firstname");
            header.createCell(7).setCellValue("Parent Lastname");
            header.createCell(8).setCellValue("Phone");
            header.createCell(9).setCellValue("Email");
            header.createCell(10).setCellValue("Address");

            int rowIdx = 1;
            for (Participant participant : participants) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(participant.getId());
                row.createCell(1).setCellValue(participant.getChildFirstname());
                row.createCell(2).setCellValue(participant.getChildLastname());
                row.createCell(3).setCellValue(participant.getDob());
                row.createCell(4).setCellValue(participant.getGender());
                row.createCell(5).setCellValue(participant.getMed());
                row.createCell(6).setCellValue(participant.getFirstname());
                row.createCell(7).setCellValue(participant.getLastname());
                row.createCell(8).setCellValue(participant.getPhone());
                row.createCell(9).setCellValue(participant.getEmail());
                row.createCell(10).setCellValue(participant.getAddress());

            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

