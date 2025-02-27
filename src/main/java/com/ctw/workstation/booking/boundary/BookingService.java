package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.dto.BookingDto;
import com.ctw.workstation.booking.entity.Booking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class BookingService {

    @Inject
    BookingDatabase database;

    @Transactional
    public Booking createBooking(BookingDto input) {
        boolean isAfterToday = input.getBookFrom().isAfter(LocalDateTime.now()) && input.getBookTo().isAfter(LocalDateTime.now());
        boolean isBeforeFinalDate = input.getBookFrom().isBefore(input.getBookTo());
        if(!isAfterToday) {
            throw new RuntimeException("Selected dates should be after today");
        } else if(!isBeforeFinalDate) {
            throw new RuntimeException("Start date should be before final date");
        } else {
            Booking newBooking = new Booking(input.getRack(), input.getRequester(), input.getBookFrom(), input.getBookTo());
            database.persist(newBooking);
            return newBooking;
        }
    }

    @Transactional
    public Booking findBooking(Long id) {
        return database.findById(id);
    }

    @Transactional
    public List<Booking> getAllBookings() {
        return database.listAll();
    }
}
