package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {
	@Id
	private String SKU;
	private int count;
	
	public Products() {
		super();
	}

	public Products(String sKU, Integer count) {
		super();
		SKU = sKU;
		this.count = count;
	}
	
	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Products [SKU=" + SKU + ", count=" + count + "]";
	}
	
	
	
	
}
