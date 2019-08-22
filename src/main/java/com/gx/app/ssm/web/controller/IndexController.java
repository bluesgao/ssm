package com.gx.app.ssm.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    @GetMapping("/index.html")
    public String index() {
        log.info("index");
        return "index";
    }

    @GetMapping("/")
    public String home() {
        log.info("home");
        return "index";
    }
}
