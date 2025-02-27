package com.ctw.workstation;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingConfig greetingConfig;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    //public String hello() {return "Hello from Quarkus REST Margarida ;)";}
    public String oi() { return greetingConfig.anotherMessage(); };
}


