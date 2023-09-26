package com.kreativity.studentregister.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl = "https://websmsindia.net/api/swsendSingle.asp?username=t2ABLEDUCATION&password=78568055&sender=ABLEDU";

    // Map to store generated OTPs temporarily
    private Map<String, String> otpStorage = new HashMap<>();

    @GetMapping("/sendOTP")
    public ResponseEntity<?> sendOTP(@RequestParam String phoneNumber) {
        try {
            // Generate a random 4-digit OTP
            String otp = generateRandomOTP();

            // Store the generated OTP for later verification
            storeOTP(phoneNumber, otp);

            // Create the message with the generated OTP
            String message = "Hello, Your OTP for Registration is: " + otp +
                    ". Please enter this OTP on KreativityLeague.com to register and proceed further. Thank you, Team- ABL EDUCATION";

            // Build the request URL with the phone number and message
            String requestUrl = apiUrl + "&sendto=" + phoneNumber + "&entityID=1701169181963345886&templateID=1707169199924262517&message=" + message;

            ResponseEntity<String> response = restTemplate.getForEntity(requestUrl, String.class);

            // Check if the response body contains "log id" to determine success
            boolean status = response.getBody() != null && response.getBody().contains("LogID");

            // Create a message based on the status
            String jsonResponse = "{\"status\":" + status + ",\"message\":\"" + (status ? "OTP sent successfully" : "OTP not sent successfully. Please check the phone number.") + "\"}";

            return ResponseEntity.ok().body(jsonResponse);
        } catch (HttpClientErrorException.BadRequest e) {
            // Handle bad request errors (e.g., missing parameters)
            String errorMessage = "Bad request to OTP API: " + e.getMessage();
            return ResponseEntity.badRequest().body("{\"status\":false,\"message\":\"" + errorMessage + "\"}");
        } catch (Exception e) {
            // Handle other exceptions or errors
            String errorMessage = "Error sending OTP: " + e.getMessage();
            return ResponseEntity.status(500).body("{\"status\":false,\"message\":\"" + errorMessage + "\"}");
        }
    }

    @GetMapping("/verifyOTP")
    public ResponseEntity<?> verifyOTP(@RequestParam String phoneNumber, @RequestParam String enteredOTP) {
        try {
            // Retrieve the stored OTP for the given phone number
            String storedOTP = retrieveStoredOTP(phoneNumber);

            if (storedOTP != null && storedOTP.equals(enteredOTP)) {
                // OTP is valid, you can perform the desired action here
                return ResponseEntity.ok().body("{\"status\":true,\"message\":\"OTP verified successfully.\"}");
            } else {
                // OTP is not valid
                return ResponseEntity.ok().body("{\"status\":false,\"message\":\"Invalid OTP.\"}");
            }
        } catch (Exception e) {
            // Handle other exceptions or errors
            String errorMessage = "Error verifying OTP: " + e.getMessage();
            return ResponseEntity.status(500).body("{\"status\":false,\"message\":\"" + errorMessage + "\"}");
        }
    }

    // Method to generate a random 4-digit OTP
    private String generateRandomOTP() {
        int min = 1000; // Minimum OTP value
        int max = 9999; // Maximum OTP value
        return String.valueOf(min + (int)(Math.random() * (max - min + 1)));
    }

    // Method to retrieve the stored OTP for a given phone number
    private String retrieveStoredOTP(String phoneNumber) {
        return otpStorage.get(phoneNumber);
    }

    // Method to store the OTP for a given phone number
    private void storeOTP(String phoneNumber, String otp) {
        otpStorage.put(phoneNumber, otp);
    }
}
