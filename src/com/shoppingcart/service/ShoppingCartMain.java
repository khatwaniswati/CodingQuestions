package com.shoppingcart.service;

import com.shoppingcart.wrapper.NetPricePerItem;
import com.shoppingcart.wrapper.Product;

public class ShoppingCartMain {

	public static void main(String[] args) {
		GenerateBill bill = new GenerateBill();
		bill.addProduct(new NetPricePerItem(new Product("Water", 20), 2));
		bill.addProduct(new NetPricePerItem(new Product("Salt", 28), 1));

		System.out.println("Total bill is :" + bill.calculateTotalBill());
	}

}