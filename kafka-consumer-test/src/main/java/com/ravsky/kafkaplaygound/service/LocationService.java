package com.ravsky.kafkaplaygound.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ravsky.kafkaplaygound.constant.AppConstant;

@Service
public class LocationService {

    @KafkaListener(topics = AppConstant.CAB_LOCATION, groupId = "user-group")
    public void cabLocation(String location) {
        System.out.println(location);
    }

}
