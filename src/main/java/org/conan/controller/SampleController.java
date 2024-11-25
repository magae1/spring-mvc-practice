package org.conan.controller;

import java.util.ArrayList;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.conan.domain.SampleDTO;


@Log4j
@Controller
@RequestMapping("/sample/*")
public class SampleController {

    @GetMapping("/ex01")
    public @ResponseBody SampleDTO ex01(SampleDTO dto) {
        log.info(dto);
        return dto;
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        log.info("name: " + name + ", age: " + age);
        return "ex02";
    }

    @GetMapping("/ex03")
    public String ex03(@RequestParam("ids") ArrayList<String> ids) {
        log.info("ids: " + ids);
        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);
        return "ex04";
    }

    @GetMapping("/ex05")
    public void ex05() {
    }

    @GetMapping("/ex07")
    public ResponseEntity<String> ex07() {
        log.info("ex07");
        String message = String.format("{\"name\":\"conan\"}");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        headers.add("Authentication", "123456");
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
}
