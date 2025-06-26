package com.fowobi.pioneers.controller;

import com.fowobi.pioneers.dto.RegistrationData;
import com.fowobi.pioneers.service.ExcelExportService;
import com.fowobi.pioneers.service.ParticipantService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/event")
public class CoreController {

    final ParticipantService participantService;
    final ExcelExportService excelExportService;

//    @Value("${max.count}")
    int maxCount = 15;

    public CoreController(ParticipantService participantService, ExcelExportService excelExportService) {
        this.participantService = participantService;
        this.excelExportService = excelExportService;
    }

//    @GetMapping("/hello")
//    public ModelAndView welcome() {
//        ModelAndView model = new ModelAndView("hello");
//
//
//        return model;
//    }

    @GetMapping("/reg")
    public ModelAndView register() {

        ModelAndView model = new ModelAndView();

        if(!reachedCapacity())
            model.setViewName("registration");
        else
            model.setViewName("closed");


        return model;
    }

    @PostMapping("/processregistration")
    public ModelAndView processRegistration(@ModelAttribute("regsuccess") RegistrationData data) {
        ModelAndView model = new ModelAndView();
        String response = participantService.addParticipant(data);

        if(!response.startsWith("Error")) {
            model.setViewName("regsuccess");
            model.addObject("title", data.getTitle());
            model.addObject("lastname", data.getLastname());
        } else {
            model.setViewName("registration");
            model.addObject("errorMessage", "An error occurred. Please, try again");
        }


        return model;
    }


    @GetMapping("/lm123-j")
    public ModelAndView view() {
        ModelAndView model = new ModelAndView("participantviewer");
        model.addObject("participants", participantService.getAllParticipant());

        return model;
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadTest() throws IOException {

        System.out.println("Downloading...");
        ByteArrayInputStream in = excelExportService.exportUsersToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=participants.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(in));
    }

    @GetMapping("/testheader")
    public ModelAndView testHeader() {
        ModelAndView model = new ModelAndView("header");

        return model;
    }

    private boolean reachedCapacity() {
        return participantService.getAllParticipant().size() >= maxCount;
    }

}
