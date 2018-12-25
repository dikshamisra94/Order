package com.infogain.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.infogain.utils.PizzaBaseEnum;
import com.infogain.utils.PizzaSizeEnum;
import com.infogain.utils.ToppingsSizePriceEnum;

public class CommonMethods {

	Scanner sc = new Scanner(System.in); 
	String optionSelected;

	public String ShowOptions(List<String> list){

		list.forEach(System.out :: println);
		optionSelected = sc.nextLine();
		while(!list.contains(optionSelected)) {
			System.out.println("Kindly provide from below options only ");
			list.forEach(System.out :: println);
			optionSelected = sc.nextLine();
		}
		return optionSelected;
	}

	public List<String> chooseList(List<String> list){

		List<String> toppings = new ArrayList<String>();
		list.forEach(System.out :: println);
		optionSelected = sc.nextLine();

		while(!("done".equalsIgnoreCase(optionSelected))) {
			System.out.println("optionSelected "+optionSelected);
			if(toppings.contains(optionSelected)) {
				System.out.println("This topping was already added . Try another one or type Done");
				optionSelected = sc.nextLine();
			}
			else if(list.contains(optionSelected)) {
				toppings.add(optionSelected);
				optionSelected = sc.nextLine();
			}
			else if(toppings.contains(optionSelected)) {
				System.out.println("This topping was already added . Try another one or type Done");
				optionSelected = sc.nextLine();
			}
			else {
				System.out.println("Kindly provide toppings from below options only ");
				list.forEach(System.out :: println);
				optionSelected = sc.nextLine();
			}
		}
		return toppings;
	}


	public BigDecimal singleOrderAmount(String size,String base,List<String> toppings,String cheese,String doubleCheese) {

		BigDecimal orderAmount = new BigDecimal(0.00);

		BigDecimal baseAmount = new BigDecimal(PizzaBaseEnum.valueOf(base).toInteger());
		BigDecimal baseSizeAmount = new BigDecimal(PizzaSizeEnum.valueOf(size).toDouble());

		baseAmount = baseAmount.add(baseAmount.multiply(baseSizeAmount));
		orderAmount = orderAmount.add(baseAmount);

		Integer pricePerTopping = ToppingsSizePriceEnum.valueOf(size).toInteger();
		orderAmount = orderAmount.add(new BigDecimal(toppings.size() * pricePerTopping));

		if("yes".equalsIgnoreCase(doubleCheese)) {
			orderAmount = orderAmount.add(new BigDecimal(ToppingsSizePriceEnum.valueOf(size).toInteger()));
		}		
		return orderAmount;
	}

	public void showInvoice(Map<String, Integer> orders) {
		Integer orderTotal = 0;
		for(String key : orders.keySet()) {
			System.out.println(key);
			System.out.print(" : ");
			System.out.println(orders.get(key));
			orderTotal = orderTotal + orders.get(key);
		}
		int serviceTax = (int) (orderTotal * .05);
		int vat = (int) (orderTotal * .06);
		int total =  serviceTax + vat +orderTotal;
		System.out.println("Order Total : "+orderTotal);
		System.out.println("Service Tax(5%) : "+ serviceTax);
		System.out.println("VAT (6%) : "+ vat);
		System.out.println("Total : "+ total);
	}

}
