package com.example.producer.config

import com.example.core.util.KafkaConfig.Companion.BOOTSTRAP_SERVER
import com.example.core.util.KafkaConfig.Companion.SERIALIZER
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.apache.kafka.clients.producer.ProducerConfig as Config

@Configuration
@EnableKafka
class ProducerConfig {
    
    @Bean
    fun messageKafkaTemplate(/* kafkaProperties: KafkaProperties */): KafkaTemplate<String, String> {
        val configMap = mapOf(
            Config.BOOTSTRAP_SERVERS_CONFIG to BOOTSTRAP_SERVER,
            Config.KEY_SERIALIZER_CLASS_CONFIG to SERIALIZER,
            Config.VALUE_SERIALIZER_CLASS_CONFIG to SERIALIZER,
            Config.RETRIES_CONFIG to 1
        )

        return KafkaTemplate(DefaultKafkaProducerFactory(configMap))
    }
}