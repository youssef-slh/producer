package com.pulsar.project.producer.record;

import com.pulsar.project.producer.dto.User;

public record MessageRecord(Long id, User user){
}
