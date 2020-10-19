package com.huey.learning.spring.ioc.conditional.component;

public class WindowsListService implements ListService {

    @Override
    public String getListCmd() {
        return "dir";
    }

}