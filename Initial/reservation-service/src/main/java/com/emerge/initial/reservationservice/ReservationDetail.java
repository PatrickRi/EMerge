package com.emerge.initial.reservationservice;

import java.util.List;

public class ReservationDetail {

    private String id;
    private String conference;
    private List<Speaker> speakers;

    public String getId() {
        return id;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public ReservationDetail setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
        return this;
    }
}
