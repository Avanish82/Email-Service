package com.cust.service;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.security.AuthProvider;
import java.util.Base64;
import java.util.Collections;
import java.util.LinkedList;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender; 
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.cust.dto.EmailDetails;
import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import com.microsoft.aad.msal4j.IConfidentialClientApplication;
import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.models.BodyType;
import com.microsoft.graph.models.EmailAddress;
import com.microsoft.graph.models.ItemBody;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.models.Recipient;
import com.microsoft.graph.models.UserSendMailParameterSet; 
import com.microsoft.graph.requests.GraphServiceClient;

import antlr.StringUtils;

//@Component
@Service
public class MailHelper{ //implements EmailService{
   
	//private static final IAuthenticationProvider IAuthenticationResult = null;
	private String clientId="08942e77-7f1c-4ee7-b0c8-33882039dcf1";
    private String clientSecret="QAY8Q~TNvuHMO0pkS_x1lgrwBD0ilYNjVVG1-chc";
    private String scope="https://graph.microsoft.com/.default";
    private String authority="https://login.microsoftonline.com/68b4cc51-3bd3-4486-b00f-f08d372ed098/";
    		//+ "//e***a/";
   // "https://sts.windows.net/68b4cc51-3bd3-4486-b00f-f08d372ed098";
    private String username="avanishas123_outlook.com#EXT#@avanishas123outlook.onmicrosoft.com";
    		//"avanishas123@outlook.com";
    private String password="Avanish8285696415";
    private IConfidentialClientApplication app;
 
