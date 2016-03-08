package com.webportal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kumarao on 02-03-2016.
 */
@RefreshScope
@RestController
public class MessageRestController {

    @Value("${message}")
    private String message;

    @RequestMapping("/message")
    public String message(){
        return this.message;
    }
}
