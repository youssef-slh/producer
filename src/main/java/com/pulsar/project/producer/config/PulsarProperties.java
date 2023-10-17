package com.pulsar.project.producer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pulsar.client")
@Data
public class PulsarProperties {
    private String serviceUrl;
}
