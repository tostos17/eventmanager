package com.fowobi.pioneers.service;

import com.fowobi.pioneers.dto.RegistrationData;
import com.fowobi.pioneers.model.Participant;
import com.fowobi.pioneers.repository.ParticipantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ParticipantService {

    final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public String addParticipant(RegistrationData data) {
        String output = "";

        try {
            Participant save = participantRepository.save(convertToParticipant(data));
            output = String.valueOf(save.getId());
        } catch (Exception e) {
            log.error(e.getMessage());
            output = "Error occurred during processing";
            e.printStackTrace();
        }

        return output;
    }

    public List<Participant> getAllParticipant() {
        return participantRepository.findAll();
    }

    private Participant convertToParticipant(RegistrationData data) {
        Participant participant = new Participant();
        participant.setTitle(data.getTitle());
        participant.setGender(data.getGender());
        participant.setEmail(data.getEmail());
        participant.setFirstname(data.getFirstname());
        participant.setLastname(data.getLastname());
        participant.setChildFirstname(data.getChildFirstname());
        participant.setChildLastname(data.getChildLastname());
        participant.setMed(data.getMed());
        participant.setPhone(data.getPhone());



        log.info("the date is: {}", data.getDob());
        String[] dateParts = data.getDob().split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
        participant.setDob(date);

        return participant;
    }


}
