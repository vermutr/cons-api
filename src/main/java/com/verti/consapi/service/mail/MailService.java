package com.verti.consapi.service.mail;

import com.verti.consapi.controller.dto.mail.MailMessage;

public interface MailService {

    void sendMailMessage(final MailMessage mailMessage);

}
