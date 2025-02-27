package com.ctw.workstation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/goodbye")
public class GreetingResourceCustomized {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String goodbye() {
        return "Goodbye from Quarkus REST, you fool!";
    }
}
