package com.azure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public class AzureEmailController {
	
	@Autowired
	private AzureController azureService;
	
	 
    //Add new controller 
    @PostMapping("/azureMail")
    public void azureMail(EmailDetails emailDetails) throws Exception {
    
    	azureService.sendMailL(emailDetails);
    }

}
