package com.infogain.order; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.infogain.utils.PizzaBaseEnum;
import com.infogain.utils.PizzaCheeseEnum;
import com.infogain.utils.PizzaSauceEnum;
import com.infogain.utils.PizzaSizeEnum;
import com.infogain.utils.PizzaToppingsEnum;

public class PizzaOrderManager {
	public static void main(String[] args) {
		Map<String,Integer> orders = new HashMap<String,Integer>();
		CommonMethods methods = new CommonMethods();
		String size;
		String base;
		String sauce;
		String cheese;
		String nextOrder = "No";
		
		StringBuilder order = new StringBuilder();
		
		List<String> toppings = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		do{
		System.out.println("Kindly choose size of pizza from below sizes ?");

		List<String> sizeList = Stream.of(PizzaSizeEnum.values()).map(PizzaSizeEnum :: name).collect(Collectors.toList());
		size = methods.ShowOptions(sizeList);
		order.append(size);
		
		System.out.println("Kindly choose crust of pizza from below crusts ?");

		List<String> baseList = Stream.of(PizzaBaseEnum.values()).map(PizzaBaseEnum :: name).collect(Collectors.toList());
		base = methods.ShowOptions(baseList);
		order.append("|");
		order.append(base);
		
		System.out.println("Kindly choose sauces of pizza from below sauces ?");

		List<String> sauceList = Stream.of(PizzaSauceEnum.values()).map(PizzaSauceEnum :: name).collect(Collectors.toList());
		sauce = methods.ShowOptions(sauceList);
		order.append("|");
		order.append(sauce);
		
		System.out.println("Kindly choose one or more toppings from below options ?");
		List<String> toppingsList = Stream.of(PizzaToppingsEnum.values()).map(PizzaToppingsEnum :: name).collect(Collectors.toList());
		toppings = methods.chooseList(toppingsList);
		String toppingsString = String.join(",", toppings);
		order.append("|");
		order.append(toppingsString);
		
		System.out.println("Kindly choose cheese from below options ?");
		List<String> cheeseList = Stream.of(PizzaCheeseEnum.values()).map(PizzaCheeseEnum :: name).collect(Collectors.toList());
		cheese = methods.ShowOptions(cheeseList);
		order.append("|");
		order.append(sauce);
		
		System.out.println("You want Double cheese ? Yes / No");
		String doubleCheese = sc.nextLine();
		if("Yes".equalsIgnoreCase(doubleCheese)) {
			order.append(",");
			order.append("Double");
		}
		
		BigDecimal orderAmount = methods.singleOrderAmount(size, base, toppings, cheese, doubleCheese);
		orders.put(order.toString(), orderAmount.intValue());
		
		System.out.println("You want Another Order ? Yes / No");
		nextOrder = sc.nextLine();
		
		}while("Yes".equalsIgnoreCase(nextOrder));
		
		methods.showInvoice(orders);
;

		
	}

}