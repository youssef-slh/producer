package com.pulsar.project.producer.service;

import com.pulsar.project.producer.dto.User;
import com.pulsar.project.producer.enums.UserType;
import com.pulsar.project.producer.exception.PublishException;
import com.pulsar.project.producer.record.MessageRecord;
import lombok.RequiredArgsConstructor;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishMessageImpl implements PublishMessage {

    private final PulsarTemplate<MessageRecord> pulsarTemplate;
    private static final String TEST_REQUEST_TOPIC = "test-request-topic";

    @Override
    public String publish(User user) {
        user.setUserType(UserType.EMPLOYEE);
        MessageRecord messageRecordObj =new MessageRecord(123541L,user);
        MessageId send;
        try {
            send = this.pulsarTemplate.send(TEST_REQUEST_TOPIC, messageRecordObj);
        } catch (PulsarClientException e) {
            throw new PublishException(e.getMessage());
        }
        return String.format("message %s sent successfully",send);
    }
}