        private IAuthenticationResult getToken() throws MalformedURLException {
                 app= ConfidentialClientApplication.builder(
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
		public void sendAzure(EmailDetails details) throws MalformedURLException {
         // if (StringUtils.isNoneBlank(this.clientId, this.clientSecret, this.scope, this.authority)) {
        	 if(StringUtils.stripFrontBack(this.clientSecret, this.scope, this.authority) != null) {
                //try {
                    final StringBuilder passwordBuilder = new StringBuilder();
                    passwordBuilder.append("user=").append(this.username).append(this.password)
                            .append('\u0001')
                            .append("auth=").append("Bearer ").append(getToken().accessToken())
                            .append('\u0001').append('\u0001');

                    final String base64Password = Base64.getEncoder().encodeToString(passwordBuilder.toString().getBytes(StandardCharsets.UTF_8));

 
                    
                  //  ((JavaMailSenderImpl) this.javaMailSender).setPassword(base64Password);
                   //  Creating a simple mail message
//                    final ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
//                            .clientId(clientId)
//                            .clientSecret(clientSecret)
//                            .tenantId(authority)
//                            .build();

                   final TokenCredentialAuthProvider tokenCredentialAuthProvider = TokenCredentialAuthProvider(app);

                    final GraphServiceClient graphClient =
                      (GraphServiceClient) GraphServiceClient
                        .builder()
                        .authenticationProvider(tokenCredentialAuthProvider)
                        .buildClient(); 
                       
                    	        	    
                                      Message message = new Message();
                                      message.subject =  details.getSubject();             //"Meet for lunch?";
                                      ItemBody body = new ItemBody();
                                      body.contentType = BodyType.TEXT;
                                      body.content =   details.getMsgBody();                                    //"The new cafeteria is open.";
                                      message.body = body;
                                     
                                   //   Recipient toRecipientsList2 = new Recipient();
                                      Recipient toRecipients2 = new Recipient();
                                      EmailAddress emailAddress2 = new EmailAddress();
                                      emailAddress2.address = "avanishas123@outlook.com";
                                      toRecipients2.emailAddress = emailAddress2;
                                   //   ((List<Recipient>) toRecipientsList2).add(toRecipients2);
                                      message.from = toRecipients2;
                                      
                                      LinkedList<Recipient> toRecipientsList = new LinkedList<Recipient>();
                                      Recipient toRecipients = new Recipient();
                                      EmailAddress emailAddress = new EmailAddress();
                                      emailAddress.address = details.getBccList();
                                      toRecipients.emailAddress = emailAddress;
                                      toRecipientsList.add(toRecipients);
                                      message.bccRecipients = toRecipientsList;
                                      
                                      LinkedList<Recipient> ccRecipientsList = new LinkedList<Recipient>();
                                      Recipient ccRecipients = new Recipient();
                                      EmailAddress emailAddress1 = new EmailAddress();
                                      emailAddress1.address =  details.getCcList();                                       //"danas@contoso.onmicrosoft.com";
                                      ccRecipients.emailAddress = emailAddress1;
                                      ccRecipientsList.add(ccRecipients);
                                      message.ccRecipients = ccRecipientsList;
                                      System.out.println(message);
                                      boolean saveToSentItems = false;
                                      
                                      graphClient.me()
                                      	.sendMail(UserSendMailParameterSet
                                      		.newBuilder()
                                      		.withMessage(message)
                                      		.withSaveToSentItems(saveToSentItems)
                                      		.build())
                                      	.buildRequest()
                                      	.post();
                    				//return clientId; 
                }
                
        	 }

	private TokenCredentialAuthProvider TokenCredentialAuthProvider(IConfidentialClientApplication app2) {
		// TODO Auto-generated method stub
		return null;
	}

 
		 
}
                          	 
    	  
    	   
                    
                   // MimeMessage mailMessag=new MimeMessage(null);
//                    SimpleMailMessage mailMessage = new SimpleMailMessage();
//	               // Message message = new Message();
//	                // Setting up necessary details
//	            //    mailMessage.setFrom(sender);
//	                mailMessage.setFrom("avanishas123@outlook.com");
//	                mailMessage.setTo(details.getRecipient());
//	                mailMessage.setCc(details.getCcList());
//	                mailMessage.setBcc(details.getBccList());
//	                mailMessage.setText(details.getMsgBody());
//	                mailMessage.setSubject(details.getSubject());
//	                javaMailSender.send(mailMessage);
	                
	             
//                }catch(NullPointerException e) {
//	                	System.out.println("Handle null="+e);
//	                	 //javaMailSender.send(mailMessage);
//	                }
//                
//                
//	                System.out.println("Email Send Successfuly");
               // } catch (final MalformedURLException e) {
                   // throw new MessagingException("Impossible d'initialiser la connexion OAuth2", e);
              //  }
         //   }
           // String sendAzure =null;
			//this.emailSender.send(message);
//        	emailSender.send(mailMessage);
        //	 sendAzure(details);
    	   
       // }
//}

/**
 * public void sendAzure(EmailDetails details) throws MessagingException {
    final ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
            .clientId(clientId)
            .clientSecret(clientSecret)
            .tenantId(tenantId)
            .build();

    final TokenCredentialAuthProvider tokenCredentialAuthProvider = new TokenCredentialAuthProvider(clientSecretCredential);

    final GraphServiceClient graphClient =
      (GraphServiceClient) GraphServiceClient
        .builder()
        .authenticationProvider(tokenCredentialAuthProvider)
        .buildClient();     
                    
                  //  ((JavaMailSenderImpl) this.javaMailSender).setPassword(base64Password);
                   //  Creating a simple mail message
                   // MimeMessage mailMessag=new MimeMessage(null);
                Message mailMessage = new Message();
	               // Message message = new Message();
	                // Setting up necessary details
	            //    mailMessage.setFrom(sender);
	              //  if(mailMessage!=null) {
                mailMessage.from
	            mailMessage.setFrom("avanishas123@outlook.com");
                mailMessage.setTo(details.getRecipient());
                mailMessage.setCc(details.getCcList());
                mailMessage.setBcc(details.getBccList());
                mailMessage.setText(details.getMsgBody());
                mailMessage.setSubject(details.getSubject());
	               // javaMailSender.send(mailMessage);
	               graphClient.me()
	              .sendMail(UserSendMailParameterSet
	                  .newBuilder()
	                  .withMessage(mailMessage)
	                 // .withMessage(mailMessage)
	                  .withSaveToSentItems(null)
	                  .build())
	              .buildRequest()
	              .post();    
	                }
 */

/**
 *     MimeMessage message = new MimeMessage(message);
	                // Setting up necessary details
	            //    mailMessage.setFrom(sender);.
	               
	              message.subject =  details.getSubject();             //"Meet for lunch?";
                  ItemBody body = new ItemBody();
                  body.contentType = BodyType.TEXT;
                  body.content =   details.getMsgBody();                                    //"The new cafeteria is open.";
                  message.body = body;
                  LinkedList<Recipient> toRecipientsList = new LinkedList<Recipient>();
                  Recipient toRecipients = new Recipient();
                  EmailAddress emailAddress = new EmailAddress();
                  emailAddress.address = "avanishas123@outlook.com";
                  toRecipients.emailAddress = emailAddress;
                  toRecipientsList.add(toRecipients);
                  message.toRecipients = toRecipientsList;
                  LinkedList<Recipient> ccRecipientsList = new LinkedList<Recipient>();
                  Recipient ccRecipients = new Recipient();
                  EmailAddress emailAddress1 = new EmailAddress();
                  emailAddress1.address =  details.getCcList();                                       //"danas@contoso.onmicrosoft.com";
                  ccRecipients.emailAddress = emailAddress1;
                  ccRecipientsList.add(ccRecipients);
                  message.ccRecipients = ccRecipientsList;
                  LinkedList<Recipient> bccRecipientsList = new LinkedList<Recipient>();
                  Recipient bccRecipients = new Recipient();
                  EmailAddress emailAddress2 = new EmailAddress();
                  emailAddress1.address =  details.getBccList();                                       //"danas@contoso.onmicrosoft.com";
                  bccRecipients.emailAddress = emailAddress2;
                  ccRecipientsList.add(bccRecipients);
                  message.ccRecipients = bccRecipientsList;
                  boolean saveToSentItems = false; 
//	                mailMessage.setFrom("avanishas123@outlook.com");
//	                mailMessage.setTo(details.getRecipient());
//	                mailMessage.setCc(details.getCcList());
//	                mailMessage.setBcc(details.getBccList());
//	                mailMessage.setText(details.getMsgBody());
//	                mailMessage.setSubject(details.getSubject());
	                javaMailSender.send(message);
//            		.newBuilder()
//            		.withMessage(message)
//            		.withSaveToSentItems(saveToSentItems)
//          		.build())
//            	.buildRequest()
//            	.post(); 
	                System.out.println("Email Send Successfuly");
                } catch (final MalformedURLException e) {
                   // throw new MessagingException("Impossible d'initialiser la connexion OAuth2", e);
                }
            }
 */
                   
//                    IAuthenticationProvider AuthProvider = null;
//					GraphServiceClient graphClient = GraphServiceClient.builder().authenticationProvider(AuthProvider).buildClient();
//                    		//authenticationProvider(AuthProvider).buildClient();
//                    
//                    Message message = new Message();
//                    message.subject =  details.getSubject();             //"Meet for lunch?";
//                    ItemBody body = new ItemBody();
//                    body.contentType = BodyType.TEXT;
//                    body.content =   details.getMsgBody();                                    //"The new cafeteria is open.";
//                    message.body = body;
//                    LinkedList<Recipient> toRecipientsList = new LinkedList<Recipient>();
//                    Recipient toRecipients = new Recipient();
//                    EmailAddress emailAddress = new EmailAddress();
//                    emailAddress.address = "avanishas123@outlook.com";
//                    toRecipients.emailAddress = emailAddress;
//                    toRecipientsList.add(toRecipients);
//                    message.toRecipients = toRecipientsList;
//                    LinkedList<Recipient> ccRecipientsList = new LinkedList<Recipient>();
//                    Recipient ccRecipients = new Recipient();
//                    EmailAddress emailAddress1 = new EmailAddress();
//                    emailAddress1.address =  details.getCcList();                                       //"danas@contoso.onmicrosoft.com";
//                    ccRecipients.emailAddress = emailAddress1;
//                    ccRecipientsList.add(ccRecipients);
//                    message.ccRecipients = ccRecipientsList;
//
//                    boolean saveToSentItems = false;
//                    
//                    graphClient.me()
//                    	.sendMail(UserSendMailParameterSet
//                    		.newBuilder()
//                    		.withMessage(message)
//                    		.withSaveToSentItems(saveToSentItems)
//                    		.build())
//                    	.buildRequest()
//                    	.post(); 
//                }
//        	 }
//}
    	 
//
////		public void sendAzure(EmailDetails details) {
////			// public String sendSimpleMail(EmailDetails details)
////		        {
////
////		        	//EmailDetails details =new EmailDetails();
////		            // Try block to check for exceptions
////		            try {
////		                // Creating a simple mail message
////		                SimpleMailMessage mailMessage = new SimpleMailMessage();
////
////		                // Setting up necessary details
//////		                mailMessage.setFrom(sender);
////		                mailMessage.setFrom("avanishas123@outlook.com");
////		                mailMessage.setTo(details.getRecipient());
////		                mailMessage.setCc(details.getCcList());
////		                mailMessage.setBcc(details.getBccList());
////		                mailMessage.setText(details.getMsgBody());
////		                mailMessage.setSubject(details.getSubject());
////		                
////		                // Sending the mail
////		               // javaMailSender.send(mailMessage);
////		                emailSender.send(mailMessage);
////		                details.setEmailStatus("Send");
////		             //   emailRepo.save(details);
////		               // return "Mail Sent Successfully...";
////		            }
////
////		           //  Catch block to handle the exceptions
////		            catch (Exception e) {
////		           	 details.setEmailStatus("Failed");
////		               // emailRepo.save(details);
////		                 
////		              //  return "Error while Sending Mail";
////		            }
////		        }
////		   }
//		}
//
//
////private String clientId;
////private String clientSecret;
////private String scope;
////private String authority;
////private String username;