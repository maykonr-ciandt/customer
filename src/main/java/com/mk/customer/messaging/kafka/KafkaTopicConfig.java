package com.mk.customer.messaging.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@Configuration
public class KafkaTopicConfig {

    private final String bootstrapAddress;

    public KafkaTopicConfig(@Value(value = "${spring.kafka.bootstrap-servers}") final String bootstrapAddress) {
        this.bootstrapAddress = bootstrapAddress;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        final HashMap<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic customerCustomersTopic() {
        return TopicBuilder
                .name("customer_customers")
                .replicas(3)
                .partitions(3)
                .build();
    }

    @Bean
    public NewTopic customerLeadsTopic() {
        return TopicBuilder
                .name("customer_leads")
                .replicas(3)
                .partitions(3)
                .build();
    }
}
