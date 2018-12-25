package com.infogain.utils;

public enum PizzaBaseEnum {
	Normal(75) , PanCrust(100) , ThinCrust(100) , CheesyBites(125) ; 
	
	private final int value;
	
	private PizzaBaseEnum(int value) {
		this.value = value;
	}
	public Integer toInteger() {
		return value;
	}
}
