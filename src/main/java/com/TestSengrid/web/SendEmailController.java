package com.TestSengrid.web;

import com.TestSengrid.domain.MailE;
import com.TestSengrid.domain.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/send")
public class SendEmailController {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/new")
    public ResponseEntity sendEmail(@RequestBody MailE mailE) throws IOException{
        return new ResponseEntity(sendEmailService.sendEmail(mailE),HttpStatus.OK);

    }


}
