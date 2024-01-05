package com.example.mybatisdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    DemoMapper mapper;

    public DemoController(DemoMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("demo")
    String demo() {
        mapper.get();
        return "demo";
    }
}
