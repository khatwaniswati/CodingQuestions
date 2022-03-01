package com.shoppingcart.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NetPricePerItem {

	private Product product;
	private int quantity;
}
