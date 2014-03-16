package com.justinsb.templateapp.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.justinsb.templateapp.services.LogicService;

@Singleton
@Path("/api/example")
public class ExampleEndpoint {
    @Inject
    LogicService logic;

    @GET
    public String getExample(@QueryParam("r") String request) throws IOException {
        return logic.process(request);
    }
}