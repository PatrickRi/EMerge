package com.emerge.conplete.reservationservice;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class SpeakerFallback implements FallbackFactory<SpeakerService> {

    @Override
    public SpeakerService create(Throwable cause) {
        return id -> {
            Speaker speaker = new Speaker();
            speaker.setId("unknown");
            speaker.setFirstName(cause.getMessage());
            speaker.setLastName(cause.getMessage());
            return speaker;
        };
    }
}
