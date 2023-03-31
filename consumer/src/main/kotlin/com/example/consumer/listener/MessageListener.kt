package com.example.consumer.listener

import com.example.core.model.SimplePayload
import com.example.core.util.KafkaConfig.Companion.TOPIC
import com.example.core.util.logger
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import java.util.*

@Component
class MessageListener(
    private val objectMapper: ObjectMapper
) {
    private val log = logger()
    
    @KafkaListener(topics = [TOPIC], concurrency = "3")
    fun listener(@Payload messagePayloadObject: String,
                 @Header(KafkaHeaders.OFFSET) offset: Long) {
        
        log.info("messagePayloadObject : {}", messagePayloadObject)
        val payload = objectMapper.readValue(messagePayloadObject, SimplePayload::class.java)
        log.info("payload value : {}", payload.value)
        log.info("offset : {}", offset)
    }
}