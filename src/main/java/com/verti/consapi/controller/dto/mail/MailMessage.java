package com.verti.consapi.controller.dto.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailMessage implements Serializable {

    private String mailFrom;

    private String mailTo;

    private String offerTitle;

    private String offerDescription;

}
