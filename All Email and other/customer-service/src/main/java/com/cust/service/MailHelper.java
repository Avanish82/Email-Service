package com.cust.service;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender; 
import org.springframework.stereotype.Component;

import com.cust.dto.EmailDetails;
import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import com.microsoft.aad.msal4j.IConfidentialClientApplication;

import antlr.StringUtils;

@Component
public class MailHelper{ //implements EmailService{
   
	private String clientId="08942e77-7f1c-4ee7-b0c8-33882039dcf1";
    private String clientSecret="QAY8Q~TNvuHMO0pkS_x1lgrwBD0ilYNjVVG1-chc";
    private String scope="https://graph.microsoft.com/.default";
    private String authority="https://login.microsoftonline.com/68b4cc51-3bd3-4486-b00f-f08d372ed098/";
    		//+ "//e***a/";
   // "https://sts.windows.net/68b4cc51-3bd3-4486-b00f-f08d372ed098";
    private String username="avanishas123_outlook.com#EXT#@avanishas123outlook.onmicrosoft.com";
    		//"avanishas123@outlook.com";
    private String password="Avanish8285696415";
    
    @Autowired(required=true)
    JavaMailSender emailSender;

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

      // public void send(final MimeMessage message) throws MessagingException {
    	   public void sendAzure(EmailDetails details) {
         // if (StringUtils.isNoneBlank(this.clientId, this.clientSecret, this.scope, this.authority)) {
        	 if(StringUtils.stripFrontBack(this.clientSecret, this.scope, this.authority) != null) {
                try {
                    final StringBuilder passwordBuilder = new StringBuilder();
                    passwordBuilder.append("user=").append(this.username).append(this.password)
                            .append('\u0001')
                            .append("auth=").append("Bearer ").append(getToken().accessToken());
                            //.append('\u0001').append('\u0001');

                    final String base64Password = Base64.getEncoder().encodeToString(passwordBuilder.toString().getBytes(StandardCharsets.UTF_8));

                   // ((JavaMailSenderImpl) this.emailSender).setPassword(base64Password);
                    // Creating a simple mail message
	                SimpleMailMessage mailMessage = new SimpleMailMessage();

	                // Setting up necessary details
	            //    mailMessage.setFrom(sender);
	                mailMessage.setFrom("avanishas123@outlook.com");
	                mailMessage.setTo(details.getRecipient());
	                mailMessage.setCc(details.getCcList());
	                mailMessage.setBcc(details.getBccList());
	                mailMessage.setText(details.getMsgBody());
	                mailMessage.setSubject(details.getSubject());
	                emailSender.send(mailMessage);
	                System.out.println("Email Send Successfuly");
                } catch (final MalformedURLException e) {
                   // throw new MessagingException("Impossible d'initialiser la connexion OAuth2", e);
                }
            }
           // String sendAzure =null;
			//this.emailSender.send(message);
//        	emailSender.send(mailMessage);
        	 sendAzure(details);
        }

		 

//		public void sendAzure(EmailDetails details) {
//			// public String sendSimpleMail(EmailDetails details)
//		        {
//
//		        	//EmailDetails details =new EmailDetails();
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
//		                emailSender.send(mailMessage);
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
//		   }
		}


//private String clientId;
//private String clientSecret;
//private String scope;
//private String authority;
//private String username;