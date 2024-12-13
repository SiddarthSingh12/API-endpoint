package com.example.API_endpoint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// Rest Controller for endpoint
@RestController
public class EchoController {
    //Define endpoint
    @PostMapping("/echo/{customerNumber}")
    public Map<String, Object> echo(@RequestHeader Map<String, String> headers) {
        // create response map
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);

        //@RequestHeader gets mapping for header values
        //check if the 'sq' head exists
        if (headers.containsKey("sq")) {
            try {
                // parse 'sq' as an integer
                int sq = Integer.parseInt(headers.get("sq"));
                response.put("sq", sq * sq);
            } catch (NumberFormatException e) {
                // handle invalid values
                response.put("sq", "Enter valid 'sq' values");
            }
        }

        return response;
    }
}
