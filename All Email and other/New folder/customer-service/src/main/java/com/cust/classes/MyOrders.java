package com.cust.classes;

import com.cust.dto.Customer;

import lombok.Data;

@Data
public class MyOrders {

    private Customer cutomer;
    private Product product;
	public Customer getCutomer() {
		return cutomer;
	}
	public void setCutomer(Customer cutomer) {
		this.cutomer = cutomer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
    
}
