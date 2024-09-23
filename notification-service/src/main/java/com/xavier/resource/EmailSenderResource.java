package com.xavier.resource;

import com.xavier.core.EmailRequest;
import com.xavier.core.cases.EmailServiceUseCase;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/email")
public class EmailSenderResource {

    @Inject
    private EmailServiceUseCase emailServiceUseCase;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendEmail(EmailRequest emailRequest) {
        emailServiceUseCase.sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());
        return Response.status(Response.Status.OK).build();
    }
}
