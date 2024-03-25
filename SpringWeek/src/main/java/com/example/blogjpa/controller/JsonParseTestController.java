package com.example.blogjpa.controller;

import com.example.blogjpa.external.ExternalApiParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JsonParseTestController {
    private final ExternalApiParser parser;

    public JsonParseTestController(ExternalApiParser parser) {
        this.parser = parser;
    }

    @GetMapping("/api/test")
    public void test(){
        parser.parser();
    }

}
