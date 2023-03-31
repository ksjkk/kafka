package com.example.producer.sender

import com.example.core.model.SimplePayload
import com.example.core.util.KafkaConfig.Companion.TOPIC
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("send")
class SendController(
    private val messageKafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {
    
    @PostMapping("/value/{value}")
    fun sendTest(@PathVariable value: String) {
        messageKafkaTemplate.send(TOPIC, objectMapper.writeValueAsString(SimplePayload("value test")))
    }
}