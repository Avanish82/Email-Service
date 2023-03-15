//package com.restapi.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@AllArgsConstructor
//@NoArgsConstructor
////@Entity(name="OAuth")
//@Entity(name="oauthTokenjenrater")
//@Data
//public class Oauth {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO) 
//	private Long id;
//	@Column(name ="grant_type")
//	private String grant_type;
//	@Column(name ="username")
//	private String username;
//	@Column(name ="password")
//	private String password;
//	@Column(name ="scope")
//	private String scope;
//	 
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getGrant_type() {
//		return grant_type;
//	}
//	public void setGrant_type(String grant_type) {
//		this.grant_type = grant_type;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getScope() {
//		return scope;
//	}
//	public void setScope(String scope) {
//		this.scope = scope;
//	}
//	 
//	 
//}
//	
////	@Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private Long id;
////
////    @Column(name ="access_token")
////	private String access_token; 
////    @Column(name ="token_type")
////    private String token_type;
////    @Column(name ="refresh_token")
////    private String refresh_token; 
////    @Column(name ="expires_in")
////    private String expires_in;
////    @Column(name ="scope")
////    private String scope;
////    
////	public Long getId() {
////		return id;
////	}
////	public void setId(Long id) {
////		this.id = id;
////	}
////	public String getAccess_token() {
////		return access_token;
////	}
////	public void setAccess_token(String access_token) {
////		this.access_token = access_token;
////	}
////	public String getToken_type() {
////		return token_type;
////	}
////	public void setToken_type(String token_type) {
////		this.token_type = token_type;
////	}
////	public String getRefresh_token() {
////		return refresh_token;
////	}
////	public void setRefresh_token(String refresh_token) {
////		this.refresh_token = refresh_token;
////	}
////	public String getExpires_in() {
////		return expires_in;
////	}
////	public void setExpires_in(String expires_in) {
////		this.expires_in = expires_in;
////	}
////	public String getScope() {
////		return scope;
////	}
////	public void setScope(String scope) {
////		this.scope = scope;
////	}
////	public Oauth setAccess_token(OAuth2AccessToken accessToken) {
////		// TODO Auto-generated method stub
////		return null;
////	}
////    
////
////}
