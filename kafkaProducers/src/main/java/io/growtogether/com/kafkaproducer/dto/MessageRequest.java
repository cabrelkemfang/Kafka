package io.growtogether.com.kafkaproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest implements Serializable {
    private String message;
    private String data;
}
