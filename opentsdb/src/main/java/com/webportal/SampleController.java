package com.webportal;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

/**
 * Created by amarendra on 22/09/16.
 */
@Controller
@Description("A controller for handling requests for hello messages")
public class SampleController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/")
    @ResponseBody
    public Map<String, String> hello() {
        return Collections.singletonMap("message",
                this.helloWorldService.getHelloMessage());
    }

    protected static class Message {

        @NotBlank(message = "Message value cannot be empty")
        private String value;

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
