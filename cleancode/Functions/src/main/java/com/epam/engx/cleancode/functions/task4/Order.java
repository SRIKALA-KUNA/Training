package com.epam.engx.cleancode.functions.task4;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.Iterator;
import java.util.List;

public class Order {

	private List<Product> products;
	double orderPrice = 0.0;

	public Double getPriceOfAvailableProducts() {

		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product p = iterator.next();
			if (!p.isAvailable())
				iterator.remove();
		}

		getProductPrice();
		return orderPrice;
	}
	public void getProductPrice() {
		
		for (Product p : products)
			orderPrice += p.getProductPrice();
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
