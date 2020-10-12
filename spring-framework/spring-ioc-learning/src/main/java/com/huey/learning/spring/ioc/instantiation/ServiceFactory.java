package com.huey.learning.spring.ioc.instantiation;

/**
 * @author huey
 */
public class ServiceFactory {

    private static ClientService clientService = new ClientService();

    public static ClientService createInstance() {
        return clientService;
    }

}
