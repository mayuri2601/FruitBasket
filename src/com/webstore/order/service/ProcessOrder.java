package com.webstore.order.service;

import java.util.HashMap;

import com.webstore.order.constants.OFFER;
import com.webstore.order.exception.FruitStoreException;
import com.webstore.order.model.FruitSpecification;

public interface ProcessOrder {
	public static HashMap<String, FruitSpecification> storeItems = new HashMap<>();
	public static HashMap<String, Integer> customerBasket = new HashMap<>();
	public void loadStore(String name, Double price, OFFER offer, Integer quantity, boolean isoffer) throws FruitStoreException;
	
	public HashMap<String, Integer> loadCustomerBasket(String name, Integer quantity) throws FruitStoreException ;
	
	public Double processCustomerOrder(HashMap<String, Integer> customerBasket) throws FruitStoreException;

}
