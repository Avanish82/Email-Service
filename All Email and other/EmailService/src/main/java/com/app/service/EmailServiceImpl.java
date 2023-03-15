package com.app.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.entity.EmailDetails;
import com.app.repository.EmailRepository; 

//Annotation
@Service
//Class
//Implementing EmailService interface
public class EmailServiceImpl { //implements EmailService {

 @Autowired 
 private JavaMailSender javaMailSender;

 @Value("${spring.mail.username}") 
 private String sender;

 @Autowired
 private EmailRepository emailRepo;
 // Method 1
 // To send a simple email
 public String sendSimpleMail(EmailDetails details)
 {

     // Try block to check for exceptions
     try {
         // Creating a simple mail message
         SimpleMailMessage mailMessage = new SimpleMailMessage();

         // Setting up necessary details
         mailMessage.setFrom(sender);
         mailMessage.setTo(details.getRecipient());
         mailMessage.setCc(details.getCcList());
        // mailMessage.setBcc(details.getBccList());
         mailMessage.setText(details.getMsgBody());
         mailMessage.setSubject(details.getSubject());
         
         // Sending the mail
         javaMailSender.send(mailMessage);
         details.setEmailStatus("Send");
         emailRepo.save(details);
         return "Mail Sent Successfully...";
     }

    //  Catch block to handle the exceptions
     catch (Exception e) {
    	 details.setEmailStatus("Failed");
         emailRepo.save(details);
          
         return "Error while Sending Mail";
     }
 }

 // Method 2
 // To send an email with attachment
 public String sendMailWithAttachment(EmailDetails details)
 {
     // Creating a mime message
     MimeMessage mimeMessage = javaMailSender.createMimeMessage();
     MimeMessageHelper mimeMessageHelper;

     try {

         // Setting multipart as true for attachments to
         // be send
         mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
         mimeMessageHelper.setFrom(sender);
         mimeMessageHelper.setTo(details.getRecipient());
         mimeMessageHelper.setCc(details.getCcList());
         mimeMessageHelper.setBcc(details.getBccList());
         mimeMessageHelper.setText(details.getMsgBody());
         mimeMessageHelper.setSubject(details.getSubject());

         // Adding the attachment
         FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));

         mimeMessageHelper.addAttachment(
             file.getFilename(), file);

         // Sending the mail
         javaMailSender.send(mimeMessage);
         details.setEmailStatus("Send");
         emailRepo.save(details);
         return "Mail sent Successfully";
     }

     // Catch block to handle MessagingException
     catch (MessagingException e) {
    	 details.setEmailStatus("Failed");
         emailRepo.save(details);
         // Display message when exception occurred
         return "Error while sending mail!!!";
     }
 }
// public String sendAzureMail(EmailDetails details){
//	
//	// String endpoint = "https://<resource-name>.communication.azure.com";
//	 String endpoint ="https://portal.azure.com/#home.communication.azure.com";
//	 AzureKeyCredential azureKeyCredential = new AzureKeyCredential("<access-key>");
//
//	 EmailClient emailClient = new EmailClientBuilder()
//	     .endpoint(endpoint)
//	     .credential(azureKeyCredential)
//	     .buildClient();
//	 
////	 EmailMessage message = new EmailMessage(endpoint, null)
////			    .setSenderAddress("<sender-email-address>")
////			    .setToRecipients("<recipient-email-address>")
////			    .setSubject("test subject")
////			    .setBodyPlainText("test message");
////
////			SyncPoller<EmailSendResult, EmailSendResult> poller = emailClient.beginSend(message, null);
////			PollResponse<EmailSendResult> response = poller.waitForCompletion();
////
////			System.out.println("Operation Id: " + response.getValue().getId());
//	 return sender;
// 
// }

//@Override
//public String sendAzureMail(EmailDetails details) {
//	// TODO Auto-generated method stub
//	return null;
//}

 
}
