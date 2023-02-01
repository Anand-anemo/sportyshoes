package com.project.sportyshoes.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sportyshoes.customException.BusinessException;
import com.project.sportyshoes.entitys.Product;
import com.project.sportyshoes.entitys.PurchaseReport;
import com.project.sportyshoes.entitys.Users;
import com.project.sportyshoes.repository.Productrepo;
import com.project.sportyshoes.repository.Purchaserepo;
import com.project.sportyshoes.repository.Usersrepo;

@Service
public class Serviceimplement implements servicetoall {
	
	@Autowired
	private Usersrepo urepo;
	@Autowired
	private Productrepo prepo;
	@Autowired
	private Purchaserepo purrepo;
	
	//getting users from database
	@Override
	 public  List<Users> getusers(){
          List<Users> userslist=null;
		
		try {
			
		userslist = (List<Users>)urepo.findAll();
		
		}
		catch (Exception e) {
			throw new BusinessException("605","Something went wrong in Service layer while fetching all product" + e.getMessage());
		}
		if(userslist.isEmpty())
			throw new BusinessException("604", " list is completely empty,  nothing to return");
		return userslist;
	}
		//return (List<Users>) urepo.findAll();
	
	
	//updating users in database with given id
	@Override
	public Users updateUsers(Users users) {
		try {
			return urepo.save(users);
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("608","given product id is null, please send some valid id to update" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("610","Something went wrong in Service layer " + e.getMessage());
		}
		
		
	}
	
	//getting user by name
	@Override
	public List<Users>getUsersByName(String name){
		List<Users>username=null;
		try {
		username=urepo.findByName(name);
		}
		catch (Exception e) {
			throw new BusinessException("605","Something went wrong in Service layer while fetching the user" + e.getMessage());
		}
		if(username.isEmpty())
			throw new BusinessException("604", " list is completely empty,  nothing to return");
		return username;
	}
	
	//getting all product from database 
	@Override
	public List<Product> getproduct(){
		
		List<Product> productlist=null;
		
		try {
			
		productlist = (List<Product>)prepo.findAll();
		
		}
		catch (Exception e) {
			throw new BusinessException("605","Something went wrong in Service layer while fetching all product" + e.getMessage());
		}
		if(productlist.isEmpty())
			throw new BusinessException("604", " list is completely empty,  nothing to return");
		return productlist;
	}
	
	//save product to the database
	@Override
	public Product saveproduct(Product product) {
		
		if(product.getShoescategory().isEmpty() || product.getShoescategory().length()==0) {
			throw new BusinessException("601","Please send proper name, It blank");
		}
		try {
		return prepo.save(product);
		}catch (IllegalArgumentException e) {
			throw new BusinessException("602","given product is null" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("603","Something went wrong in Service layer while saving the product" + e.getMessage());
		}
	}
	
	//update the product by id
	@Override
	public Product updateProduct(Product product) {
		try {
		return prepo.save(product);
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("608","given product id is null, please send some valid id to update" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("610","Something went wrong in Service layer " + e.getMessage());
		}
	}
	
	//delete the product by id
	@Override
	public void deleteproduct(int id) {
		try {
		
		prepo.deleteById(id);
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("608","given product id is null, please send some valid id to be deleted" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("610","Something went wrong in Service layer " + e.getMessage());
		}
	}
	
	//getting findBydateandcategory
	@Override
	public List<PurchaseReport> getreportByDateAndCategory(Date date , String category){
		try {
		return purrepo.findByDateAndCategory(date, category);
		}catch (Exception e) {
			throw new BusinessException("605","Something went wrong in Service layer while fetching data" + e.getMessage());
		}
		
	}


	


	
}
