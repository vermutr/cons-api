package com.verti.consapi.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verti.consapi.controller.dto.mail.MailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActiveMqProducer {

    @Value("${activemq.mail.queue}")
    private String mailQueue;

    private final JmsTemplate jmsTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();


    public void sendMailMessage(final MailMessage mailMessage) {
        String jsonString;
        try {
            jsonString = objectMapper.writeValueAsString(mailMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        jmsTemplate.convertAndSend(mailQueue, jsonString);
    }

}
