package com.example.aeon;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyResponse {
    public Map OkRequest(Object object, String message) {
        Map map = new HashMap<>();
        map.put("data", object);
        map.put("message", message);
        map.put("status", 200);
        return map;
    }

    public Map BadRequest(Object object) {
        Map map = new HashMap<>();
        map.put("message", object);
        map.put("status", 400);
        return map;
    }

    public Map ErrorRequest(Object object) {
        Map map = new HashMap<>();
        map.put("message", object);
        map.put("status", 404);
        return map;
    }
}
