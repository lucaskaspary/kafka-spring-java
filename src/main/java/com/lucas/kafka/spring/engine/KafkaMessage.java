package com.lucas.kafka.spring.engine;

import java.util.Date;

public class KafkaMessage {
    private String message;
    private String topic;
    private String token;
    private Date born;

    public KafkaMessage(String message, String topic, String token) {
        this.message = message;
        this.topic = topic;
        this.token = token;
        born = new Date();
    }

    public KafkaMessage() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getBorn() {
        return born;
    }

}
