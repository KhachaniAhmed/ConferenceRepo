package org.mql.metier;

import org.mql.entities.Mail;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendSimpleMessage(Mail mail);
    void sendSimpleMessageWithTemplate(Mail mail);
    void sendSimpleMessageUsingTemplate(String to,
                                        String subject,
                                        SimpleMailMessage template,
                                        String... templateArgs);
    void sendMessageWithAttachment(Mail mail,
                                   String pathToAttachment);
}
