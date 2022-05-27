package io.growtogether.com.kafkaproducer.service;

import io.growtogether.com.kafkaproducer.dto.MessageRequest;

public interface IKafkaPublisher {

    void publishMessage(String topic, String message);

    void publishMessageWithCallBack(String topic, String message);

    void publish(String topic, MessageRequest o);
}
