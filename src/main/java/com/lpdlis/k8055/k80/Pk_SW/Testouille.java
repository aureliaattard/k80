package com.lpdlis.k8055.k80.Pk_SW;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

@Path("/flop")

public class Testouille {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "testouille!";
    }

    @GET
    @Path("/Lance")
    @Produces(MediaType.TEXT_PLAIN)
    public String LanceProcess() {
        return "testouille methode";
    }
}
