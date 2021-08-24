package com.TestSengrid.domain.service;

import com.TestSengrid.domain.MailE;
import com.sendgrid.*;
import com.sendgrid.SendGridAPI;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.imageio.IIOException;
import java.io.IOException;

@Service
public class SendEmailService {

    private static final Logger logger = LoggerFactory.getLogger(SendEmailService.class);
    public String sendEmail(MailE mailE) throws IOException {
        Email from = new Email(mailE.getFromEmail());
        Email to = new Email(mailE.getFromEmail());
        Content content = new Content("text/plain", mailE.getContent());
        Mail  mail= new Mail(from, mailE.getSubject(), to, content);
//        SendGrid sendGrid = new SendGrid("sengrid.api.key");
        SendGrid sendGrid= new SendGrid(System.getenv("SENGRID_API_KEY"));
        Request request = new Request();
        System.out.println("ya lei las variables");
        System.out.println(mailE.toString());
        System.out.println(System.getenv("SENGRID_API_KEY"));

        try {
            System.out.println("enviando correo");
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            logger.info(response.getBody());
            return response.getBody();
        } catch (IOException ex) {
            throw ex;
        }

    }


}



