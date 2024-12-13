package com.example.API_endpoint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// Rest Controller for endpoint
@RestController
public class EchoController {
    //Define endpoint
    @PostMapping("/echo/{customerNumber}")
    public Map<String, Object> echo() {
        // create response map
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);

        return response;
    }
}
