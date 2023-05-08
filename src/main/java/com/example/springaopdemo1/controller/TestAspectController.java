package com.example.springaopdemo1.controller;

import com.example.springaopdemo1.service.TestAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAspectController {

    @Autowired
    TestAspect testAspect;

    @GetMapping("/")
    public ResponseEntity<?> testAspect() {
        return ResponseEntity.ok(testAspect.testAspect());
    }


}
