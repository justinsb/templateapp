package com.justinsb.templateapp;

import com.google.inject.servlet.ServletModule;
import com.justinsb.templateapp.api.CORSFilter;
import com.justinsb.templateapp.api.ExampleEndpoint;
import com.justinsb.templateapp.api.PingEndpoint;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

class AppServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        bind(ExampleEndpoint.class);
        bind(PingEndpoint.class);

        filter("/api/*").through(CORSFilter.class);

        serve("/*").with(GuiceContainer.class);
    }
}