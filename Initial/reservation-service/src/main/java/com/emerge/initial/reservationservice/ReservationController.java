package com.emerge.initial.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }

    @GetMapping("/reservations/{id}")
    public ReservationDetail getReservationDetail(@PathVariable String id) {
        return reservationService.getReservationDetail(id);
    }
}
