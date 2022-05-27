package io.growtogether.com.kafkaproducer.kafka;

import io.growtogether.com.kafkaproducer.dto.MessageRequest;
import io.growtogether.com.kafkaproducer.utils.TopicUtilsConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListeners {

    @KafkaListener(topics = TopicUtilsConstant.MESSAGE_TOPIC_NAME, groupId = TopicUtilsConstant.GROUP_ID)
    void listener(String data) {
        log.info("Listerner recivied , {} , data", data);
    }

    @KafkaListener(topics = TopicUtilsConstant.USER_TOPIC_NAME, groupId = TopicUtilsConstant.GROUP_ID, containerFactory = "userFactory")
    void listener(MessageRequest data) {
        log.info("Listerner recivied , {} , data", data);
    }

}
