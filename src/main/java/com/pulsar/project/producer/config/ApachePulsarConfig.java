package com.pulsar.project.producer.config;

import com.pulsar.project.producer.record.MessageRecord;
import lombok.RequiredArgsConstructor;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.pulsar.core.*;

@Configuration
@RequiredArgsConstructor
public class ApachePulsarConfig {

    @Bean
    public SchemaResolver.SchemaResolverCustomizer<DefaultSchemaResolver> schemaResolverCustomizer() {
        return (schemaResolver) -> {
            schemaResolver.addCustomSchemaMapping(MessageRecord.class, Schema.JSON(MessageRecord.class));
        };
    }

}
