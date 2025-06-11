package com.fowobi.pioneers;

import com.fowobi.pioneers.dto.RegistrationData;
import com.fowobi.pioneers.service.ParticipantService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventManagerApplication {

	@Autowired
	ParticipantService service;

	public static void main(String[] args) {
		SpringApplication.run(EventManagerApplication.class, args);
	}

	@PostConstruct
	public void runIt() {
		service.addParticipant(new RegistrationData("Miss", "Lara", "Fagbehin", "08011223344", "", "Jide", "Fagbehin", "2018-10-01", "M", "No"));
		service.addParticipant(new RegistrationData("Mr", "Gbade", "Geshin", "0801754944", "geshino@gmail.com", "Femi", "Geshin", "2017-10-01", "M", "No"));
		service.addParticipant(new RegistrationData("Miss", "Lara", "Fagbehin", "08011223344", "", "Jide", "Fagbehin", "2018-10-01", "M", "No"));
		service.addParticipant(new RegistrationData("Miss", "Lara", "Fagbehin", "08011223344", "", "Jide", "Fagbehin", "2018-10-01", "M", "No"));
		service.addParticipant(new RegistrationData("Miss", "Lara", "Fagbehin", "08011223344", "", "Jide", "Fagbehin", "2018-10-01", "M", "No"));
	}
}
