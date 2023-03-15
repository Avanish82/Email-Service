package com.cust.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cust.dto.EmailDetails;
import com.cust.service.MailHelper;
 

 

// Annotation
@RestController
// Class
public class EmailController {
 
	@Autowired
	MailHelper mailHelper;
//    @Autowired 
//    private EmailService emailService;
//    
// 
//    // Sending a simple Email
//    @PostMapping("/sendMail")
//    public String sendMail(@RequestBody EmailDetails details)
//    {
//        String status = emailService.sendSimpleMail(details);
// 
//        return status;
//    }
// 
//    // Sending email with attachment
//    @PostMapping("/sendMailWithAttachment")
//    public String sendMailWithAttachment(@RequestBody EmailDetails details)
//    {
//        String status
//            = emailService.sendMailWithAttachment(details);
// 
//        return status;
//    }
    
    // Sending a azure through Email
    @PostMapping("/azureMail")
	//@RequestMapping(name="/azureMail", method =RequestMethod.POST)
    public void azureMail(@RequestBody EmailDetails details)
    {
      //  String status =
        		mailHelper.sendAzure(details);
    	// String status = (String) emailService.sendAzureMail(details);
 
       // return status;sendAzureMail
    } 
}