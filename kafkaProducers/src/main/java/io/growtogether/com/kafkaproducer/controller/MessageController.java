package io.growtogether.com.kafkaproducer.controller;


import io.growtogether.com.kafkaproducer.dto.MessageRequest;
import io.growtogether.com.kafkaproducer.service.KafkaPublisherService;
import io.growtogether.com.kafkaproducer.utils.TopicUtilsConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/poc/v1/messages")
public class MessageController {

    private final KafkaPublisherService kafkaPublisherService;

    @PostMapping
    public void publish(@RequestBody MessageRequest messageRequest) {
        this.kafkaPublisherService.publishMessage(TopicUtilsConstant.MESSAGE_TOPIC_NAME, messageRequest.getMessage());
    }

    @PostMapping("/user")
    public void publishUser(@RequestBody MessageRequest messageRequest) {
        this.kafkaPublisherService.publish(TopicUtilsConstant.USER_TOPIC_NAME, messageRequest);
    }

    @PostMapping(value = "/call-back")
    public void publishWithCallBack(@RequestBody MessageRequest messageRequest) {
        this.kafkaPublisherService.publishMessageWithCallBack("message", messageRequest.getMessage());
    }
}
