package com.xavier.core.cases;

public interface EmailServiceUseCase {
    void sendEmail(String to, String subject, String body);
}
 