/*
package com.bridgelabz.BookStore.email;

import com.bridgelabz.BookStore.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

   */
/* * Used to set details
    * @Return: sent message
    * *//*


    public void sendEmail(Email email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("sukumar.kindia@gmail.com");
        simpleMailMessage.setTo(email.getTo());
        simpleMailMessage.setText(email.getMessage());
        simpleMailMessage.setSubject(email.getSubject());
        javaMailSender.send(simpleMailMessage);//mail sent
        System.out.println("Mail Sent Successfully...");
    }
}
*/
