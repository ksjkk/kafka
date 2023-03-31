package com.example.core.util

import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer

class KafkaConfig {
    companion object {
        const val BOOTSTRAP_SERVER = "localhost:9092"
        const val GROUP_ID = "TOPIC_GROUP"
        const val TOPIC = "TOPIC"
        val SERIALIZER = StringSerializer::class.java
        val DESERIALIZER = StringDeserializer::class.java
    }
}