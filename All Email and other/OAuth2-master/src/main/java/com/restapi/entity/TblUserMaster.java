//package com.restapi.entity;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.Collection;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@Entity(name="tblUserMaster")
//public class TblUserMaster implements Serializable, UserDetails{
//	/** primary key */
//   protected static final String pk="userId";
//   
//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   @Column(name ="UserID", unique=true, nullable=false, precision=19)
//   private long userId;
//   @Column(name="NewUserID")
//   private long newUserId;
//   @Column(name="PersonID")
//   private long personId;
//   @Column(name="EmpID")
//   private long empId;
//   @Column(name="Title")
//   private String title;
//   @Column(name="FirstName")
//   private String firstName;
//   @Column(name="LastName")
//   private String lastName;
//   @Column(name="MiddleName")
//   private String middleName;
//   @Column(name="Domain")
//   private String domain;
//   @Column(name="LoginName")
//   private String loginName;
//   @Column(name="Email")
//   private String email;
//   @Column(name="Mobile")
//   private String mobile;
//   @Column(name="Whatsapps")
//   private String whatsapps;
//   @Column(name="IsClient")
//   private String isClient;
//   @Column(name="IsPartner")
//   private String isPartner;
//   @Column(name="SupervisorId")
//   private long supervisorId;
//   @Column(name="Doj")
//   private LocalDateTime doj;
//   @Column(name="EndDate")
//   private LocalDateTime endDate;
//   @Column(name="Disabled")
//   private boolean disabled;
//   @Column(name="CreatedBy")
//   private long createdBy;
//   @Column(name="CreatedOn")
//   private LocalDateTime createdOn;
//   @Column(name="ModifiedBy")
//   private long modifiedBy;
//   @Column(name="ModifiedOn")
//   private LocalDateTime modifiedOn;
//public long getUserId() {
//	return userId;
//}
//public void setUserId(long userId) {
//	this.userId = userId;
//}
//public long getNewUserId() {
//	return newUserId;
//}
//public void setNewUserId(long newUserId) {
//	this.newUserId = newUserId;
//}
//public long getPersonId() {
//	return personId;
//}
//public void setPersonId(long personId) {
//	this.personId = personId;
//}
//public long getEmpId() {
//	return empId;
//}
//public void setEmpId(long empId) {
//	this.empId = empId;
//}
//public String getTitle() {
//	return title;
//}
//public void setTitle(String title) {
//	this.title = title;
//}
//public String getFirstName() {
//	return firstName;
//}
//public void setFirstName(String firstName) {
//	this.firstName = firstName;
//}
//public String getLastName() {
//	return lastName;
//}
//public void setLastName(String lastName) {
//	this.lastName = lastName;
//}
//public String getMiddleName() {
//	return middleName;
//}
//public void setMiddleName(String middleName) {
//	this.middleName = middleName;
//}
//public String getDomain() {
//	return domain;
//}
//public void setDomain(String domain) {
//	this.domain = domain;
//}
//public String getLoginName() {
//	return loginName;
//}
//public void setLoginName(String loginName) {
//	this.loginName = loginName;
//}
//public String getEmail() {
//	return email;
//}
//public void setEmail(String email) {
//	this.email = email;
//}
//public String getMobile() {
//	return mobile;
//}
//public void setMobile(String mobile) {
//	this.mobile = mobile;
//}
//public String getWhatsapps() {
//	return whatsapps;
//}
//public void setWhatsapps(String whatsapps) {
//	this.whatsapps = whatsapps;
//}
//public String getIsClient() {
//	return isClient;
//}
//public void setIsClient(String isClient) {
//	this.isClient = isClient;
//}
//public String getIsPartner() {
//	return isPartner;
//}
//public void setIsPartner(String isPartner) {
//	this.isPartner = isPartner;
//}
//public long getSupervisorId() {
//	return supervisorId;
//}
//public void setSupervisorId(long supervisorId) {
//	this.supervisorId = supervisorId;
//}
//public LocalDateTime getDoj() {
//	return doj;
//}
//public void setDoj(LocalDateTime doj) {
//	this.doj = doj;
//}
//public LocalDateTime getEndDate() {
//	return endDate;
//}
//public void setEndDate(LocalDateTime endDate) {
//	this.endDate = endDate;
//}
//public boolean isDisabled() {
//	return disabled;
//}
//public void setDisabled(boolean disabled) {
//	this.disabled = disabled;
//}
//public long getCreatedBy() {
//	return createdBy;
//}
//public void setCreatedBy(long createdBy) {
//	this.createdBy = createdBy;
//}
//public LocalDateTime getCreatedOn() {
//	return createdOn;
//}
//public void setCreatedOn(LocalDateTime createdOn) {
//	this.createdOn = createdOn;
//}
//public long getModifiedBy() {
//	return modifiedBy;
//}
//public void setModifiedBy(long modifiedBy) {
//	this.modifiedBy = modifiedBy;
//}
//public LocalDateTime getModifiedOn() {
//	return modifiedOn;
//}
//public void setModifiedOn(LocalDateTime modifiedOn) {
//	this.modifiedOn = modifiedOn;
//}
//public static String getPk() {
//	return pk;
//}
//@Override
//public Collection<? extends GrantedAuthority> getAuthorities() {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public String getPassword() {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public String getUsername() {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public boolean isAccountNonExpired() {
//	// TODO Auto-generated method stub
//	return false;
//}
//@Override
//public boolean isAccountNonLocked() {
//	// TODO Auto-generated method stub
//	return false;
//}
//@Override
//public boolean isCredentialsNonExpired() {
//	// TODO Auto-generated method stub
//	return false;
//}
//@Override
//public boolean isEnabled() {
//	// TODO Auto-generated method stub
//	return false;
//}
//   
//}