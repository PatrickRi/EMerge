package com.emerge.conplete.reservationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "speaker-service", fallbackFactory = SpeakerFallback.class)
public interface SpeakerService {

    @GetMapping("/speakers/{id}")
    Speaker getSpeaker(@PathVariable(name = "id") String id);
}
