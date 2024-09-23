package com.xavier;

import com.xavier.core.EmailRequest;
import com.xavier.core.cases.EmailServiceUseCase;
import com.xavier.resource.EmailSenderResource;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class EmailSenderResourceTest {

    @Mock
    private EmailServiceUseCase emailServiceUseCase;

    @InjectMocks
    private EmailSenderResource emailSenderResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendEmail() {
        EmailRequest emailRequest = new EmailRequest("test@example.com", "Test Subject", "Test Body");

        doNothing()
          .when(emailServiceUseCase)
          .sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());

        Response response = emailSenderResource.sendEmail(emailRequest);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        verify(emailServiceUseCase).sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());
    }
}