package com.aetotechs.mailSender.Email;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class Mail implements MailSender {


    @Override
    public void send(SimpleMailMessage simpleMessage) throws MailException {

        simpleMessage.setFrom("mcaplexyac@gmail.com");
        simpleMessage.setTo("mcaplexya@gmail.com");
        simpleMessage.setSubject("noreply");

    }

    @Override
    public void send(SimpleMailMessage... simpleMessages) throws MailException {

    }
}
