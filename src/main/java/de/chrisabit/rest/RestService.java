package de.chrisabit.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RestService {
    @GET
    @Path("/nachricht")
    @Produces(MediaType.TEXT_PLAIN)
    public String getNachricht() {
        return new NachrichtenGenerator().execute();
    }

    @GET
    @Path("/version")
    @Produces(MediaType.TEXT_PLAIN)
    public String getVersion() {
        return "1.0";
    }
}
