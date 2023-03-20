package com.app.service;

import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.entity.EmailDetails;
import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import com.microsoft.aad.msal4j.IConfidentialClientApplication;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.models.BodyType;
import com.microsoft.graph.models.EmailAddress;
import com.microsoft.graph.models.ItemBody;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.models.Recipient;
import com.microsoft.graph.models.UserSendMailParameterSet;
import com.microsoft.graph.requests.GraphServiceClient;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

@Service
public class AzureGraphEmailServiec {

//	 @Autowired 
//	 private JavaMailSender javaMailSender;

		private String clientId="08942e77-7f1c-4ee7-b0c8-33882039dcf1";
	    private String clientSecret="QAY8Q~TNvuHMO0pkS_x1lgrwBD0ilYNjVVG1-chc";
	    private String scope="https://graph.microsoft.com/.default";
	    private String tenantId="68b4cc51-3bd3-4486-b00f-f08d372ed098";
	    		//"https://login.microsoftonline.com/java-tutorial/";
	    		//+ "//e***a/";
	    private String username="avanishas123_outlook.com#EXT#@avanishas123outlook.onmicrosoft.com";
	    private String password="Avanish8285696415";
	    	        
	        
//	        public String sendSimpleMail(EmailDetails details) {
//	       // 	public void sendAzure(EmailDetails details) throws MessagingException {
//	        	    final ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
//	        	            .clientId(clientId)
//	        	            .clientSecret(clientSecret)
//	        	            .tenantId(tenantId)
//	        	            .build();
//	        	    /* Add user loging crediantial */
//	        	    final StringBuilder passwordBuilder = new StringBuilder();
//                    passwordBuilder.append("user=").append(this.username).append(this.password);
//                    /* end */
//	        	    final TokenCredentialAuthProvider tokenCredentialAuthProvider = new TokenCredentialAuthProvider(clientSecretCredential);
//
//	        	    final GraphServiceClient graphClient =
//	        	      (GraphServiceClient) GraphServiceClient
//	        	        .builder()
//	        	        .authenticationProvider(tokenCredentialAuthProvider)
//	        	        .buildClient();    
//	        	    
//                  Message message = new Message();
//                  message.subject =  details.getSubject();             //"Meet for lunch?";
//                  ItemBody body = new ItemBody();
//                  body.contentType = BodyType.TEXT;
//                  body.content =   details.getMsgBody();                                    //"The new cafeteria is open.";
//                  message.body = body;
//                 
//               //   Recipient toRecipientsList2 = new Recipient();
//                  Recipient toRecipients2 = new Recipient();
//                  EmailAddress emailAddress2 = new EmailAddress();
//                  emailAddress2.address = "avanishas123@outlook.com";
//                  toRecipients2.emailAddress = emailAddress2;
//               //   ((List<Recipient>) toRecipientsList2).add(toRecipients2);
//                  message.from = toRecipients2;
//                  
//                  LinkedList<Recipient> toRecipientsList = new LinkedList<Recipient>();
//                  Recipient toRecipients = new Recipient();
//                  EmailAddress emailAddress = new EmailAddress();
//                  emailAddress.address = details.getBccList();
//                  toRecipients.emailAddress = emailAddress;
//                  toRecipientsList.add(toRecipients);
//                  message.bccRecipients = toRecipientsList;
//                  
//                  LinkedList<Recipient> ccRecipientsList = new LinkedList<Recipient>();
//                  Recipient ccRecipients = new Recipient();
//                  EmailAddress emailAddress1 = new EmailAddress();
//                  emailAddress1.address =  details.getCcList();                                       //"danas@contoso.onmicrosoft.com";
//                  ccRecipients.emailAddress = emailAddress1;
//                  ccRecipientsList.add(ccRecipients);
//                  message.ccRecipients = ccRecipientsList;
//                  System.out.println(message);
//                  boolean saveToSentItems = false;
//                  
//                  graphClient.me()
//                  	.sendMail(UserSendMailParameterSet
//                  		.newBuilder()
//                  		.withMessage(message)
//                  		.withSaveToSentItems(saveToSentItems)
//                  		.build())
//                  	.buildRequest()
//                  	.post();
//				return clientId; 
//              }
//      	 }
           
	       
//////other way to try
////IConfidentialClientApplication confidentialClientApplication = ConfidentialClientApplicationBuilder
////.Create(clientId)
////.WithTenantId(tenantID)
////.WithClientSecret(clientSecret)
////.Build();
////
////ClientCredentialProvider authProvider = new ClientCredentialProvider(confidentialClientApplication);
////
//////prepare message and saveToSentItems here
////
////await graphClient.Users["{id or userPrincipalName}"]
////.SendMail(message,saveToSentItems)
////.Request()
////.PostAsync();
////    SimpleMailMessage mailMessage = new SimpleMailMessage();