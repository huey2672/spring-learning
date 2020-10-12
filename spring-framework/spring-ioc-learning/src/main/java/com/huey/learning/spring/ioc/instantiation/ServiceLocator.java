package com.huey.learning.spring.ioc.instantiation;

public class ServiceLocator {

    private static ClientService clientService = new ClientService();

    private ServiceLocator() {
    }

    public ClientService createClientServiceInstance() {
        return clientService;
    }

}