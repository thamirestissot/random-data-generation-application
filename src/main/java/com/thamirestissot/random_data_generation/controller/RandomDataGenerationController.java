package com.thamirestissot.random_data_generation.controller;

import com.thamirestissot.random_data_generation.service.RandomDataGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class RandomDataGenerationController {
    private final Logger logger = Logger.getLogger(RandomDataGenerationController.class.getName());
    @Autowired
    private RandomDataGenerationService service;

    @GetMapping("{id}/transacoes/{year}/{month}")
    public ResponseEntity getRandomData(@PathVariable("id") Long id, @PathVariable("year") int year, @PathVariable("month") int month) {
        logger.info(id + " user request to check transaction history for month " + month + " of " + year + " received");

        ResponseEntity responseEntity;
        try {
            responseEntity = ResponseEntity.ok(service.generate(id, year, month));
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage() + "<br>Must be:<br>'/[idClient]/transacoes/[yyyy]/[MM]'");
            logger.warning(e.getMessage());
        }

        return responseEntity;
    }
}