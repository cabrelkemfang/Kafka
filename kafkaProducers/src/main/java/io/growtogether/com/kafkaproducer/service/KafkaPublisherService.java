package io.growtogether.com.kafkaproducer.service;

import io.growtogether.com.kafkaproducer.dto.MessageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaPublisherService implements IKafkaPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, MessageRequest> userKafkaTemplate;

    @Override
    public void publishMessage(String topic, String message) {
        this.kafkaTemplate.send(topic, message);
    }

    @Override
    public void publish(String topic, MessageRequest o) {
        this.userKafkaTemplate.send(topic, o);
    }


    public void publishMessageWithCallBack(String topic, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Message [{}] delivered with offset {}", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.warn("Unable to deliver message [{}]. {}", message, ex.getMessage());
            }
        });
    }

}
