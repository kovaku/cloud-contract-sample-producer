package com.github.kovaku.producer.controller;

import com.github.kovaku.producer.service.FibonacciService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Map;

@Validated
@RestController
public class FibonacciController {

    private final FibonacciService service;

    public FibonacciController(FibonacciService service) {
        this.service = service;
    }

    @GetMapping(path = "fibonacci", produces = "application/json")
    public Map<String, Long> getFibonacci(@RequestHeader("client-id") @Pattern(regexp = "[a-z]+-consumer") String string,
                                          @RequestParam("nth") @Min(0) @Max(100) Integer nth) {
        return Map.of("nth", nth.longValue(), "fibonacci", service.fibRecursiveWithTempArray(nth));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> onException(Exception ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
