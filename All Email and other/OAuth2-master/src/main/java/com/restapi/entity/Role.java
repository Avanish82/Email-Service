package com.restapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Role {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;
  
//Add new column 3/3/2023
//  private int roleId;
//  private String roleName;
//  private String description;
//  private boolean isClientRole;
//  private boolean disabled;
//  private int createdBy;
//  private LocalDateTime createdOn;
//  private LocalDateTime modifiedOn;
  
  public Role() {

  }

  public Role(ERole name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }

//public int getRoleId() {
//	return roleId;
//}
//
//public void setRoleId(int roleId) {
//	this.roleId = roleId;
//}
//
//public String getRoleName() {
//	return roleName;
//}
//
//public void setRoleName(String roleName) {
//	this.roleName = roleName;
//}
//
//public String getDescription() {
//	return description;
//}
//
//public void setDescription(String description) {
//	this.description = description;
//}
//
//public boolean isClientRole() {
//	return isClientRole;
//}
//
//public void setClientRole(boolean isClientRole) {
//	this.isClientRole = isClientRole;
//}
//
//public boolean isDisabled() {
//	return disabled;
//}
//
//public void setDisabled(boolean disabled) {
//	this.disabled = disabled;
//}
//
//public int getCreatedBy() {
//	return createdBy;
//}
//
//public void setCreatedBy(int createdBy) {
//	this.createdBy = createdBy;
//}
//
//public LocalDateTime getCreatedOn() {
//	return createdOn;
//}
//
//public void setCreatedOn(LocalDateTime createdOn) {
//	this.createdOn = createdOn;
//}
//
//public LocalDateTime getModifiedOn() {
//	return modifiedOn;
//}
//
//public void setModifiedOn(LocalDateTime modifiedOn) {
//	this.modifiedOn = modifiedOn;
//}
//  
}