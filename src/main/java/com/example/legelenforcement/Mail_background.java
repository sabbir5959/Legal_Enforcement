//package com.example.legelenforcement;
//
//import javafx.concurrent.Task;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
//public class Mail_background extends Task<Void>
//{
//    private final String receiver;
//
//    public Mail_background(String receiver)
//    {
//        this.receiver = receiver;
//    }
//
//    @Override
//    protected Void call() throws MessagingException
//    {
//        String sender = "mistdecoders@gmail.com";
//        String receiver = this.receiver;
//        Forget_pass.code = (int)((Math.random()*100000000)%100000);
//        String message = String.valueOf(Forget_pass.code);
//        String subject = "Authentication code for MAT Bank";
//        String host = "smtp.gmail.com";
//
//        Properties properties = System.getProperties();
//
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port",587);
//        properties.put("mail.smtp.starttls.enable","true");
//        properties.put("mail.smtp.auth","true");
//
//        Session session = Session.getInstance(properties, new Authenticator()
//        {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication()
//            {
//                return new PasswordAuthentication(sender,"floxwxqikxyuxoei");
//            }
//        });
//
//        MimeMessage mimeMessage = new MimeMessage(session);
//        mimeMessage.setFrom(sender);
//        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
//        mimeMessage.setSubject(subject);
//        mimeMessage.setText(message);
//        Transport.send(mimeMessage);
//        return null;
//    }
//}