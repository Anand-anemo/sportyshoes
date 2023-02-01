package com.project.sportyshoes.repository;

import java.util.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.sportyshoes.entitys.PurchaseReport;

@Repository
//@RepositoryRestResource(collectionResourceRel = "users", path = "sportyshoessss")
public interface Purchaserepo extends CrudRepository<PurchaseReport , Integer> {
	
	List<PurchaseReport> findByDateAndCategory(Date date,String category);

}
