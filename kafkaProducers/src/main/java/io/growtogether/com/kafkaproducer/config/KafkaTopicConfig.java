package io.growtogether.com.kafkaproducer.config;


import io.growtogether.com.kafkaproducer.utils.TopicUtilsConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic messageKafkaTopic() {
        return TopicBuilder.name(TopicUtilsConstant.MESSAGE_TOPIC_NAME)
                .partitions(2)
                .replicas(2)
                .build();
    }

    @Bean
    public NewTopic kafkaTopic() {
        return TopicBuilder.name(TopicUtilsConstant.USER_TOPIC_NAME)
                .partitions(2)
                .replicas(2)
                .build();
    }
}
