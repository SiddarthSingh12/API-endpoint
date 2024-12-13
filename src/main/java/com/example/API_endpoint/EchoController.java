package com.example.API_endpoint;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Rest Controller for endpoint
@RestController
public class EchoController {
    //Define endpoint
    @PostMapping("/echo/{customerNumber}")
    public Map<String, Object> echo(@RequestHeader Map<String, String> headers,
                                    @RequestParam(required = false) String DBG,
                                    @PathVariable String customerNumber,
                                    @RequestBody Object requestBody) {
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

        //@PathVariable gets customerNumber from URL and include it in the response
        response.put("customerNo", customerNumber);
        // Log customerNumber
        if(customerNumber!=null)System.out.println("customerNumber:"+customerNumber);

        //@RequestBody deserializes and then maps the request body to a generic object
        response.put("request",requestBody);

        //Include type of request body to response
        if (requestBody instanceof List) {
            response.put("type", "array");
        } else if (requestBody instanceof Map) {
            response.put("type", "object");
        } else if (requestBody instanceof String) {
            response.put("type", "string");
        } else {
            response.put("type", "unknown");
        }

        return response;
    }
}
