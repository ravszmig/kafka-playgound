package com.ravsky.kafkaplaygroundconsumer.controller;

import com.ravsky.kafkaplaygroundconsumer.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {

        int range = 100;
        while (range > 0) {
            var loc = Math.random() + " , " + Math.random();
            cabLocationService.updateLocation(loc);
            range--;
            Thread.sleep(200);
        }

        return new ResponseEntity<>(
                Map.of("message", "Location updated!"),
                HttpStatus.OK
        );
    }
}
