package com.fowobi.pioneers.controller;

import com.fowobi.pioneers.dto.RegistrationData;
import com.fowobi.pioneers.service.ParticipantService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/event")
public class CoreController {

    final ParticipantService participantService;

//    @Value("${max.count}")
    int maxCount = 7;

    public CoreController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/hello")
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView("hello");


        return model;
    }

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

    private boolean reachedCapacity() {
        return participantService.getAllParticipant().size() >= maxCount;
    }

}
