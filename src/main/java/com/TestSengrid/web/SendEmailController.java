package com.TestSengrid.web;

import com.TestSengrid.domain.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SendEmailController {
    @Autowired
    private SendEmailService sendEmailService;

    public ResponseEntity sendEmail (@PathVariable("fromEmail") String fromEmail, @PathVariable("subject") String subject
                                     ,@PathVariable("emailTo") String emailTo){

        if (sendEmailService.sendEmail(fromEmail,subject,emailTo)){
            System.out.println("envio de correo exitoso");
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            System.out.println("no se Ha podido enciar el correo");
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
