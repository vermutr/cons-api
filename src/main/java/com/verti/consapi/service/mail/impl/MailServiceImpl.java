package com.verti.consapi.service.mail.impl;

import com.verti.consapi.controller.dto.mail.MailMessage;
import com.verti.consapi.producer.ActiveMqProducer;
import com.verti.consapi.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final ActiveMqProducer activeMqProducer;


    @Override
    public void sendMailMessage(final MailMessage mailMessage) {
        activeMqProducer.sendMailMessage(mailMessage);
    }

}
