package com.verti.consapi.controller.mail;

import com.verti.consapi.controller.dto.mail.MailMessage;
import com.verti.consapi.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/send-email")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;


    @PostMapping
    public void sendMail(@RequestBody MailMessage mailMessage) {
        mailService.sendMailMessage(mailMessage);
    }

}
