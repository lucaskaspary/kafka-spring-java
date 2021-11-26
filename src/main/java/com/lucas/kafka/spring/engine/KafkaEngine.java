package com.lucas.kafka.spring.engine;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

public class KafkaEngine {

    public enum KafkaEngineType {
        PRODUCER,
        CONSUMER,
        PRODUCER_AND_CONSUMER
    }

    private KafkaEngineType engineType;

    private KafkaConsumer<String,String> consumer;
    private Producer<String, String> producer;
    private String serverAddress;

    public KafkaEngine(KafkaEngineType engineType, String serverAddress) {
        this.engineType = engineType;
        this.serverAddress = serverAddress;

        switch (engineType) {
            case CONSUMER:
                createConsumer();
                break;
            case PRODUCER:
                createProducer();
                break;
            case PRODUCER_AND_CONSUMER:
                createConsumer();
                createProducer();
                break;
        }
    }

    private void createConsumer() {
        Properties properties = new Properties();

        //Local bootstrap server
        properties.put("bootstrap.servers", serverAddress);

        //Key deserializer
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //Value deserializer
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        //GroupID: number of consumers that receives the same message (default)
        properties.put("group.id", "default");

        consumer =  new KafkaConsumer<String, String>(properties);
    }

    private void createProducer() {
        Properties properties = new Properties();

        //Local bootstrap server
        properties.put("bootstrap.servers", serverAddress);

        //Key serializer
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //Value serializer
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //Class serializer
        properties.put("serializer.class", "kafka.serializer.DefaultEncoder");

        //Instantiate kafka producer
        producer = new KafkaProducer<String, String>(properties);
    }



    public void execute() {

    }


}
