package com.webportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amarendra on 8/3/17.
 */
@RestController
@RequestMapping("/hello")
public class TestController {

    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private Tracer tracer;

    @GetMapping
    public ResponseEntity test1(){
        LOGGER.info("Test1",tracer.getCurrentSpan());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseEntity("Hello", HttpStatus.OK);
    }
}
