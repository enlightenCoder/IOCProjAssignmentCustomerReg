package com.nt.service;

import java.util.Arrays;

import com.nt.bo.CustomerBO;
import com.nt.dao.ICustomerDao;
import com.nt.dto.CustomerDTO;

public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	// HAS- A PROPERTY --> DAO Object
	private ICustomerDao dao;
	// private static int no_items;

	public CustomerMgmtServiceImpl(ICustomerDao dao) {
		System.out.println("CustomerMgmtServiceImpl. Param Constructor");
		this.dao = dao;
	}

	@Override
	public String registerCustomer(CustomerDTO dto) throws Exception {

		float total_prices = 0.0f;
		float avg_prices = 0.0f;
		int no_items = 0;
		String status = null;

		// write business logic and calculations
//		Arrays.stream(dto.getCarts()).forEach((item)->{
//			
//			no_items += 1;
//			
//			
//		});

		for (int i = 0; i < dto.getCarts().length; i++) {
			total_prices += dto.getPrices()[i];
			no_items++;
		}

		avg_prices = total_prices / no_items;

		if (total_prices >= 1000) {
			status = "PREMIUM";
		} else if (total_prices >= 200 && total_prices <= 1000) {
			status = "STANDARD";
		} else {
			status = "NORMAL";
		}

		// prapare BO object
		CustomerBO bo = new CustomerBO();
		bo.setCust_name(dto.getCust_name());
		bo.setNo_items(no_items);
		bo.setTotal_price(total_prices);
		bo.setAvg_price(avg_prices);
		bo.setCust_status(status);

		int result = dao.insertCustomer(bo);

		String items_str = "";
		for (String item : dto.getCarts()) {
			if(item!=null)
				items_str += item + " , ";
		}
		String prices = "";

		for (float price : dto.getPrices()) {
			if(price!=0.0f)
				prices += price + " , ";
		}

		String final_msg = "=========================================" + '\n'
				+ "|    Customer successfully registered   |" + '\n' + "========================================"
				+ '\n' + "Details : " + '\n' + "--------" + '\n' +"Customer name : " + dto.getCust_name() + '\n' + "Articles : " + items_str + '\n' + "Price details : " + prices
				+ '\n' + "TOTAL PRICE : " + total_prices + '\n' + "AVERAGE PRICE : " + avg_prices + '\n'
				+ "========================================";

		return result == 1 && total_prices!=0.0 ? final_msg : "[-]ERROR: Customer failed to be registered";

	}

}
