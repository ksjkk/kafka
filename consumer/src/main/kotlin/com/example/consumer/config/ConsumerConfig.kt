package com.example.consumer.config

import com.example.core.util.KafkaConfig.Companion.BOOTSTRAP_SERVER
import com.example.core.util.KafkaConfig.Companion.DESERIALIZER
import com.example.core.util.KafkaConfig.Companion.GROUP_ID
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.apache.kafka.clients.consumer.ConsumerConfig as Config

@EnableKafka
@Configuration
class ConsumerConfig {

    @Bean
    fun kafkaListenerContainerFactory(/* kafkaProperties: KafkaProperties */): ConcurrentKafkaListenerContainerFactory<String, String> {
        val configMap = mapOf(
            Config.BOOTSTRAP_SERVERS_CONFIG to BOOTSTRAP_SERVER,
            Config.GROUP_ID_CONFIG to GROUP_ID,
            Config.KEY_DESERIALIZER_CLASS_CONFIG to DESERIALIZER,
            Config.VALUE_DESERIALIZER_CLASS_CONFIG to DESERIALIZER
        )

        return ConcurrentKafkaListenerContainerFactory<String, String>().also {
            it.consumerFactory = DefaultKafkaConsumerFactory(configMap) // kafkaProperties.buildConsumerProperties()
        }
    }
}