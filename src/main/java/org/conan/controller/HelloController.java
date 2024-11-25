package org.conan.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Log4j
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String home(Locale locale, Model model) {
        log.info(String.format("Welcome home! The client locale is %s.",locale));

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,locale);

        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);

        return "hello";
    }
}

