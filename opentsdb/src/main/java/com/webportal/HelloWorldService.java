package com.webportal;

/**
 * Created by amarendra on 22/09/16.
 */
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class HelloWorldService {

    private String name = "World";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelloMessage() {
        return "Hello " + this.name;
    }

}