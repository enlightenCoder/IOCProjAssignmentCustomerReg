package com.nt.controller;

import java.util.Arrays;

import com.nt.dto.CustomerDTO;
import com.nt.service.ICustomerMgmtService;
import com.nt.vo.CustomerVO;

public class MainController {
	
	
	// HAS-A PROPERTY
	private ICustomerMgmtService service;

	public MainController(ICustomerMgmtService service) {
		System.out.println("MainController.1 param Constructor");
		this.service = service;
	}
	
	
	public String processCustomer(CustomerVO vo) throws Exception
	{
		// convert VO to DTO
		CustomerDTO dto = new CustomerDTO();
		dto.setCust_name(vo.getCust_name());
		dto.setCarts(vo.getCart());
		float new_prices[] = new float[100];
		
		Arrays.stream(vo.getPrices()).forEach((item)->{
			
			for(int i = 0; i < vo.getPrices().length;i++) 
			{
				if(vo.getPrices()[i] != null) 
				{
					new_prices[i] = Float.parseFloat(vo.getPrices()[i]);
				}
				
				
			}
			
		});
		
		dto.setPrices(new_prices);
		
		
		
		
		return service.registerCustomer(dto);
	}
	
	

}
