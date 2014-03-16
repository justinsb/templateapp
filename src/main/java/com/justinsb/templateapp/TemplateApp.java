package com.justinsb.templateapp;

import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.justinsb.templateapp.services.JettyService;

public class TemplateApp {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws Exception {
        int httpPort = getHttpPort();

        List<Module> modules = Lists.newArrayList();
        modules.add(new AppModule());
        modules.add(new AppServletModule());
        Injector injector = Guice.createInjector(modules);

        JettyService jetty = injector.getInstance(JettyService.class);
        jetty.init(httpPort);

        jetty.startAndWait();
    }

    private static int getHttpPort() {
        String portString = System.getenv("PORT");
        if (Strings.isNullOrEmpty(portString)) {
            return DEFAULT_PORT;
        } else {
            return Integer.valueOf(portString);
        }
    }
}
