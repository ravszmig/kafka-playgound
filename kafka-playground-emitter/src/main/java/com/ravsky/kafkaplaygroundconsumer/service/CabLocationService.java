package com.ravsky.kafkaplaygroundconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ravsky.kafkaplaygroundconsumer.constant.AppConstant;

@Service
public class CabLocationService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean updateLocation(String location) {
        var res = kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
        System.out.println("Sending: " + location);
        return res.isDone();
    }
}
