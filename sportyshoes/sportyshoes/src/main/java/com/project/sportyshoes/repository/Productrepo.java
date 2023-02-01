package com.project.sportyshoes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.sportyshoes.entitys.Product;

@Repository
//@RepositoryRestResource(collectionResourceRel = "users", path = "sportyshoess")
public interface Productrepo extends CrudRepository<Product , Integer>{
	
}
