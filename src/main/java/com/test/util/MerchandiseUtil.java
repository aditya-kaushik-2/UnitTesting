package com.test.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MerchandiseUtil {

    public String getShirtName(Integer length) { // int,double,char would create problem in mocking
        if(length >=0 && length <= 10) {
            String name = UUID.randomUUID().toString();
            return name.substring(0, length);
        } else {
            throw new RuntimeException("Invalid name length");
        }
    }
}
