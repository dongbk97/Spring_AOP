package com.example.springaopdemo1.service;

import com.example.springaopdemo1.testduration.ExecDuration;
import org.springframework.stereotype.Service;

@Service
public class TestAspect {

    @ExecDuration
    public String testAspect() {
        System.out.println(" TestAspect");
        return "TestAspect";
    }
}
