package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;

import com.app.entity.EmailDetails;

@Repository
public interface EmailRepository extends JpaRepository<EmailDetails, Long>{

	void save(SimpleMailMessage mailMessage);

	//String save(SimpleMailMessage mailMessage);
	

}
