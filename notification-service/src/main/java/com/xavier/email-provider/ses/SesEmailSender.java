package com.xavier.infrastructure.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.xavier.adapter.EmailSenderGateway;
import com.xavier.core.exceptions.EmailSendException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class SesEmailSender implements EmailSenderGateway {

    @Inject
    private AmazonSimpleEmailService amazonSimpleEmailService;

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
            .withSource("xavierfrancisco353@gmail.com")
            .withDestination(new Destination().withToAddresses(to))
            .withMessage(new Message()
                .withSubject(new Content(subject))
                .withBody(new Body().withText(new Content(body))));

        try {
            amazonSimpleEmailService.sendEmail(request);
        } catch (Exception e) {
            throw new EmailSendException("Failed to send email", e);
        }
    }
    
}
