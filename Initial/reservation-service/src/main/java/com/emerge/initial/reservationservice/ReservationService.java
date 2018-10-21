package com.emerge.initial.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
public class ReservationService {

    private static final List<Reservation> RESERVATIONS;

    static {
        RESERVATIONS = asList(
                new Reservation().setId("1").setConference("EMerge").setSpeakers(asList("11", "12")),
                new Reservation().setId("2").setConference("Another one").setSpeakers(asList("12", "22")),
                new Reservation().setId("broken").setConference("Just for testing").setSpeakers(asList("random"))
        );
    }

    private static final String URL = "http://localhost:8222/speakers/{id}";
    private RestTemplate restTemplate;

    @Autowired
    public ReservationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Reservation> getReservations() {
        return RESERVATIONS;
    }

    public ReservationDetail getReservationDetail(String id) {
        Reservation reservation = RESERVATIONS.stream().filter(res -> id.equals(res.getId())).findFirst()
                .orElse(new Reservation());
        ReservationDetail detail = new ReservationDetail();
        detail.setId(reservation.getId());
        detail.setConference(reservation.getConference());
        detail.setSpeakers(getSpeakers(reservation));
        return detail;
    }

    private List<Speaker> getSpeakers(Reservation reservation) {
        return reservation.getSpeakers().stream()
                .map(id -> restTemplate.getForObject(URL, Speaker.class, id))
                .collect(Collectors.toList());
    }

}
