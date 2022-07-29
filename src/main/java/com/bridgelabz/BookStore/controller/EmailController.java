/*
package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.ReasponseDTO;
import com.bridgelabz.BookStore.email.EmailService;
import com.bridgelabz.BookStore.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;

    */
/** Used to send mail
    * @Body: Email
    * @Return: message with id of receiver*//*


    @PostMapping("/sentemail")
    public ResponseEntity<ReasponseDTO> sendEmail(@RequestBody @Valid Email email){
        emailService.sendEmail(email);
        ReasponseDTO reasponseDTO = new ReasponseDTO("sent sucessfully", "to:" + email.getTo());
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }
}
*/
