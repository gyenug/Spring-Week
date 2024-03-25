package com.example.blogjpa.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class FilterTestController {
    @GetMapping("/filter/test")
    public void test(HttpServletRequest request) {
        String traceId = (String) request.getAttribute("traceId");
        log.info(traceId);
    }
}