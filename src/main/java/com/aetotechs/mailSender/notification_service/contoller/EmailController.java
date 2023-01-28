package com.aetotechs.mailSender.notification_service.contoller;

import com.aetotechs.mailSender.notification_service.Email.Email;
import com.aetotechs.mailSender.notification_service.Email.Emails;
import com.aetotechs.mailSender.notification_service.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/notice")
    public ResponseEntity sendEmail(@RequestBody Email email){
        if(email != null ) return ResponseEntity.ok(emailService.send(email));

        return null;
    }

    @PostMapping("/alerts")
    public ResponseEntity sendEmails(@RequestBody Emails emails){
        if(emails != null ) return ResponseEntity.ok(emailService.sendMultiple(emails));

        return null;
    }


}
