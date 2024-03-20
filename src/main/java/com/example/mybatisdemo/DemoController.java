package com.example.mybatisdemo;

import com.example.mybatisdemo.model.DemoPk;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    DemoMapper mapper;

    public DemoController(DemoMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("demo")
    List<Demo> demo() {
        return mapper.get();
//        return "demo";
    }

    @GetMapping("getbyid")
    Demo getById() {
        return mapper.getById(new DemoPk("001"));
//        return "demo";
    }
}
