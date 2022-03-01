package com.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.wrapper.NetPricePerItem;

public class GenerateBill {

	private List<NetPricePerItem> lstProducts = new ArrayList<>();

	public void addProduct(NetPricePerItem product) {
		lstProducts.add(product);
	}

	public void removeProduct(NetPricePerItem product) {
		lstProducts.remove(product);
	}

	public double calculateTotalBill() {
		double sum = 0;
		for (NetPricePerItem netPricePerItem : lstProducts) {
			sum += netPricePerItem.getQuantity() * netPricePerItem.getProduct().getPrice();
		}
		return sum;
	}

}
