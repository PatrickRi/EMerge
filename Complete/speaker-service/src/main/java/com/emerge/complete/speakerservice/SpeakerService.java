package com.emerge.complete.speakerservice;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SpeakerService {

    private static final List<Speaker> SPEAKERS;

    static {
        SPEAKERS = Arrays.asList(
                new Speaker().setId("11").setFirstName("Me").setLastName("Myself"),
                new Speaker().setId("12").setFirstName("Maria").setLastName("Smith"),
                new Speaker().setId("22").setFirstName("George").setLastName("Random")

        );
    }

    public Speaker getSpeakerById(String id) {
        return SPEAKERS.stream().filter(speaker -> id.equals(speaker.getId())).findFirst().get();
    }
}
