package com.ctw.workstation.rack.boundary;


import com.ctw.workstation.rack.dto.RackDto;
import com.ctw.workstation.rack.dto.RackOutputDto;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/workstation/racks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackController {

    // private static final Logger log = Logger.getLogger(RackService.class);

    @Inject
    RackService service;

    @GET
    public Response listRacks() {
        List<Rack> list = service.getAllRacks();
        RackOutputDto output = new RackOutputDto(list);
        return Response
                .status(Response.Status.OK)
                .entity(output)
                .build();
    }

    @POST
    public Response addRack(@RequestBody @Valid RackDto input) {
        Rack savedRack = service.createRack(input);
        return Response
                .status(Response.Status.CREATED)
                .entity(savedRack)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response showRack(@PathParam("id") Long id) {
        Rack rack = service.findRack(id);
        return Response
                .status(Response.Status.OK)
                .entity(rack)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRack(@PathParam("id") Long id) {
        Rack rack = service.destroyRack(id);
        return Response
                .status(Response.Status.OK)
                .entity(rack)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRack(@PathParam("id") Long id, @RequestBody RackDto input) {
        Rack updateRack = service.updateRack(id, input);
        return Response
                .status(Response.Status.OK)
                .entity(updateRack)
                .build();
    }

//    @GET
//    @Path("/search")
//    public Response searchRacksByStatus(@QueryParam("status") String status) {
//        List<Rack> list = service.getAllRacksByStatus(status);
//        RackOutputDto output = new RackOutputDto(list);
//        return Response
//                .status(Response.Status.OK)
//                .entity(output)
//                .build();
//    }

}
