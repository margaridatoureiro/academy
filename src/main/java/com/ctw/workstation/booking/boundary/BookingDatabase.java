package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class BookingDatabase implements PanacheRepository<Booking> {
}