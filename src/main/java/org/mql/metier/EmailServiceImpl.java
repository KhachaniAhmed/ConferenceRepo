package org.mql.metier;

import org.mql.entities.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void setEmailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendSimpleMessage(Mail mail){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(mail.getTo());
//        message.setSubject(mail.getSubject());
//        message.setText(mail.getContent());
//        emailSender.send(message);
    }

    @Override
    public void sendSimpleMessageWithTemplate(Mail mail) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

//            helper.addAttachment("logo.png", new ClassPathResource("memorynotfound-logo.png"));

            Context context = new Context();
            context.setVariables(mail.getModel());
            String html = templateEngine.process("email-template", context);

            helper.setTo(mail.getTo());
            helper.setText(html, true);
            helper.setSubject(mail.getSubject());

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessageWithAttachment(Mail mail, String pathToAttachment) {

//        MimeMessage message = emailSender.createMimeMessage();
//
//        MimeMessageHelper helper = null;
//        try {
//            helper = new MimeMessageHelper(message, true);
//            helper.setTo(mail.getTo());
//            helper.setSubject(mail.getSubject());
//            helper.setText(mail.getContent());
//
//            FileSystemResource file
//                    = new FileSystemResource(new File(pathToAttachment));
//
//            System.out.println(file.getFilename() + "," + file.getDescription());
//            helper.addAttachment("Invoice", file);
//
//            emailSender.send(message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template, String... templateArgs) {

    }
}
