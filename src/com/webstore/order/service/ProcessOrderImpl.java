package com.webstore.order.service;

import java.util.HashMap;

import com.webstore.order.constants.OFFER;
import com.webstore.order.exception.FruitStoreException;
import com.webstore.order.model.FruitSpecification;

/**
 * Implementation class to process order.
 */
public class ProcessOrderImpl implements ProcessOrder {

	/**
	 * method to add items in the fruit store.
	 */
	public void loadStore(String name, Double price, OFFER offer, Integer quantity, boolean isOffer)
			throws FruitStoreException {
		FruitSpecification fruit = new FruitSpecification();
		fruit.setItemName(name);
		fruit.setItemPrice(price);
		fruit.setOffers(offer);
		fruit.setQuantity(quantity);
		fruit.setOffer(isOffer);
		storeItems.put(name, fruit);
	}

	/**
	 * Method to add fruits in customer basket.
	 */
	public HashMap<String, Integer> loadCustomerBasket(String name, Integer quantity) throws FruitStoreException {
		customerBasket.put(name, quantity);
		return customerBasket;
	}

	/**
	 * Method to process the customer order.
	 * Check store quantity, customer quantity , 
	 * check if any promotions applied and 
	 * process the customer basket with billing cost.
	 */
	public Double processCustomerOrder(HashMap<String, Integer> customerBasket) throws FruitStoreException {
		Double totalBasketCost = 0.0;
		boolean flag = false;
		Integer quantity = 0;
		try {
			for (String name : customerBasket.keySet()) {
				if (null != customerBasket.get(name)) {
					if (storeItems.get(name).getQuantity() <= 0) {
						throw new FruitStoreException("Sorry! " + name + " is not available in the store.");
					}else if (customerBasket.get(name) <= 0) {
						throw new FruitStoreException("Please enter valid/positive quantity value");
					} else if (storeItems.get(name).getQuantity() < customerBasket.get(name)) {
						throw new FruitStoreException("Sorry! Sufficient quantity of " + name + " is not availble");
					} else {
						flag = true;
						totalBasketCost = totalBasketCost + checkOffers(customerBasket, totalBasketCost, name);
						quantity = storeItems.get(name).getQuantity() - customerBasket.get(name);
						storeItems.get(name).setQuantity(quantity);
					}
				}
			}
		} catch (NullPointerException e) {
			throw new FruitStoreException(" Quantity can not be null.");
		}
		if (flag) {
			System.out.println("Your total bill is : " + totalBasketCost);
			customerBasket.clear();
		}
		return totalBasketCost;

	}

	/**
	 * Check offers aplied and update the final cost of the basket.
	 */
	private Double checkOffers(HashMap<String, Integer> customerBasket, Double totalBasketCost, String name) {
		if (storeItems.get(name).isOffer()) {
			if (OFFER.PROMOTIONAL_OFFER.equals(storeItems.get(name).getOffers())) {
				System.out.println("Promotional offer of  Rs.10 off applied on " + name);
				totalBasketCost = storeItems.get(name).getItemPrice() * customerBasket.get(name) - 10.0;
			}
			if (OFFER.DISCOUNT_IN_PERCENT.equals(storeItems.get(name).getOffers())) {
				System.out.println("additional 10% discount on product " + name);
				totalBasketCost = (storeItems.get(name).getItemPrice() * customerBasket.get(name))-(storeItems.get(name).getItemPrice() * customerBasket.get(name) * 0.10);
			}
		}
		return totalBasketCost;
	}
}
