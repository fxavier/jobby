package com.xavier.application;

import com.xavier.adapter.EmailSenderGateway;
import com.xavier.core.cases.EmailServiceUseCase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class EmailSenderService implements EmailServiceUseCase {

    @Inject
    private EmailSenderGateway emailSenderGateway;

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
