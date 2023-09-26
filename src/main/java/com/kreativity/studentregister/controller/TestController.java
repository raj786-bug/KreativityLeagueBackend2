package com.kreativity.studentregister.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class TestController {
	@GetMapping("/")
    public String showForm() {
      
        return "Website uptodate";
    }

}
