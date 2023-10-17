package com.pulsar.project.producer.service;

import com.pulsar.project.producer.dto.User;

public interface PublishMessage {
    String publish(final User message);
}
