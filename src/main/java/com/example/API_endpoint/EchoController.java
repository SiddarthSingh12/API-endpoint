package com.example.API_endpoint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// Rest Controller for endpoint
@RestController
public class EchoController {
    //Define endpoint
    @PostMapping("/echo/{customerNumber}")
    public Map<String, Object> echo(@RequestHeader Map<String, String> headers,
                                    @RequestParam(required = false) String DBG) {
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

        //Add current timestamp epoch in seconds to response
        response.put("uts",System.currentTimeMillis()/1000);

        //@RequestParam accepts query parameters
        //Include DBG in the response body if it exists
        if (DBG != null) {
            response.put("DBG", DBG);
            //Log the value of DBG
            System.out.println("DBG: " + DBG);
        }

        return response;
    }
}
