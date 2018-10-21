package com.emerge.conplete.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class ReservationService {

    private static final List<Reservation> RESERVATIONS;
    private SpeakerService speakerService;

    static {
        RESERVATIONS = asList(
                new Reservation().setId("1").setConference("EMerge").setSpeakers(asList("11", "12")),
                new Reservation().setId("2").setConference("Another one").setSpeakers(asList("12", "22")),
                new Reservation().setId("broken").setConference("Just for testing").setSpeakers(asList("random"))
        );
    }

    @Autowired
    public ReservationService(SpeakerService speakerService) {
        this.speakerService = speakerService;
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
        return Flux.fromIterable(reservation.getSpeakers())
                .flatMap(speakerId -> getSpeakerAsync(speakerId))
                .collectList().block();
    }

    private Speaker getSpeaker(String id) {
        return speakerService.getSpeaker(id);
    }

    private Mono<Speaker> getSpeakerAsync(String id) {
        return Mono.fromCallable(() -> speakerService.getSpeaker(id)).subscribeOn(Schedulers.elastic());
    }
}
