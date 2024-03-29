package com.aetotechs.mailSender.notification_service.service;

import com.aetotechs.mailSender.notification_service.Email.Email;
import com.aetotechs.mailSender.notification_service.Email.Emails;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSenderImpl javaMailSender;

    public EmailService(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public SimpleMailMessage send(Email email) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email.getTo());
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getBody());

        javaMailSender.send(simpleMailMessage);

        return simpleMailMessage;
    }

    public SimpleMailMessage sendMultiple(Emails emails){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emails.getTo());
        simpleMailMessage.setText(emails.getBody());
        simpleMailMessage.setSubject(emails.getSubject());

        javaMailSender.send(simpleMailMessage);

        return simpleMailMessage;
    }
}
