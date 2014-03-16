package com.justinsb.templateapp.services;

import javax.inject.Singleton;

@Singleton
public class LogicService {

    public String process(String request) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException();
        }
        return "response to " + request;
    }

}
