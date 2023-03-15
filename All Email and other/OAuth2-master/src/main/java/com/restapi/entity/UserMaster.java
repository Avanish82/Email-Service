//package com.restapi.entity;
//
//import java.time.LocalDateTime;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.restapi.serviceImpl.RoleService;
//
//public class UserMaster implements UserDetails{
//
//	private long userId;
//	private long personId;
//	private long empId;
//	private String title;
//	private String firstName;
//	private String middleName;
//	private String lastName;
//	private String domain;
//	private String loginName;
//	private String password;
//	private String email;
//	private String isClient;
//	private String supervisorId;
//	private String departmentId;
//	private LocalDateTime doj;
//	private LocalDateTime endDate;
//	private boolean disabed;
//	private int authenticationFailCount;
//	private long erpClientId;
//	private long erpProcessId;
//	private long facilityMasterId;
//	private long createdBy;
//	private LocalDateTime createdOn;
//	private LocalDateTime modifiedOn;
//	private long jobMasterId;
//	private long lobMasterId;
//	private long sbuMasterId;
//	private long modifiedBy;
//	
//	RoleService roleService;
//
//	public long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}
//
//	public long getPersonId() {
//		return personId;
//	}
//
//	public void setPersonId(long personId) {
//		this.personId = personId;
//	}
//
//	public long getEmpId() {
//		return empId;
//	}
//
//	public void setEmpId(long empId) {
//		this.empId = empId;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getMiddleName() {
//		return middleName;
//	}
//
//	public void setMiddleName(String middleName) {
//		this.middleName = middleName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getDomain() {
//		return domain;
//	}
//
//	public void setDomain(String domain) {
//		this.domain = domain;
//	}
//
//	public String getLoginName() {
//		return loginName;
//	}
//
//	public void setLoginName(String loginName) {
//		this.loginName = loginName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getIsClient() {
//		return isClient;
//	}
//
//	public void setIsClient(String isClient) {
//		this.isClient = isClient;
//	}
//
//	public String getSupervisorId() {
//		return supervisorId;
//	}
//
//	public void setSupervisorId(String supervisorId) {
//		this.supervisorId = supervisorId;
//	}
//
//	public String getDepartmentId() {
//		return departmentId;
//	}
//
//	public void setDepartmentId(String departmentId) {
//		this.departmentId = departmentId;
//	}
//
//	public LocalDateTime getDoj() {
//		return doj;
//	}
//
//	public void setDoj(LocalDateTime doj) {
//		this.doj = doj;
//	}
//
//	public LocalDateTime getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(LocalDateTime endDate) {
//		this.endDate = endDate;
//	}
//
//	public boolean isDisabed() {
//		return disabed;
//	}
//
//	public void setDisabed(boolean disabed) {
//		this.disabed = disabed;
//	}
//
//	public int getAuthenticationFailCount() {
//		return authenticationFailCount;
//	}
//
//	public void setAuthenticationFailCount(int authenticationFailCount) {
//		this.authenticationFailCount = authenticationFailCount;
//	}
//
//	public long getErpClientId() {
//		return erpClientId;
//	}
//
//	public void setErpClientId(long erpClientId) {
//		this.erpClientId = erpClientId;
//	}
//
//	public long getErpProcessId() {
//		return erpProcessId;
//	}
//
//	public void setErpProcessId(long erpProcessId) {
//		this.erpProcessId = erpProcessId;
//	}
//
//	public long getFacilityMasterId() {
//		return facilityMasterId;
//	}
//
//	public void setFacilityMasterId(long facilityMasterId) {
//		this.facilityMasterId = facilityMasterId;
//	}
//
//	public long getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(long createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public LocalDateTime getCreatedOn() {
//		return createdOn;
//	}
//
//	public void setCreatedOn(LocalDateTime createdOn) {
//		this.createdOn = createdOn;
//	}
//
//	public LocalDateTime getModifiedOn() {
//		return modifiedOn;
//	}
//
//	public void setModifiedOn(LocalDateTime modifiedOn) {
//		this.modifiedOn = modifiedOn;
//	}
//
//	public long getJobMasterId() {
//		return jobMasterId;
//	}
//
//	public void setJobMasterId(long jobMasterId) {
//		this.jobMasterId = jobMasterId;
//	}
//
//	public long getLobMasterId() {
//		return lobMasterId;
//	}
//
//	public void setLobMasterId(long lobMasterId) {
//		this.lobMasterId = lobMasterId;
//	}
//
//	public long getSbuMasterId() {
//		return sbuMasterId;
//	}
//
//	public void setSbuMasterId(long sbuMasterId) {
//		this.sbuMasterId = sbuMasterId;
//	}
//
//	public long getModifiedBy() {
//		return modifiedBy;
//	}
//
//	public void setModifiedBy(long modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}
//
//	public RoleService getRoleService() {
//		return roleService;
//	}
//
//	public void setRoleService(RoleService roleService) {
//		this.roleService = roleService;
//	}
//
//	@Override
//	public String toString() {
//		return "UserMaster [userId=" + userId + ", personId=" + personId + ", empId=" + empId + ", title=" + title
//				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", domain="
//				+ domain + ", loginName=" + loginName + ", password=" + password + ", email=" + email + ", isClient="
//				+ isClient + ", supervisorId=" + supervisorId + ", departmentId=" + departmentId + ", doj=" + doj
//				+ ", endDate=" + endDate + ", disabed=" + disabed + ", authenticationFailCount="
//				+ authenticationFailCount + ", erpClientId=" + erpClientId + ", erpProcessId=" + erpProcessId
//				+ ", facilityMasterId=" + facilityMasterId + ", createdBy=" + createdBy + ", createdOn=" + createdOn
//				+ ", modifiedOn=" + modifiedOn + ", jobMasterId=" + jobMasterId + ", lobMasterId=" + lobMasterId
//				+ ", sbuMasterId=" + sbuMasterId + ", modifiedBy=" + modifiedBy + "]";
//	}
//
//	public UserMaster() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		System.out.println("User Id");
//		System.out.println("RoleService | "+roleService);
//		List<Role> roles=roleService.findRolesById(userId);
//		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//		roles.forEach(r ->{
//			System.out.println("Name "+ r.getRoleName());
//			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
//		});
//		return authorities;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//}
