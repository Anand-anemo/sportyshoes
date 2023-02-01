package com.project.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.sportyshoes.entitys.Users;

import net.minidev.json.annotate.JsonIgnore;

//@RepositoryRestResource(collectionResourceRel = "users", path = "sportyshoesss")
@Repository
public interface Usersrepo extends CrudRepository< Users , Integer> {
	@JsonIgnore
	List<Users> findByName(String name);
	//List<Users> getUserByUserName(String)
	@Query("select u from Users u where u.type = :type")
	public Users findBytype(@Param(value = "type") String type);

}
