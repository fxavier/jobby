package com.xavier.adapter;

public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);
}
