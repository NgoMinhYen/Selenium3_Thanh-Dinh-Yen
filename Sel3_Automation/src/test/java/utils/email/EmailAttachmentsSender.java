package utils.email;

import java.io.IOException;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailAttachmentsSender {
    public static void sendEmailWithAttachments(String host, String port, final String username, final String password,
                                                String[] toAddress, String subject, String message, String... attachFiles) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        //create the Session object
        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            //create a MimeMessage object
            Message msg = new MimeMessage(session);
            //set From email field
            msg.setFrom(new InternetAddress(username));
            //set To email field
            InternetAddress[] addressTo = new InternetAddress[toAddress.length];
            for (int i = 0; i < toAddress.length; i++)
                addressTo[i] = new InternetAddress(toAddress[i]);
            msg.setRecipients(Message.RecipientType.TO, addressTo);

            //set email subject field
            msg.setSubject(subject);
            //set the content of the email message
            msg.setText(message);
            // creates message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(message, "text/html");

            // creates multi-part
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // adds attachments
            if (attachFiles != null && attachFiles.length > 0) {
                for (String filePath : attachFiles) {
                    MimeBodyPart attachPart = new MimeBodyPart();

                    try {
                        attachPart.attachFile(filePath);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    multipart.addBodyPart(attachPart);
                }
            }

            // sets the multi-part as e-mail's content
            msg.setContent(multipart);

            //send the email message
            Transport.send(msg);
            System.out.println("Email Message Sent Successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

