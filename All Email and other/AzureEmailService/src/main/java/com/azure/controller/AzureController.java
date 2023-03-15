package com.azure.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
 

import com.microsoft.aad.msal4j.IAuthenticationResult;
import com.microsoft.aad.msal4j.PublicClientApplication;
import com.microsoft.aad.msal4j.UserNamePasswordParameters;
import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.http.IHttpRequest;
import com.microsoft.graph.models.extensions.EmailAddress;
import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.models.extensions.ItemBody;
import com.microsoft.graph.models.extensions.Message;
import com.microsoft.graph.models.extensions.Recipient;
import com.microsoft.graph.models.generated.BodyType;
import com.microsoft.graph.requests.extensions.GraphServiceClient;

//public class MicrosoftGraphMailer {
public class AzureController{

    private final static String CLIENT_APP_ID = "{08942e77-7f1c-4ee7-b0c8-33882039dcf1}";
    private final static String AUTHORITY = "https://login.microsoftonline.com/{68b4cc51-3bd3-4486-b00f-f08d372ed098}/";

  //  public static void main(String[] args) throws Exception {
    public void sendMailL(EmailDetails emailDetails) throws Exception  {
		// TODO Auto-generated method stub
		
	
        String user = "{avanishas123_outlook.com#EXT#@avanishas123outlook.onmicrosoft.com}";
        String password = "{Avanish8285696415}";

        String token = getUserPasswordAccessToken(user, password).accessToken();
        System.out.println(token);

        SimpleAuthProvider authProvider = new SimpleAuthProvider(token);
        IGraphServiceClient graphClient = GraphServiceClient.builder().authenticationProvider(authProvider).buildClient();

        Message message = new Message();
        message.subject = "My subject";

        ItemBody body = new ItemBody();
        body.contentType = BodyType.HTML;
        body.content = "<h1>My HTML body</h1>";
        message.body = body;

        List<Recipient> toRecipientList = new LinkedList<>();
        Recipient toRecipient = new Recipient();
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.address = emailDetails.getRecipient(); //"{real-recipient}";
        toRecipient.emailAddress = emailAddress;
        toRecipientList.add(toRecipient);
        message.toRecipients = toRecipientList;
        
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom("avanishas123@outlook.com");
//        mailMessage.setTo(details.getRecipient());
//        mailMessage.setCc(details.getCcList());
//        mailMessage.setBcc(details.getBccList());
//        mailMessage.setText(details.getMsgBody());
//        mailMessage.setSubject(details.getSubject());

        graphClient.me()
                .sendMail(message, false)
                .buildRequest()
                .post();

/*
         String mail = graphClient.me()
                .buildRequest()
                .get().mail;

         System.out.println(mail);
*/
    }

    private static IAuthenticationResult getUserPasswordAccessToken(String user, String password) throws Exception {

        PublicClientApplication app = PublicClientApplication.builder(CLIENT_APP_ID).authority(AUTHORITY).build();

        Set<String> scopes = new HashSet<>(Arrays.asList("Mail.Send"));

        UserNamePasswordParameters userNamePasswordParam = UserNamePasswordParameters.builder(
                scopes, user, password.toCharArray())
                .build();

        return app.acquireToken(userNamePasswordParam).get();
    }

    private static class SimpleAuthProvider implements IAuthenticationProvider {

        private String accessToken = null;

        public SimpleAuthProvider(String accessToken) {
            this.accessToken = accessToken;
        }

        @Override
        public void authenticateRequest(IHttpRequest request) {
            request.addHeader("Authorization", "Bearer " + accessToken);
        }

    }
}

////Backup file
////public class MicrosoftGraphMailer {
//public class AzureController{
//
//  private final static String CLIENT_APP_ID = "{real-client-app-id}";
//  private final static String AUTHORITY = "https://login.microsoftonline.com/{real-tenant-id}/";
//
////  public static void main(String[] args) throws Exception {
//  public void sendMailL(EmailDetails emailDetails) throws Exception  {
//		// TODO Auto-generated method stub
//		
//	
//      String user = "{real-user}";
//      String password = "{real-password}";
//
//      String token = getUserPasswordAccessToken(user, password).accessToken();
//      System.out.println(token);
//
//      SimpleAuthProvider authProvider = new SimpleAuthProvider(token);
//      IGraphServiceClient graphClient = GraphServiceClient.builder().authenticationProvider(authProvider).buildClient();
//
//      Message message = new Message();
//      message.subject = "My subject";
//
//      ItemBody body = new ItemBody();
//      body.contentType = BodyType.HTML;
//      body.content = "<h1>My HTML body</h1>";
//      message.body = body;
//
//      List<Recipient> toRecipientList = new LinkedList<>();
//      Recipient toRecipient = new Recipient();
//      EmailAddress emailAddress = new EmailAddress();
//      emailAddress.address = "{real-recipient}";
//      toRecipient.emailAddress = emailAddress;
//      toRecipientList.add(toRecipient);
//      message.toRecipients = toRecipientList;
//
//      graphClient.me()
//              .sendMail(message, false)
//              .buildRequest()
//              .post();
//
///*
//       String mail = graphClient.me()
//              .buildRequest()
//              .get().mail;
//
//       System.out.println(mail);
//*/
//  }
//
//  private static IAuthenticationResult getUserPasswordAccessToken(String user, String password) throws Exception {
//
//      PublicClientApplication app = PublicClientApplication.builder(CLIENT_APP_ID).authority(AUTHORITY).build();
//
//      Set<String> scopes = new HashSet<>(Arrays.asList("Mail.Send"));
//
//      UserNamePasswordParameters userNamePasswordParam = UserNamePasswordParameters.builder(
//              scopes, user, password.toCharArray())
//              .build();
//
//      return app.acquireToken(userNamePasswordParam).get();
//  }
//
//  private static class SimpleAuthProvider implements IAuthenticationProvider {
//
//      private String accessToken = null;
//
//      public SimpleAuthProvider(String accessToken) {
//          this.accessToken = accessToken;
//      }
//
//      @Override
//      public void authenticateRequest(IHttpRequest request) {
//          request.addHeader("Authorization", "Bearer " + accessToken);
//      }
//
//  }
//}