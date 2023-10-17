package com.pulsar.project.producer.controller;

import com.pulsar.project.producer.dto.User;
import com.pulsar.project.producer.service.PublishMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final PublishMessage publishMessage;
    @PostMapping
    public ResponseEntity<String> send(@RequestBody User user){
        return ResponseEntity.ok(this.publishMessage.publish(user));
    }
}
