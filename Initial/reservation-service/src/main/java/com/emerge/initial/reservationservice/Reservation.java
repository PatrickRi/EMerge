package com.emerge.initial.reservationservice;

import java.util.List;

public class Reservation {

    private String id;
    private String conference;
    private List<String> speakers;

    public String getId() {
        return id;
    }

    public Reservation setId(String id) {
        this.id = id;
        return this;
    }

    public String getConference() {
        return conference;
    }

    public Reservation setConference(String conference) {
        this.conference = conference;
        return this;
    }

    public List<String> getSpeakers() {
        return speakers;
    }

    public Reservation setSpeakers(List<String> speakers) {
        this.speakers = speakers;
        return this;
    }
}
