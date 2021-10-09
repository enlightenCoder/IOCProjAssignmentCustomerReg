package com.nt.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class Menu {

	
	private static String[] carts = new String[100];
	private static String[] prices = new String[100];
	private static int cart_no = 0;

	public void display(MainController controller) {

		int choice = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("=====================================");
		System.out.println("=         WELCOME TO AMAZON         =");
		System.out.println("=====================================");
		System.out.print("Enter your Full name : ");
		String name = scan.next();
		System.out.println("=====================================");
		System.out.println("=====================================");
		


		do {

			System.out.println("---------------------------------------");
			System.out.println("          Amazon Shopping             -");
			System.out.println("---------------------------------------");
			System.out.println("         1. Jean $150                 -");
			System.out.println("         2. T-Shirt $20               -");
			System.out.println("         3. Mobile Phone $400         -");
			System.out.println("         4. Others                    -");
			System.out.println("         5. Registration              -");
			System.out.println("         6. Show Cart                 -");
			System.out.println("         7. exit                      -");
			System.out.println("---------------------------------------");
			System.out.println("---------------------------------------");
			Scanner input = new Scanner(System.in);
			System.out.println("Choose options [1-7] : ");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				//for (int i = 0; i < 5; ++i) System.out.println();
				carts[cart_no] = "Jean";
				prices[cart_no] = "150";
				cart_no++;
				for (int i = 0; i < 5; ++i) System.out.println();
				break;
			case 2:
				//for (int i = 0; i < 5; ++i) System.out.println();
				carts[cart_no] = "T-Shirt";
				prices[cart_no] = "20";
				cart_no++;
				for (int i = 0; i < 5; ++i) System.out.println();
				break;
			case 3:
				//for (int i = 0; i < 5; ++i) System.out.println();
				carts[cart_no] = "Mobile Phone";
				prices[cart_no] = "400";
				cart_no++;
				for (int i = 0; i < 5; ++i) System.out.println();
				break;
			case 4:
				System.out.println("Enter item : ");
				String items = input.next();
				System.out.println("Enter price : ");
				String price = input.next();
				carts[cart_no] = items;
				prices[cart_no] = price;
				cart_no++;
				break;
			case 5:
				for (int i = 0; i < 5; ++i) System.out.println();
				CustomerVO vo = new CustomerVO();
				vo.setCust_name(name);
				vo.setCart(carts);
				vo.setPrices(prices);
				try {
					System.out.print(controller.processCustomer(vo));
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				//for (int i = 0; i < 50; ++i) System.out.println();
				System.out.println("Cart details : ");
				System.out.println(Arrays.toString(carts));
				System.out.println(Arrays.toString(prices));
				for (int i = 0; i < 5; ++i) System.out.println();
				break;
			case 7:
				System.out.println("Thanks for shopping at Amazon");
				System.exit(1);
			default:
				System.out.println("Incorrect Choice");
				break;

			}

		} while (choice != 5);

	}
	
	
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  

}
