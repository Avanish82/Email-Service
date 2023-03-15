//package com.restapi.repository;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.annotations.DynamicUpdate;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.restapi.entity.TblUserMaster;
//
//@Repository
//@DynamicUpdate
//@Transactional
//public interface TblUserMasterRepo extends JpaRepository<TblUserMaster, Long>{
//	 
//	  public TblUserMaster findByEmail(String email);
//	  public TblUserMaster findByUserId(long id);
//	  public TblUserMaster findByEmailContainingIgnoreCase(String id);
//	  public List<TblUserMaster> findAll();
//	  public int deleteByEmail(String userName);
//
//}
