package com.ctw.workstation.booking.dto;

import com.ctw.workstation.booking.entity.Booking;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookingOutputDto {
    @JsonProperty
    private List<Booking> bookings;

    public BookingOutputDto(List<Booking> list) {
        this.bookings = list;
    }
}
