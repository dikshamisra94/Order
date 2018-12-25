package com.infoain.test;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.infogain.order.CommonMethods;

class OrderSampleTest {

	@Test
	void test() {
		CommonMethods method = new CommonMethods();
		System.out.println("Sample 1");
		Map<String,Integer> order1 = new HashMap<String,Integer>();
		order1.put("Large|PanCrust|Margarita|Capsicum,Onion,Jalapeno|Mozzarella", 285);
		order1.put("Small|NormalCrust|Margarita|Paneer,Onion,Jalapeno|Mozzarella,Double", 135);
		method.showInvoice(order1);
		System.out.println("Sample 2");
		Map<String,Integer> order2 = new HashMap<String,Integer>();
		order2.put("Medium|CheesyBites|Margarita|Paneer,Onion,Toamto|Mozzarella", 246);
		order2.put("Small|Thin|MaxicanSalsa|Onion,RedPepper|CreamCheese", 130);

		method.showInvoice(order2);

	}

}
