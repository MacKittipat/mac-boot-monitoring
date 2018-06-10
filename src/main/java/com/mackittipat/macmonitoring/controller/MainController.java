package com.mackittipat.macmonitoring.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/hello")
    public String hello() throws InterruptedException {

        Random random = new Random();
        int low = 0;
        int high = 3;
        int rNum = (random.nextInt(high-low) + low) * 1000;
        Thread.sleep(rNum);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(
                "https://www.random.org/integers/?num=1&min=1&max=100&col=1&base=10&format=plain&rnd=new",
                String.class);
        log.info("Result = {}, Sleep = {}", result.trim(), rNum);
        return "Hello " + result;
    }

    @RequestMapping("/bye")
    public String bye() {
        log.debug("Bye");
        return "Bye";
    }

    @RequestMapping("/run")
    public String run(@RequestParam boolean injured) throws Exception {
        if(injured) {
            String errMsg = "I got injured. I cannot run.";
            log.error(errMsg);
            throw new Exception(errMsg);
        }
        return "Running";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        return "Handle Exception = " + e.getMessage();
    }
}
