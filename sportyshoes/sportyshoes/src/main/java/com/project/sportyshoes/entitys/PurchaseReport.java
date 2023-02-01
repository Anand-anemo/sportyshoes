package com.project.sportyshoes.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PurchaseReport {
	
	@Id
	@GeneratedValue
	@Column(name="purchase_id")
	private int purchaseId;
	@Column(name="purchase_by")
	private String purchasedBy;
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name="category")
	private String category;
	@Column(name="brand")
	private String Brand;
	@Column(name="shoe_no")
	private int shoeno;
	@Column(name="price")
	private long price;
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPurchasedBy() {
		return purchasedBy;
	}
	public void setPurchasedBy(String purchasedBy) {
		this.purchasedBy = purchasedBy;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public int getShoeno() {
		return shoeno;
	}
	public void setShoeno(int shoeno) {
		this.shoeno = shoeno;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public PurchaseReport(int purchaseId, String purchasedBy, Date date, String category, String brand, int shoeno,
			long price) {
		super();
		this.purchaseId = purchaseId;
		this.purchasedBy = purchasedBy;
		this.date = date;
		this.category = category;
		Brand = brand;
		this.shoeno = shoeno;
		this.price = price;
	}
	public PurchaseReport() {}

}
