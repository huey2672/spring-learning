package com.huey.learning.spring.ioc.conditional.component;

public class UnixListService implements ListService {

    @Override
    public String getListCmd() {
        return "ls";
    }

}