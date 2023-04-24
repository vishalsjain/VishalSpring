package com.example.VishalSpring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class COntroller1 {

@GetMapping("/controller1")
public ResponseEntity<?> getData(){
    ResponseEntity rp=new ResponseEntity("Data**", HttpStatus.ACCEPTED);

    System.out.println("get C");
    return rp;
}

}
