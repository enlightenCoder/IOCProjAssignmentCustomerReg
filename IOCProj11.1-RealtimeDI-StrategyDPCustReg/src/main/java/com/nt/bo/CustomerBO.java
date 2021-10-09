package com.nt.bo;

public class CustomerBO {
	
	// Persistable data should be same as in the table
	private Integer cust_no;
	private String cust_name;
	private Integer no_items;
	private Float total_price;
	private Float avg_price;
	private String cust_status;
	
	
	
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
	public Integer getNo_items() {
		return no_items;
	}
	public void setNo_items(Integer no_items) {
		this.no_items = no_items;
	}
	public Float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Float total_price) {
		this.total_price = total_price;
	}
	public Float getAvg_price() {
		return avg_price;
	}
	public void setAvg_price(Float avg_price) {
		this.avg_price = avg_price;
	}
	public String getCust_status() {
		return cust_status;
	}
	public void setCust_status(String cust_status) {
		this.cust_status = cust_status;
	}
	
	

}
