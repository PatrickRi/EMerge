package com.emerge.initial.speakerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeakerController {

    private SpeakerService speakerService;

    @Autowired
    public SpeakerController(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @GetMapping("/speakers/{id}")
    public Speaker getSpeaker(@PathVariable String id) {
        return speakerService.getSpeakerById(id);
    }
}
