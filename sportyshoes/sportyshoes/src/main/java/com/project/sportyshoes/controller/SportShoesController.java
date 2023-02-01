package com.project.sportyshoes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sportyshoes.customException.BusinessException;
import com.project.sportyshoes.customException.ControllerException;
import com.project.sportyshoes.entitys.Product;
import com.project.sportyshoes.entitys.PurchaseReport;
import com.project.sportyshoes.entitys.Users;
import com.project.sportyshoes.services.servicetoall;

@RestController

public class SportShoesController {
	
	@Autowired
	private servicetoall allservice;
	
	
	//get all users
	@GetMapping("/users")
	public ResponseEntity<List<Users>> getusers(){
		
		
		return new ResponseEntity<List<Users>>(allservice.getusers(),HttpStatus.OK);
		
			
		}
	
	//get user by id 
	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateUsers( @PathVariable int id , @RequestBody Users users) {
		users.setId(id);
		return new ResponseEntity<Users>(allservice.updateUsers(users),HttpStatus.OK);
	}
	
	//get user by name
	@GetMapping("/users/filterByName")
	public ResponseEntity<List<Users>> getUsersByName(@RequestParam String name){
	return new ResponseEntity<List<Users>>(allservice.getUsersByName(name),HttpStatus.OK);
	}
	
	
	
	//save product
	
	
   // @PostMapping("/product")
	//public Product saveproduct(@RequestBody Product product) {
		//return allservice.saveproduct(product);
	//}
	
	//save product
    @PostMapping("/product")
	public ResponseEntity<?> saveproduct(@RequestBody Product product){
		try {
			Product productSaved = allservice.saveproduct(product);
			return new ResponseEntity<Product>(productSaved, HttpStatus.CREATED);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("611","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	
    
	//getting all product
	//@GetMapping("/product")
	//public List<Product> getproduct(){
		//return allservice.getproduct();
	
//}
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getproduct(){
		
		List<Product> getproduct =allservice.getproduct();
		return new ResponseEntity<List<Product>>(getproduct, HttpStatus.OK);
	}
	
	//updating product by id
	//@PutMapping("/product/{id}")
	//public Product updateProduct( @PathVariable int id , @RequestBody Product product) {
		//product.setShoesid(id);
		//return allservice.updateProduct(product);
	//}
	@PutMapping("/product/{shoesid}")
	public ResponseEntity<?> updateProduct ( @RequestBody Product product,@PathVariable("shoesid")int shoesid ){
		try {
			this.allservice.updateProduct(product);
			return ResponseEntity.ok().body(product);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return  new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("612","Something went wrong in controller");
			return  new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	//deleting product by id
		@DeleteMapping("/product/delete")
		public ResponseEntity<HttpStatus>deleteproduct(@RequestParam int id) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
	//getting data by dateandcategory
		@GetMapping("/purchase/reportbydateandcategory")
		public ResponseEntity<List<PurchaseReport>> getreportByDateAndCategory(@RequestParam Date date , @RequestParam String category){
		return new ResponseEntity<List<PurchaseReport>>(allservice.getreportByDateAndCategory(date,category),HttpStatus.OK);
		}
	
}