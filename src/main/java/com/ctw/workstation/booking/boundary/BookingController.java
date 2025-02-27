package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.dto.BookingDto;
import com.ctw.workstation.booking.dto.BookingOutputDto;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.common.ErrorResponse;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;

@Path("/workstation/bookings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingController {

    @Inject
    BookingService service;

    @GET
    public Response listBookings() {
        List<Booking> list = service.getAllBookings();
        BookingOutputDto output = new BookingOutputDto(list);
//        Log.info("Info getAllBookings");
//        Log.warn("Warning getAllBookings");
//        Log.error("Error getAllBookings");
//        Log.debug("Debug getAllBookings");
        return Response
                .status(Response.Status.OK)
                .entity(output)
                .build();
    }


    @POST
    public Response addBooking(@RequestBody BookingDto input) {
        try {
            Booking savedBooking = service.createBooking(input);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(savedBooking)
                    .build();
        } catch (RuntimeException exception) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("Error creating booking", exception.getMessage()))
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    public Response showBooking(@PathParam("id") Long id) {
        Booking booking = service.findBooking(id);
        return Response
                .status(Response.Status.OK)
                .entity(booking)
                .build();
    }
}