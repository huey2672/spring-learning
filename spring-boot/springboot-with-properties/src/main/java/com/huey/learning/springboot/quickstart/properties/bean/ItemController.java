package com.huey.learning.springboot.quickstart.properties.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huey
 */
@RestController
public class ItemController {

    @Autowired
    private Item item;

    @GetMapping("item")
    public Item getItem() {
        return item;
    }

}
