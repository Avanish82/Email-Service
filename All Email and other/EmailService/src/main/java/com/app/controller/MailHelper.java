package com.app.controller;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.app.entity.EmailDetails;
import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import com.microsoft.aad.msal4j.IConfidentialClientApplication;

import antlr.StringUtils;

@Component
public class MailHelper{ //implements EmailService{
   
	private String clientId="ab9e066a-c0fa-4523-88ca-91ee21c07bc2";
    private String clientSecret="Lwx8Q~Y6Cb_6FVyGYtOFTWEQ91rvAy_MLNCdza~6";
    private String scope="https://graph.microsoft.com/.default";
    private String authority="68b4cc51-3bd3-4486-b00f-f08d372ed098";
    		//"https://login.microsoftonline.com/java-tutorial/";
    		//+ "//e***a/";
    private String username="avanishas123@outlook.com";
    
//        private String clientId;
//        private String clientSecret;
//        private String scope;
//        private String authority;
//        private String username;

        
        private JavaMailSender emailSender;

        private IAuthenticationResult getToken() throws MalformedURLException {
            final IConfidentialClientApplication app = ConfidentialClientApplication.builder(
                    this.clientId, 
                    ClientCredentialFactory.createFromSecret(this.clientSecret))
                .authority(this.authority)
                .build();
            final ClientCredentialParameters parameters = ClientCredentialParameters.builder(
                    Collections.singleton(this.scope))
                .build();
            return app
                .acquireToken(parameters)
                .join();
        }

     //  public void send(final MimeMessage message) throws MessagingException {
         public String sendAzureMail(EmailDetails details) {
           // if (StringUtils.isNoneBlank(this.clientId, this.clientSecret, this.scope, this.authority)) {
        	 if(StringUtils.stripFrontBack(this.clientSecret, this.scope, this.authority) != null) {
                try {
                    final StringBuilder passwordBuilder = new StringBuilder();
                    passwordBuilder.append("user=").append(this.username)
                            .append('\u0001')
                            .append("auth=").append("Bearer ").append(getToken().accessToken())
                            .append('\u0001').append('\u0001');

                    final String base64Password = Base64.getEncoder().encodeToString(passwordBuilder.toString().getBytes(StandardCharsets.UTF_8));

                  //  ((JavaMailSenderImpl) this.emailSender).setPassword(base64Password);
                    // Creating a simple mail message
	                SimpleMailMessage mailMessage = new SimpleMailMessage();

	                // Setting up necessary details
//	                mailMessage.setFrom(sender);
	                mailMessage.setFrom("avanishas123@outlook.com");
	                mailMessage.setTo(details.getRecipient());
	                mailMessage.setCc(details.getCcList());
	                mailMessage.setBcc(details.getBccList());
	                mailMessage.setText(details.getMsgBody());
	                mailMessage.setSubject(details.getSubject());
	                emailSender.send(mailMessage);
                } catch (final MalformedURLException e) {
                   // throw new MessagingException("Impossible d'initialiser la connexion OAuth2", e);
                }
            }
           // String sendAzure =null;
			//this.emailSender.send(message);
//        	emailSender.send(mailMessage);
			return "hi";
        }

//	public String sendAzureMail(EmailDetails details) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
//		private void sendAzure(MimeMessage message) {
//			// public String sendSimpleMail(EmailDetails details)
//		        {
//
//		        	EmailDetails details =new EmailDetails();
//		            // Try block to check for exceptions
//		            try {
//		                // Creating a simple mail message
//		                SimpleMailMessage mailMessage = new SimpleMailMessage();
//
//		                // Setting up necessary details
////		                mailMessage.setFrom(sender);
//		                mailMessage.setFrom("avanishas123@outlook.com");
//		                mailMessage.setTo(details.getRecipient());
//		                mailMessage.setCc(details.getCcList());
//		                mailMessage.setBcc(details.getBccList());
//		                mailMessage.setText(details.getMsgBody());
//		                mailMessage.setSubject(details.getSubject());
//		                
//		                // Sending the mail
//		               // javaMailSender.send(mailMessage);
//		                this.emailSender.send(mailMessage);
//		                details.setEmailStatus("Send");
//		             //   emailRepo.save(details);
//		               // return "Mail Sent Successfully...";
//		            }
//
//		           //  Catch block to handle the exceptions
//		            catch (Exception e) {
//		           	 details.setEmailStatus("Failed");
//		               // emailRepo.save(details);
//		                 
//		              //  return "Error while Sending Mail";
//		            }
//		        }
//		}
//
//	 
//		@Override
//		public String sendSimpleMail(EmailDetails details) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public String sendMailWithAttachment(EmailDetails details) {
//			// TODO Auto-generated method stub
//			return null;
//		} 
//    }