package com.justinsb.templateapp.api;

import java.io.IOException;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Singleton
@Path("/api/ping")
public class PingEndpoint {

    @GET
    public String doPing() throws IOException {
        return "pong";
    }
}