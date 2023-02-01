package com.project.sportyshoes.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	@Column(name="shoes_id")
	private int shoesid;
	@Column(name="category")
	private String shoescategory;
	@Column(name="type")
	private String shoestype;
	@Column(name="brand")
	private String shoesbrand;
	@Column(name="shoes_no")
	private int shoesno;
	@Column(name="price")
	private long shoesprice;
	
	
	public int getShoesid() {
		return shoesid;
	}
	public void setShoesid(int shoesid) {
		this.shoesid = shoesid;
	}
	public String getShoescategory() {
		return shoescategory;
	}
	public void setShoescategory(String shoescategory) {
		this.shoescategory = shoescategory;
	}
	public String getShoestype() {
		return shoestype;
	}
	public void setShoestype(String shoestype) {
		this.shoestype = shoestype;
	}
	public String getShoesbrand() {
		return shoesbrand;
	}
	public void setShoesbrand(String shoesbrand) {
		this.shoesbrand = shoesbrand;
	}
	public int getShoesno() {
		return shoesno;
	}
	public void setShoesno(int shoesno) {
		this.shoesno = shoesno;
	}
	public long getShoesprice() {
		return shoesprice;
	}
	public void setShoesprice(long shoesprice) {
		this.shoesprice = shoesprice;
	}
	
	public Product(int shoesid, String shoescategory, String shoestype, String shoesbrand, int shoesno,
			long shoesprice) {
		super();
		this.shoesid = shoesid;
		this.shoescategory = shoescategory;
		this.shoestype = shoestype;
		this.shoesbrand = shoesbrand;
		this.shoesno = shoesno;
		this.shoesprice = shoesprice;
	}
	
	public Product() {}


}