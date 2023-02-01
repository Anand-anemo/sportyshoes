package com.project.sportyshoes.services;

import java.util.Date;
import java.util.List;

import com.project.sportyshoes.entitys.Product;
import com.project.sportyshoes.entitys.PurchaseReport;
import com.project.sportyshoes.entitys.Users;

public interface servicetoall {

	
	List<Users> getusers();
	Users updateUsers (Users user);
	List<Users> getUsersByName(String name);
	
	
	List<Product> getproduct();
	Product saveproduct(Product product);
	Product updateProduct(Product product);
	void deleteproduct(int id);
	List<PurchaseReport> getreportByDateAndCategory(Date date,String category);
	
}
