package com.lucas.kafka.spring.engine;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
public class KafkaMessageTest {

    @TestConfiguration
    static class KafkaMessageTestConfiguration{

        @Bean
        public KafkaMessage kafkaMessage() {
            return new KafkaMessage();
        }
    }

    @Autowired
    KafkaMessage kafkaMessage;

    @Test
    public void kafkaMessageTestConstructor() {

        KafkaMessage instance = null;

        String token = UUID.randomUUID().toString();
        String message = "ABCDEFGHIJKLMNOPQRSTUVXWYZ0123456789";
        String topic = "KafkaEvent";

        instance = new KafkaMessage(message,topic,token);
        Assertions.assertNotEquals(instance, null);
    }

}
