package com.TestSengrid.domain.service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.imageio.IIOException;
import java.io.IOException;

@Service
public class SendEmailService {

    @Autowired
    private SendGridAPI sendGridAPI;

    public boolean sendEmail(String fromEmail, String subject, String emailTo) {
        Email from = new Email(fromEmail);
        Email to = new Email(emailTo);
        Content content = new Content("text/plain", "Test email with Spring");
        Mail mail = new Mail(from, subject, to, content);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGridAPI.api(request);
            System.out.println(response.getBody());
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();

            return false;
        }

    }


}



