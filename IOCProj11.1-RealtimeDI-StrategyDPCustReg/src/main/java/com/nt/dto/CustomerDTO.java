package com.nt.dto;

public class CustomerDTO {
	
	
	private Integer cust_no;
	private String cust_name;
	private String[] carts;
	private float[] prices;
	
	
	public Integer getCust_no() {
		return cust_no;
	}
	public void setCust_no(Integer cust_no) {
		this.cust_no = cust_no;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String[] getCarts() {
		return carts;
	}
	public void setCarts(String[] carts) {
		this.carts = carts;
	}
	public float[] getPrices() {
		return prices;
	}
	public void setPrices(float[] prices) {
		this.prices = prices;
	}
	
	
	

}
