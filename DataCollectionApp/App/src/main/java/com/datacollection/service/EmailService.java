package com.datacollection.service;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EmailService {

    public static void send(String to,String code)
            throws Exception{


        Properties props=new Properties();

        props.put("mail.smtp.auth","true");

        props.put("mail.smtp.starttls.enable","true");

        props.put("mail.smtp.host","smtp.gmail.com");

        props.put("mail.smtp.port","587");


        Session session=Session.getInstance(

                props,

                new Authenticator(){

                    protected PasswordAuthentication
                    getPasswordAuthentication(){

                        return new PasswordAuthentication(

                                "yourgmail@gmail.com",

                                "yourapppassword");

                    }

                });


        Message message=new MimeMessage(session);

        message.setFrom(
                new InternetAddress("yourgmail@gmail.com"));

        message.setRecipients(

                Message.RecipientType.TO,

                InternetAddress.parse(to));

        message.setSubject("Verification Code");

        message.setText("Your code: "+code);

        Transport.send(message);

    }

}
